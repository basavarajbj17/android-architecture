package co.techmagic.data.api;

import co.techmagic.data.api.model.CreateUserRequest;
import co.techmagic.data.api.model.GetUserRequest;

public interface IUserApi {
    <T> void createUser(CreateUserRequest request, ApiClientCallback<T> callback);

    <T> void getUser(GetUserRequest request, ApiClientCallback<T> callback);
}
