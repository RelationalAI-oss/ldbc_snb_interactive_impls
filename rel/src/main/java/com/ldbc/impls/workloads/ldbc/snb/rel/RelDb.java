package com.ldbc.impls.workloads.ldbc.snb.rel;

import com.ldbc.driver.DbException;
import com.ldbc.driver.ResultReporter;
import com.ldbc.driver.control.LoggingService;
import com.ldbc.driver.workloads.ldbc.snb.interactive.*;
import com.ldbc.impls.workloads.ldbc.snb.QueryStore;
import com.ldbc.impls.workloads.ldbc.snb.db.BaseDb;
import com.ldbc.impls.workloads.ldbc.snb.rel.operationhandlers.RelListOperationHandler;
import com.ldbc.impls.workloads.ldbc.snb.rel.operationhandlers.RelSingletonOperationHandler;
import com.ldbc.impls.workloads.ldbc.snb.rel.operationhandlers.RelUpdateOperationHandler;
import com.relationalai.Client;
import com.relationalai.TransactionResult;

import java.util.ArrayList;
import java.util.Map;

public abstract class RelDb extends BaseDb<RelQueryStore> {

    @Override
    protected void onInit(Map<String, String> properties, LoggingService loggingService) throws DbException {
        try {
            dcs = new RelDbConnectionState(properties, new RelQueryStore(properties.get("queryDir")));
        } catch (Exception e) {
            throw new DbException(e);
        }
    }

    // Interactive complex reads

    public static class Query1 extends RelListOperationHandler<LdbcQuery1, LdbcQuery1Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery1 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery1);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.firstName", operation.firstName());
            return queryString;
        }

        @Override
        public LdbcQuery1Result convertSingleResult(TransactionResult result) {
            System.out.println(result);
            /*LdbcQuery1Result qr = new LdbcQuery1Result(
                    1,
                    "t",
                    1,
                    1L,
                    1L,
                    "t",
                    "t",
                    "t",
                    new ArrayList<>(),
                    new ArrayList<>(),
                    "t",
                    new ArrayList<>(),
                    new ArrayList<>());
            return qr;*/
            return null;
        }
    }

    public static class Query2 extends RelListOperationHandler<LdbcQuery2, LdbcQuery2Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery2 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery2);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.maxDate", String.valueOf(operation.maxDate().getTime()));
            return queryString;
        }

        @Override
        public LdbcQuery2Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query3 extends RelListOperationHandler<LdbcQuery3, LdbcQuery3Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery3 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery3);
            queryString = queryString
                    .replace("sub_params.countryXName", operation.countryXName())
                    .replace("sub_params.countryYName", operation.countryYName())
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.startDate", String.valueOf(operation.startDate().getTime()))
                    .replace("sub_params.durationDays", String.valueOf(operation.durationDays()));
            return queryString;
        }

        @Override
        public LdbcQuery3Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query4 extends RelListOperationHandler<LdbcQuery4, LdbcQuery4Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery4 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery4);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.startDate", String.valueOf(operation.startDate().getTime()))
                    .replace("sub_params.durationDays", String.valueOf(operation.durationDays()));
            return queryString;
        }

        @Override
        public LdbcQuery4Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query5 extends RelListOperationHandler<LdbcQuery5, LdbcQuery5Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery5 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery5);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.minDate", String.valueOf(operation.minDate().getTime()));
            return queryString;
        }

        @Override
        public LdbcQuery5Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query6 extends RelListOperationHandler<LdbcQuery6, LdbcQuery6Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery6 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery6);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.tagName", operation.tagName());
            return queryString;
        }

        @Override
        public LdbcQuery6Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query7 extends RelListOperationHandler<LdbcQuery7, LdbcQuery7Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery7 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery7);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()));
            return queryString;
        }

        @Override
        public LdbcQuery7Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query8 extends RelListOperationHandler<LdbcQuery8, LdbcQuery8Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery8 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery8);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()));
            return queryString;
        }

        @Override
        public LdbcQuery8Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query9 extends RelListOperationHandler<LdbcQuery9, LdbcQuery9Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery9 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery9);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.maxDate", String.valueOf(operation.maxDate().getTime()));
            return queryString;
        }

        @Override
        public LdbcQuery9Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query10 extends RelListOperationHandler<LdbcQuery10, LdbcQuery10Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery10 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery10);
            queryString = queryString
                    .replace("sub_params.month", String.valueOf(operation.month()))
                    .replace("sub_params.personId", String.valueOf(operation.personId()));
            return queryString;
        }

        @Override
        public LdbcQuery10Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query11 extends RelListOperationHandler<LdbcQuery11, LdbcQuery11Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery11 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery11);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.countryName", operation.countryName())
                    .replace("sub_params.workFromYear", String.valueOf(operation.workFromYear()));
            return queryString;
        }

        @Override
        public LdbcQuery11Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query12 extends RelListOperationHandler<LdbcQuery12, LdbcQuery12Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery12 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery12);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()))
                    .replace("sub_params.tagClassName", operation.tagClassName());
            return queryString;
        }

        @Override
        public LdbcQuery12Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Query13 extends RelSingletonOperationHandler<LdbcQuery13, LdbcQuery13Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery13 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery13);
            queryString = queryString
                    .replace("sub_params.person1Id", String.valueOf(operation.person1Id()))
                    .replace("sub_params.person2Id", String.valueOf(operation.person2Id()));
            return queryString;
        }

        @Override
        public LdbcQuery13Result convertSingleResult(TransactionResult result) {
            return new LdbcQuery13Result(1);
        }

    }

    public static class Query14 extends RelListOperationHandler<LdbcQuery14, LdbcQuery14Result> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcQuery14 operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveComplexQuery14);
            queryString = queryString
                    .replace("sub_params.person1Id", String.valueOf(operation.person1Id()))
                    .replace("sub_params.person2Id", String.valueOf(operation.person2Id()));
            return queryString;
        }

        @Override
        public LdbcQuery14Result convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery1PersonProfile extends RelSingletonOperationHandler<LdbcShortQuery1PersonProfile, LdbcShortQuery1PersonProfileResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery1PersonProfile operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery1);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery1PersonProfileResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery2PersonPosts extends RelListOperationHandler<LdbcShortQuery2PersonPosts, LdbcShortQuery2PersonPostsResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery2PersonPosts operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery2);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery2PersonPostsResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery3PersonFriends extends RelListOperationHandler<LdbcShortQuery3PersonFriends, LdbcShortQuery3PersonFriendsResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery3PersonFriends operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery3);
            queryString = queryString
                    .replace("sub_params.personId", String.valueOf(operation.personId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery3PersonFriendsResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery4MessageContent extends RelSingletonOperationHandler<LdbcShortQuery4MessageContent, LdbcShortQuery4MessageContentResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery4MessageContent operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery4);
            queryString = queryString
                    .replace("sub_params.messageId", String.valueOf(operation.messageId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery4MessageContentResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery5MessageCreator extends RelSingletonOperationHandler<LdbcShortQuery5MessageCreator, LdbcShortQuery5MessageCreatorResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery5MessageCreator operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery5);
            queryString = queryString
                    .replace("sub_params.messageId", String.valueOf(operation.messageId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery5MessageCreatorResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery6MessageForum extends RelSingletonOperationHandler<LdbcShortQuery6MessageForum, LdbcShortQuery6MessageForumResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery6MessageForum operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery6);
            queryString = queryString
                    .replace("sub_params.messageId", String.valueOf(operation.messageId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery6MessageForumResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class ShortQuery7MessageReplies extends RelListOperationHandler<LdbcShortQuery7MessageReplies, LdbcShortQuery7MessageRepliesResult> {

        @Override
        public String getQueryString(RelDbConnectionState state, LdbcShortQuery7MessageReplies operation) {
            String queryString = state.getQueryStore().getParameterizedQuery(QueryStore.QueryType.InteractiveShortQuery7);
            queryString = queryString
                    .replace("sub_params.messageId", String.valueOf(operation.messageId()));
            return queryString;
        }

        @Override
        public LdbcShortQuery7MessageRepliesResult convertSingleResult(TransactionResult result) {
            return null;
        }

    }

    public static class Update1AddPerson extends RelUpdateOperationHandler<LdbcUpdate1AddPerson> {

        @Override
        public void executeOperation(LdbcUpdate1AddPerson operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

    public static class Update2AddPostLike extends RelUpdateOperationHandler<LdbcUpdate2AddPostLike> {

        @Override
        public void executeOperation(LdbcUpdate2AddPostLike operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

    public static class Update3AddCommentLike extends RelUpdateOperationHandler<LdbcUpdate3AddCommentLike> {

        @Override
        public void executeOperation(LdbcUpdate3AddCommentLike operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();

            resultReporter.report(0, LdbcNoResult.INSTANCE, operation);
        }

    }

    public static class Update4AddForum extends RelUpdateOperationHandler<LdbcUpdate4AddForum> {

        @Override
        public void executeOperation(LdbcUpdate4AddForum operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

    public static class Update5AddForumMembership extends RelUpdateOperationHandler<LdbcUpdate5AddForumMembership> {

        @Override
        public void executeOperation(LdbcUpdate5AddForumMembership operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

    public static class Update6AddPost extends RelUpdateOperationHandler<LdbcUpdate6AddPost> {

        @Override
        public void executeOperation(LdbcUpdate6AddPost operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

    public static class Update7AddComment extends RelUpdateOperationHandler<LdbcUpdate7AddComment> {

        @Override
        public void executeOperation(LdbcUpdate7AddComment operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

    public static class Update8AddFriendship extends RelUpdateOperationHandler<LdbcUpdate8AddFriendship> {

        @Override
        public void executeOperation(LdbcUpdate8AddFriendship operation, RelDbConnectionState state, ResultReporter resultReporter) throws DbException {
            Client client = state.getClient();
        }

    }

}
