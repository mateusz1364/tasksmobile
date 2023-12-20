package pl.mateusz1364.tasksapplication.cache;

import pl.mateusz1364.tasksapplication.UserData;

public class LoginCache {
    private static LoginCache instance = null;
    private UserData userData;

    private LoginCache() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    public static LoginCache getInstance() {
        if (instance == null) {
            instance = new LoginCache();
        }
        return instance;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
