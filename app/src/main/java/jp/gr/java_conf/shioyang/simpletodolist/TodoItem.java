package jp.gr.java_conf.shioyang.simpletodolist;

/**
 * Created by shioyang.
 */
public interface TodoItem {
    void setTodo(String todo);
    String getTodo();

    void setCategory(int categoryId);
    int getCategoryId();
    String getCategoryName();

    void setIsDone(Boolean isDone);
    Boolean getIsDone();
}
