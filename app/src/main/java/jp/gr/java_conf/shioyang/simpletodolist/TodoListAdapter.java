package jp.gr.java_conf.shioyang.simpletodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by shioyang.
 */
public class TodoListAdapter extends ArrayAdapter {
    private LayoutInflater layoutInflater;
    private UpDownButtonClickListener upDownButtonClickListener;

    public TodoListAdapter(Context context, int resource, List<TodoItem> todoItemList) {
        super(context, resource, todoItemList);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        upDownButtonClickListener = null;
    }

    public void setUpDownButtonClickListener(UpDownButtonClickListener upDownButtonClickListener) {
        this.upDownButtonClickListener = upDownButtonClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TodoItem todoItem = (TodoItem) getItem(position);

        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.view_todo_item, null);

        EditText todoEditText = (EditText) convertView.findViewById(R.id.todoEditText);
        todoEditText.setText(todoItem.getTodo());

        setUpDownFeature(position, convertView);

        return convertView;
    }

    private void setUpDownFeature(final int position, View convertView) {
        Button upButton = (Button) convertView.findViewById(R.id.upButton);
        setupUpDownButton(upButton, position, true);

        Button downButton = (Button) convertView.findViewById(R.id.downButton);
        setupUpDownButton(downButton, position, false);
    }

    private void setupUpDownButton(Button button, int position, final boolean isUp) {
        button.setTag(R.string.tag_position, position);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (upDownButtonClickListener != null)
                    upDownButtonClickListener.onUpDownButtonClick((int) view.getTag(R.string.tag_position), isUp);
            }
        });
    }
}
