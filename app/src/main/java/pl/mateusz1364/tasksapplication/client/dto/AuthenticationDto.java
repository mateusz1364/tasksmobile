package pl.mateusz1364.tasksapplication.client.dto;

public class AuthenticationDto {
    private String firstName;
    private String lastName;
    private String accessToken;

    public AuthenticationDto(String firstName, String lastName, String accessToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
