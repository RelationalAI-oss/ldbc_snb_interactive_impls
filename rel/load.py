#!/usr/bin/env python3

import json
import logging
import os
import tempfile

from railib import api, config, show

def main(argv=None):
    file, filename = tempfile.mkstemp()

    os.write(file, "[default]\nscheme = http\nhost = 127.0.0.1\nport = 8010".encode())
    os.close(file)

    cfg = config.read(fname = filename)
    ctx = api.Context(**cfg)

    # create database
    txn = api.Transaction("snb", "local", False, api.Mode.CREATE_OVERWRITE)

    rsp = txn.run(ctx)
    print(json.dumps(rsp, indent=2))

    rsp = api.query(ctx, "snb", "local", "def insert:datadir = \"{}/test-data\"".format(os.getcwd()), readonly=False)

    f = open("./ddl/dataload_configuration.rel", "r")
    dataload_query_str = f.read()

    rsp = api.query(ctx, "snb", "local", dataload_query_str, readonly=False)
    print(json.dumps(rsp, indent=2))

    f = open("./ddl/common.rel", "r")
    common_model = {"common": f.read()}

    rsp = api.install_model(ctx, "snb", "local", common_model)
    print(json.dumps(rsp, indent=2))

    rsp = api.list_models(ctx, "snb", "local")
    print(json.dumps(rsp, indent=2))

    rsp = api.list_edbs(ctx, "snb", "local")
    print(json.dumps(rsp, indent=2))

    os.remove(filename)

    rsp = api.query(ctx, "snb", "local", "def output:x = 1")
    print(json.dumps(rsp, indent=2))

if __name__ == "__main__":
    main()
