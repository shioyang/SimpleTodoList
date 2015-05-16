package jp.gr.java_conf.shioyang.simpletodolist;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by shioyang.
 */
public class TodoListImpl implements TodoList {
    ArrayList<TodoItem> todoItemArray;

    public TodoListImpl() {
        setTodoItems(new ArrayList<TodoItem>());
    }

    public TodoListImpl(ArrayList<TodoItem> todoItemArray) {
        setTodoItems(todoItemArray);
    }

    @Override
    public void setTodoItems(ArrayList<TodoItem> todoItemArray) {
        this.todoItemArray = todoItemArray;
    }

    @Override
    public ArrayList<TodoItem> getTodoItems() {
        return todoItemArray;
    }

    @Override
    public TodoItem getTodoItem(int position) {
        return todoItemArray.get(position);
    }

    @Override
    public void save(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        editor.putString(context.getResources().getString(R.string.pref_todo_list_array_json), gson.toJson(todoItemArray));
        //test
        Log.d("TodoListImple.save()", gson.toJson(todoItemArray));
        //test
        editor.apply();
    }

    @Override
    public void load(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String json = pref.getString(context.getResources().getString(R.string.pref_todo_list_array_json), null);
        Log.d("TodoListImple.load", "pref.getString: " + json);

        todoItemArray.clear();
        if (json != null) {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<TodoItemImpl>>(){}.getType();
            ArrayList<TodoItem> array = gson.fromJson(json, listType);
            for (TodoItem todoItem : array) {
                todoItemArray.add(todoItem);
            }
        }
    }

    @Override
    public void addTodoItem(int position) {
        if (0 <= position && position <= todoItemArray.size())
            todoItemArray.add(position, new TodoItemImpl());
    }

    @Override
    public void addTodoItem(int position, TodoItem todoItem) {
        if (0 <= position && position <= todoItemArray.size())
            todoItemArray.add(position, todoItem);
    }

    @Override
    public void addTodoItemToLast() {
        int position = todoItemArray.size();
        addTodoItem(position);
    }

    @Override
    public void removeTodoItem(int position) {
        if (0 <= position && position < todoItemArray.size())
            todoItemArray.remove(position);
    }

    @Override
    public void doneTodoItem(int position) {
        _doneTodoItem(position, true);
    }

    @Override
    public void undoneTodoItem(int position) {
        _doneTodoItem(position, false);
    }
    
    private void _doneTodoItem(int position, Boolean isDone) {
        if (0 <= position && position < todoItemArray.size()) {
            TodoItem todoItem = todoItemArray.get(position);
            todoItem.setIsDone(isDone);
        }
    }

    @Override
    public void swapTodoItem(int position, Boolean isUp) {
        int newPosition = position + (isUp ? -1 : 1);
        if (newPosition < 0 || todoItemArray.size() <= newPosition)
            return;
        TodoItem todoItem = todoItemArray.get(position);
        todoItemArray.set(position, todoItemArray.get(newPosition));
        todoItemArray.set(newPosition, todoItem);
    }

    @Override
    public int size() {
        return todoItemArray.size();
    }
}
