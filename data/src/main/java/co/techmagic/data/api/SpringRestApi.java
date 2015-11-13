package co.techmagic.data.api;

import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import co.techmagic.data.api.model.CreateUserRequest;
import co.techmagic.data.api.model.Request;


/**
 * Created by nvrubl on 12.11.15.
 */
public abstract class SpringRestApi implements IRestApi {

    private static final String TAG = "SPRING_REST_API";

    @Override
    public <T> void get(String url, ApiClientCallback<T> callback, Class clazz) {
        handleRequest(url, HttpMethod.GET, null, callback, clazz);
    }

    @Override
    public <T> void post(String url, Request request, ApiClientCallback<T> callback, Class clazz) {
        handleRequest(url, HttpMethod.POST, request, callback, clazz);
    }

    @Override
    public <T> void put(String url, Request request, ApiClientCallback<T> callback, Class clazz) {
        handleRequest(url, HttpMethod.PUT, request, callback, clazz);
    }

    @Override
    public <T> void delete(String url, ApiClientCallback<T> callback, Class clazz) {
        handleRequest(url, HttpMethod.DELETE, null, callback, clazz);
    }

    private <T> void handleRequest(String url, HttpMethod httpMethod, Request request, ApiClientCallback<T> callback, Class clazz) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        ResponseEntity<T> responseEntity;
        HttpStatus statusCode;
        String body;
        try {
            if(httpMethod.equals(HttpMethod.GET) || httpMethod.equals(HttpMethod.DELETE)) {
                 responseEntity = restTemplate.exchange(url, httpMethod, null, clazz);
            } else {
                HttpHeaders httpHeaders = new HttpHeaders();
                HttpEntity<Request> httpEntity = new HttpEntity<>(request, httpHeaders);
                responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, clazz);
            }
            callback.onSuccess(responseEntity.getBody());
        } catch (HttpServerErrorException ex) {
            statusCode = ex.getStatusCode();
            body = ex.getResponseBodyAsString();
            Log.w(TAG, "HttpServerErrorException(" + statusCode + "): " + ex.getMessage());
            Log.w(TAG, "HttpServerErrorException(" + body + "): " + ex.getMessage());
            callback.onError(statusCode.value(), ex.getMessage());
        } catch (HttpStatusCodeException ex) {
            statusCode = ex.getStatusCode();
            Log.w(TAG, "HttpStatusCodeException(" + statusCode + "): " + ex.getMessage());
            Log.w(TAG, "Response Code: " + ex.getStatusCode());
            Log.w(TAG, "Response Body: " + ex.getResponseBodyAsString());
            callback.onError(statusCode.value(), ex.getMessage());
        }
    }
}
