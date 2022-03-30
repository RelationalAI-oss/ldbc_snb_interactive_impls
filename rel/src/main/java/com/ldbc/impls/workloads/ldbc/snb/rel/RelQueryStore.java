package com.ldbc.impls.workloads.ldbc.snb.rel;

import com.ldbc.driver.DbException;
import com.ldbc.impls.workloads.ldbc.snb.QueryStore;
import com.ldbc.impls.workloads.ldbc.snb.converter.Converter;
import com.ldbc.impls.workloads.ldbc.snb.rel.converter.RelConverter;

public class RelQueryStore extends QueryStore {

    protected Converter getConverter() {
        return new RelConverter();
    }

    public RelQueryStore(String path) throws DbException {
        super(path, ".rel");
    }

}
