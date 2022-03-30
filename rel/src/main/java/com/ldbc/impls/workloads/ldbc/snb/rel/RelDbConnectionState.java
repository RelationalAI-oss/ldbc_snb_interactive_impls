package com.ldbc.impls.workloads.ldbc.snb.rel;

import com.ldbc.driver.DbException;
import com.ldbc.impls.workloads.ldbc.snb.BaseDbConnectionState;
import com.relationalai.Client;
import com.relationalai.Config;
import com.relationalai.Database;
import com.relationalai.HttpError;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class RelDbConnectionState extends BaseDbConnectionState<RelQueryStore> {

    protected Client client;

    public RelDbConnectionState(Map<String, String> properties, RelQueryStore store) throws IOException {
        super(properties, store);

        InputStream cfgStream = new ByteArrayInputStream(String.format("[default]\nscheme = http\nhost = 127.0.0.1\nport = 8010").getBytes());
        Config cfg = Config.loadConfig(cfgStream);
        client = new Client(cfg);
    }

    public Client getClient() throws DbException {
        return client;
    }

    @Override
    public void close() {

    }
}
