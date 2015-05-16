package jp.gr.java_conf.shioyang.simpletodolist;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by shioyang.
 */
public interface TodoList {
    void setTodoItems(ArrayList<TodoItem> todoItemArray);
    ArrayList<TodoItem> getTodoItems();

    TodoItem getTodoItem(int position);

    void save(Context context);
    void load(Context context);

    void addTodoItem(int position);
    void addTodoItem(int position, TodoItem todoItem);
    void addTodoItemToLast();

    void removeTodoItem(int position);
    void doneTodoItem(int position);
    void undoneTodoItem(int position);

    void swapTodoItem(int position, Boolean isUp);

    int size();
}
