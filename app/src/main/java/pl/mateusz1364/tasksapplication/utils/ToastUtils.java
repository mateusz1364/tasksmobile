package pl.mateusz1364.tasksapplication.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showToast(String text, Context context) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
