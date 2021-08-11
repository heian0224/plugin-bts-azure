/*
 * WorkItemTracking
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 6.1-preview
 * Contact: nugetvss@microsoft.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.epam.reportportal.extension.azure.rest.client.api;

import com.epam.reportportal.extension.azure.rest.client.ApiCallback;
import com.epam.reportportal.extension.azure.rest.client.ApiClient;
import com.epam.reportportal.extension.azure.rest.client.ApiException;
import com.epam.reportportal.extension.azure.rest.client.ApiResponse;
import com.epam.reportportal.extension.azure.rest.client.Configuration;
import com.epam.reportportal.extension.azure.rest.client.Pair;
import com.epam.reportportal.extension.azure.rest.client.ProgressRequestBody;
import com.epam.reportportal.extension.azure.rest.client.ProgressResponseBody;
import com.epam.reportportal.extension.azure.rest.client.model.workitem.WorkItemClassificationNodeList;
import com.epam.reportportal.extension.azure.rest.client.model.workitem.WorkItemClassificationNode;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassificationNodesApi {
    private ApiClient apiClient;

    public ClassificationNodesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ClassificationNodesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for classificationNodesGetRootNodes
     * @param organization The name of the Azure DevOps organization. (required)
     * @param project Project ID or project name (required)
     * @param apiVersion Version of the API to use.  This should be set to &#39;6.1-preview.2&#39; to use this version of the api. (required)
     * @param depth Depth of children to fetch. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public Call classificationNodesGetRootNodesCall(String organization, String project, String apiVersion, Integer depth, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{organization}/{project}/_apis/wit/classificationnodes"
            .replaceAll("\\{" + "organization" + "\\}", apiClient.escapeString(organization.toString()))
            .replaceAll("\\{" + "project" + "\\}", apiClient.escapeString(project.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (depth != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("$depth", depth));
        if (apiVersion != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("api-version", apiVersion));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2", "accessToken" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private Call classificationNodesGetRootNodesValidateBeforeCall(String organization, String project, String apiVersion, Integer depth, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'organization' is set
        if (organization == null) {
            throw new ApiException("Missing the required parameter 'organization' when calling classificationNodesGetRootNodes(Async)");
        }
        
        // verify the required parameter 'project' is set
        if (project == null) {
            throw new ApiException("Missing the required parameter 'project' when calling classificationNodesGetRootNodes(Async)");
        }
        
        // verify the required parameter 'apiVersion' is set
        if (apiVersion == null) {
            throw new ApiException("Missing the required parameter 'apiVersion' when calling classificationNodesGetRootNodes(Async)");
        }

        Call call = classificationNodesGetRootNodesCall(organization, project, apiVersion, depth, progressListener, progressRequestListener);
        return call;
    }

    /**
     * 
     * Gets root classification nodes under the project.
     * @param organization The name of the Azure DevOps organization. (required)
     * @param project Project ID or project name (required)
     * @param apiVersion Version of the API to use.  This should be set to &#39;6.1-preview.2&#39; to use this version of the api. (required)
     * @param depth Depth of children to fetch. (optional)
     * @return List&lt;WorkItemClassificationNode&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<WorkItemClassificationNode> classificationNodesGetRootNodes(String organization, String project, String apiVersion, Integer depth) throws ApiException {
        ApiResponse<List<WorkItemClassificationNode>> resp = classificationNodesGetRootNodesWithHttpInfo(organization, project, apiVersion, depth);
        return resp.getData();
    }

    /**
     * 
     * Gets root classification nodes under the project.
     * @param organization The name of the Azure DevOps organization. (required)
     * @param project Project ID or project name (required)
     * @param apiVersion Version of the API to use.  This should be set to &#39;6.1-preview.2&#39; to use this version of the api. (required)
     * @param depth Depth of children to fetch. (optional)
     * @return ApiResponse&lt;List&lt;WorkItemClassificationNode&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<WorkItemClassificationNode>> classificationNodesGetRootNodesWithHttpInfo(String organization, String project, String apiVersion, Integer depth) throws ApiException {
        Call call = classificationNodesGetRootNodesValidateBeforeCall(organization, project, apiVersion, depth, null, null);
        Type localVarReturnType = new TypeToken<WorkItemClassificationNodeList>(){}.getType();
        ApiResponse<WorkItemClassificationNodeList> response = apiClient.execute(call, localVarReturnType);
        return new ApiResponse<>(response.getStatusCode(), response.getHeaders(), response.getData().getValue());
    }

    /**
     *  (asynchronously)
     * Gets root classification nodes under the project.
     * @param organization The name of the Azure DevOps organization. (required)
     * @param project Project ID or project name (required)
     * @param apiVersion Version of the API to use.  This should be set to &#39;6.1-preview.2&#39; to use this version of the api. (required)
     * @param depth Depth of children to fetch. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public Call classificationNodesGetRootNodesAsync(String organization, String project, String apiVersion, Integer depth, final ApiCallback<List<WorkItemClassificationNode>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        Call call = classificationNodesGetRootNodesValidateBeforeCall(organization, project, apiVersion, depth, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<WorkItemClassificationNode>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
