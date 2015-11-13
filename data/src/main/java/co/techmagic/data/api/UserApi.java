package co.techmagic.data.api;

import co.techmagic.data.api.model.CreateUserRequest;
import co.techmagic.data.api.model.GetUserRequest;
import co.techmagic.data.dataprovider.model.User;

public class UserApi extends SpringRestApi implements IUserApi {

    private static final String GET_USER_URL = "http://demo1031398.mockable.io/";

    @Override
    public <T> void createUser(CreateUserRequest request, ApiClientCallback<T> callback) {
        post(GET_USER_URL, request, callback, CreateUserRequest.class);
    }

    @Override
    public <T> void getUser(GetUserRequest request, ApiClientCallback<T> callback) {
        get(GET_USER_URL + request.toUrl(), callback, User.class);
    }
}
