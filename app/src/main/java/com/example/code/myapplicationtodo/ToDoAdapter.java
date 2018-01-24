package com.example.code.myapplicationtodo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.TodoViewHolder> {


    private static final String TAG = ToDoAdapter.class.getSimpleName();
    private List<Todo> todoList;

    public ToDoAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "On create view Holder");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.todo_list_item, parent, false);
        return new ToDoAdapter.TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        Log.d(TAG, "On Bind View Holder: " + todo);
        holder.todoTitleTextView.setText(todo.getTodo());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView todoTitleTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            todoTitleTextView = itemView.findViewById(R.id.todo_title);
        }
    }
}