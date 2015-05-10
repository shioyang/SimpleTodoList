package jp.gr.java_conf.shioyang.simpletodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shioyang.
 */
public class TodoListAdapter extends ArrayAdapter {
    private LayoutInflater layoutInflater;

    public TodoListAdapter(Context context, int resource, List<TodoItem> objects) {
        super(context, resource, objects);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TodoItem todoItem = (TodoItem) getItem(position);

        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.view_todo_item, null);

        EditText todoEditText = (EditText) convertView.findViewById(R.id.todoEditText);
        todoEditText.setText(todoItem.getTodo());

        return convertView;
    }
}
