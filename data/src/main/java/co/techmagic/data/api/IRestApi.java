package co.techmagic.data.api;

import org.springframework.http.HttpEntity;

import co.techmagic.data.api.model.Request;

public interface IRestApi {

    /**
     * Performs get request
     *
     * @param url url of the resource
     * @param callback request result callback
     */
    <T> void get(String url, ApiClientCallback<T> callback, Class clazz);

    /**
     * Performs post request
     *
     * @param url url of the resource
     * @param request request data
     * @param callback request result callback
     */
    <T> void post(String url, Request request, ApiClientCallback<T> callback, Class clazz);

    /**
     * Performs put request
     *
     * @param url url of the resource
     * @param request request data
     * @param callback request result callback
     */
    <T> void put(String url, Request request, ApiClientCallback<T> callback, Class clazz);

    /**
     * Performs delete request
     *
     * @param url url of the resource
     * @param callback request result callback
     */
    <T> void delete(String url, ApiClientCallback<T> callback, Class clazz);

}
