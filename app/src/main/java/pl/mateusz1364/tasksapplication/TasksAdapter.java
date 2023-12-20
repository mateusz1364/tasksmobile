package pl.mateusz1364.tasksapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {
    private final List<Task> items = new ArrayList<>();
    private final OnClickListener onClickListener;

    public TasksAdapter(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void addItem(Task item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_task, parent, false);
        return new TasksViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        Task item = items.get(position);
        holder.bind(item, onClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
