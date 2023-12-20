package pl.mateusz1364.tasksapplication.client;

import pl.mateusz1364.tasksapplication.Task;
import pl.mateusz1364.tasksapplication.UserData;
import pl.mateusz1364.tasksapplication.client.dto.AuthenticationDto;
import pl.mateusz1364.tasksapplication.client.dto.TaskCollectionDto;
import pl.mateusz1364.tasksapplication.utils.DateUtils;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BackendClient {
    private static final String BACKEND_BASE_URL = "http://XXX.XXX.XXX.XXX:8080";
    private final Retrofit retrofit = RetrofitClient.getClient(BACKEND_BASE_URL);
    private final BackendRetrofitService retrofitService = retrofit.create(BackendRetrofitService.class);

    public void callAuthenticateUser(String login, String password,
                                     SuccessCallback<UserData> successCallback,
                                     FailureCallback failureCallback) {
        Call<AuthenticationDto> call = retrofitService.authenticate(login, password);
        call.enqueue(new Callback<AuthenticationDto>() {

            @Override
            public void onResponse(Call<AuthenticationDto> call, Response<AuthenticationDto> response) {
                if (response.isSuccessful()) {
                    AuthenticationDto dto = response.body();
                    String accessToken = dto.getAccessToken();
                    successCallback.onSuccess(new UserData(
                        dto.getFirstName() + " " + dto.getLastName(),
                        accessToken));
                } else {
                    failureCallback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<AuthenticationDto> call, Throwable t) {
                failureCallback.onFailure();
            }
        });
    }

    public void callTasksForUser(String accessToken,
                                 SuccessCallback<List<Task>> successCallback,
                                 FailureCallback failureCallback) {
        Call<TaskCollectionDto> call = retrofitService.getTasks(accessToken);
        call.enqueue(new Callback<TaskCollectionDto>() {

            @Override
            public void onResponse(Call<TaskCollectionDto> call, Response<TaskCollectionDto> response) {
                if (response.isSuccessful()) {
                    TaskCollectionDto dto = response.body();
                    List<Task> tasks = dto.getTasks()
                        .stream()
                        .map(it -> new Task(
                            DateUtils.formatEpochMs(it.getCreateAtMs()) + ": " + it.getName(),
                            it.getDescription(),
                            it.getReporterFirstName() + " " + it.getReporterLastName(),
                            it.getCity(),
                            it.getStreetWithNumber()))
                        .collect(Collectors.toList());
                    successCallback.onSuccess(tasks);
                } else {
                    failureCallback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<TaskCollectionDto> call, Throwable t) {
                failureCallback.onFailure();
            }
        });

    }
}
