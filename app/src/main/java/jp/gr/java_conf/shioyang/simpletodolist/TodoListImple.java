package jp.gr.java_conf.shioyang.simpletodolist;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by shioyang.
 */
public class TodoListImple implements TodoList {
    ArrayList<TodoItem> todoItemArray;

    public TodoListImple(ArrayList<TodoItem> todoItemArray) {
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
    public void save() {

    }

    @Override
    public void addTodoItem(int position, TodoItem todoItem) {
        if (0 <= position && position <= todoItemArray.size())
            todoItemArray.add(position, todoItem);
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
}
