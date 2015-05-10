package jp.gr.java_conf.shioyang.simpletodolist;

import java.util.ArrayList;

/**
 * Created by shioyang.
 */
public interface TodoList {
    void setTodoItems(ArrayList<TodoItem> todoItemArray);
    ArrayList<TodoItem> getTodoItems();

    void save();

    void addTodoItem(int position, TodoItem todoItem);
    void removeTodoItem(int position);
    void doneTodoItem(int position);
    void undoneTodoItem(int position);

    void swapTodoItem(int position, Boolean isUp);
}
