package com.ldbc.impls.workloads.ldbc.snb.rel.operationhandlers;

import com.ldbc.driver.DbException;
import com.ldbc.driver.Operation;
import com.ldbc.driver.ResultReporter;
import com.ldbc.impls.workloads.ldbc.snb.operationhandlers.SingletonOperationHandler;
import com.ldbc.impls.workloads.ldbc.snb.rel.RelDbConnectionState;
import com.relationalai.Client;
import com.relationalai.TransactionResult;

public abstract class RelSingletonOperationHandler<TOperation extends Operation<TOperationResult>, TOperationResult>
        extends RelOperationHandler
        implements SingletonOperationHandler<TOperationResult, TOperation, RelDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, RelDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {
        Client client = state.getClient();
        TOperationResult tuple = null;
        int resultCount = 0;

        String queryString = getQueryString(state, operation);
        try {
            TransactionResult result = client.execute("snb", null, queryString, true);
            tuple = convertSingleResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resultReporter.report(resultCount, tuple, operation);
    }

    public abstract TOperationResult convertSingleResult(TransactionResult result);
}
