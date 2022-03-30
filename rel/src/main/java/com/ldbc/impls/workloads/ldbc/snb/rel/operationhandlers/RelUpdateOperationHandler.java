package com.ldbc.impls.workloads.ldbc.snb.rel.operationhandlers;

import com.ldbc.driver.Operation;
import com.ldbc.driver.workloads.ldbc.snb.interactive.LdbcNoResult;
import com.ldbc.impls.workloads.ldbc.snb.operationhandlers.UpdateOperationHandler;
import com.ldbc.impls.workloads.ldbc.snb.rel.RelDbConnectionState;

public abstract class RelUpdateOperationHandler<TOperation extends Operation<LdbcNoResult>>
        extends RelOperationHandler
        implements UpdateOperationHandler<TOperation, RelDbConnectionState> {

    @Override
    public String getQueryString(RelDbConnectionState state, TOperation operation) {
        throw new IllegalStateException();
    }

}
