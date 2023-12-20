package pl.mateusz1364.tasksapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pl.mateusz1364.tasksapplication.cache.LoginCache;
import pl.mateusz1364.tasksapplication.client.BackendClient;
import pl.mateusz1364.tasksapplication.utils.ToastUtils;

public class TasksActivity extends AppCompatActivity {
    private final BackendClient backendClient = new BackendClient();
    private TasksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        TextView userLoggedName = findViewById(R.id.userName);
        String userName = LoginCache.getInstance()
            .getUserData()
            .getName();
        userLoggedName.setText(userName);

        adapter = new TasksAdapter(this::onClickNavigateButton);
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        String accessToken = LoginCache.getInstance()
            .getUserData()
            .getAccessToken();
        backendClient.callTasksForUser(accessToken,
            it -> it.forEach(adapter::addItem),
            () -> ToastUtils.showToast("Problem while fetching tasks", this));
    }

    private void onClickNavigateButton(Task task) {
        Uri gmmIntentUri = Uri.parse(String.format("google.navigation:q=%s,+%s",
            replaceSpaceToPlus(task.getCity()), replaceSpaceToPlus(task.getStreet())));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    private String replaceSpaceToPlus(String string) {
        return string.replace(" ", "+");
    }
}
