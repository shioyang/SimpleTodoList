package jp.gr.java_conf.shioyang.simpletodolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    TodoList todoList;
    TodoListAdapter todoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
        TodoItem todoItem1 = new TodoItemImple("Do TODO 1", 0);
        TodoItem todoItem2 = new TodoItemImple("Do TODO 2", 0);
        TodoItem todoItem3 = new TodoItemImple("Do TODO 3", 0);
        TodoItem todoItem4 = new TodoItemImple("Do TODO 4", 0);
        TodoItem todoItem5 = new TodoItemImple("Do TODO 5", 0);

        ArrayList<TodoItem> todoItemArray = new ArrayList<>();
        todoItemArray.add(todoItem1);
        todoItemArray.add(todoItem2);
        todoItemArray.add(todoItem3);
        todoItemArray.add(todoItem4);
        todoItemArray.add(todoItem5);

        todoList = new TodoListImple(todoItemArray);
//        final TodoList todoList = new TodoListImple(todoItemArray);
        //test

        todoListAdapter = new TodoListAdapter(this, 0, todoList.getTodoItems());
//        final TodoListAdapter todoListAdapter = new TodoListAdapter(this, 0, todoList.getTodoItems());
        todoListAdapter.setUpDownButtonClickListener(new UpDownButtonClickListener() {
            @Override
            public void onUpDownButtonClick(int position, boolean isUp) {
                todoList.swapTodoItem(position, isUp);
                todoListAdapter.notifyDataSetChanged();
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(todoListAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(adapterView.getContext());
                dialogBuilder.setTitle("Remove Item");
                dialogBuilder.setMessage("Do you want to remove the selected item?");
                dialogBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        todoList.removeTodoItem(position);
                        todoListAdapter.notifyDataSetChanged();
                    }
                });
                dialogBuilder.setNegativeButton(R.string.cancel, null);
                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {
            case R.id.action_add:
                todoList.addTodoItemToLast();
                todoListAdapter.notifyDataSetChanged();
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testFunc() {
    }
}
