package pl.mateusz1364.tasksapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TasksViewHolder extends RecyclerView.ViewHolder {
    private final TextView name, description, reporter, address, navigateButton;

    public TasksViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameTextView);
        description = itemView.findViewById(R.id.descriptionTextView);
        reporter = itemView.findViewById(R.id.reporterTextView);
        address = itemView.findViewById(R.id.addressTextView);
        navigateButton = itemView.findViewById(R.id.navigateBtn);
    }

    public void bind(Task item, OnClickListener onClickListener) {
        name.setText(item.getDateWithName());
        description.setText(item.getDescription());
        reporter.setText(item.getReporter());
        address.setText(item.getCity() + ", " + item.getStreet());
        navigateButton.setOnClickListener(v -> onClickListener.onClick(item));
    }
}
