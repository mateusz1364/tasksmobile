package pl.mateusz1364.tasksapplication.client;

import pl.mateusz1364.tasksapplication.client.dto.AuthenticationDto;
import pl.mateusz1364.tasksapplication.client.dto.TaskCollectionDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BackendRetrofitService {

    @GET("api/v1/internal/tasks")
    Call<TaskCollectionDto> getTasks(@Header("Authorization") String accessToken);

    @POST("api/v1/internal/login")
    Call<AuthenticationDto> authenticate(@Header("X-Auth-Login") String login,
                                         @Header("X-Auth-Password") String password);
}
