package com.ldbc.impls.workloads.ldbc.snb.rel.operationhandlers;

import com.ldbc.driver.DbException;
import com.ldbc.driver.Operation;
import com.ldbc.driver.ResultReporter;
import com.ldbc.impls.workloads.ldbc.snb.operationhandlers.ListOperationHandler;
import com.ldbc.impls.workloads.ldbc.snb.rel.RelDbConnectionState;
import com.relationalai.Client;
import com.relationalai.TransactionResult;

import java.util.ArrayList;
import java.util.List;

public abstract class RelListOperationHandler<TOperation extends Operation<List<TOperationResult>>, TOperationResult>
        extends RelOperationHandler
        implements ListOperationHandler<TOperationResult, TOperation, RelDbConnectionState> {

    @Override
    public void executeOperation(TOperation operation, RelDbConnectionState state,
                                 ResultReporter resultReporter) throws DbException {
        Client client = state.getClient();
        List<TOperationResult> results = new ArrayList<>();
        int resultCount = 0;
        results.clear();

        String queryString = getQueryString(state, operation);

        try {
            TransactionResult result = client.execute("snb", "local", queryString);
            TOperationResult tuple = convertSingleResult(result);

            if (state.isPrintResults()) {
                System.out.println(tuple.toString());
            }
        } catch (Exception e) {
            throw new DbException(e);
        }

        resultReporter.report(resultCount, results, operation);
    }

    public abstract TOperationResult convertSingleResult(TransactionResult result);

}
