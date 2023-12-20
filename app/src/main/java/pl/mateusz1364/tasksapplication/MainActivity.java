package pl.mateusz1364.tasksapplication;

import static pl.mateusz1364.tasksapplication.utils.ToastUtils.showToast;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import pl.mateusz1364.tasksapplication.cache.LoginCache;
import pl.mateusz1364.tasksapplication.client.BackendClient;

public class MainActivity extends AppCompatActivity {
    private final BackendClient backendClient = new BackendClient();
    private EditText loginEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = findViewById(R.id.login);
        passwordEditText = findViewById(R.id.password);

        findViewById(R.id.login_btn).setOnClickListener(view -> login());
    }

    private void login() {
        String login = loginEditText.getText()
            .toString();
        String password = passwordEditText.getText()
            .toString();
        if (login.isEmpty() ||
            password.isEmpty()) {
            return;
        }
        backendClient.callAuthenticateUser(login, password,
            this::handleSuccessfulLogin,
            () -> showToast("Invalid login data", this));
    }

    private void handleSuccessfulLogin(UserData userData) {
        LoginCache.getInstance()
            .setUserData(userData);
        startActivity(new Intent(this, TasksActivity.class));
    }
}