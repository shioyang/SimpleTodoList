package jp.gr.java_conf.shioyang.simpletodolist;

/**
 * Created by shioyang.
 */
public class TodoItemImple implements TodoItem {
    private String todo;
    private int categoryId;
    private String categoryName;
    private Boolean isDone;

    public TodoItemImple() {
        this.todo = "";
        setCategory(R.string.default_category);
    }

    public TodoItemImple(String todo, int categoryId) {
        this.todo = todo;
        setCategory(categoryId);
    }

    @Override
    public void setTodo(String t) {
        todo = t;
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
