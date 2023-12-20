package pl.mateusz1364.tasksapplication;

public class UserData {
    private final String name;
    private final String accessToken;

    public UserData(String name, String accessToken) {
        this.name = name;
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
