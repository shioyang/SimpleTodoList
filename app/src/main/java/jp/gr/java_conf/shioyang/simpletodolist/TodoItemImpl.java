package jp.gr.java_conf.shioyang.simpletodolist;

/**
 * Created by shioyang.
 */
public class TodoItemImpl implements TodoItem {
    private String todo;
    private int categoryId;
    private String categoryName;
    private Boolean isDone;

    public TodoItemImpl() {
        this.todo = "";
        setCategory(R.string.default_category);
        isDone = false;
    }

    public TodoItemImpl(String todo, int categoryId) {
        this.todo = todo;
        setCategory(categoryId);
        isDone = false;
    }

    public TodoItemImpl(String todo, int categoryId, boolean isDone) {
        this.todo = todo;
        setCategory(categoryId);
        this.isDone = isDone;
    }

    @Override
    public void setTodo(String todo) {
        this.todo = todo;
    }

    @Override
    public String getTodo() {
        return todo;
    }

    @Override
    public void setCategory(int categoryId) {
        this.categoryId = categoryId;
        this.categoryName = "category name..."; // TODO: category name
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public Boolean getIsDone() {
        return isDone;
    }
}
