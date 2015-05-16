package jp.gr.java_conf.shioyang.simpletodolist;

import junit.framework.TestCase;

/**
 * Created by shioyang.
 */
public class TodoItemImplTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testSetTodo() throws Exception {
        final String todo = "test set todo";
        TodoItem todoItem = new TodoItemImpl();
        todoItem.setTodo(todo);

        assertEquals(todoItem.getTodo(), todo);
    }

    public void testGetTodo() throws Exception {
        final String todo = "test set todo";
        final int categoryId = 0;
        TodoItem todoItem = new TodoItemImpl(todo, categoryId);

        assertEquals(todoItem.getTodo(), todo);
    }

    public void testSetCategory() throws Exception {
        final int categoryId = 1;
        TodoItem todoItem = new TodoItemImpl();
        todoItem.setCategory(categoryId);

        assertEquals(todoItem.getCategoryId(), categoryId);
    }

    public void testGetCategoryId() throws Exception {
        final String todo = "test set todo";
        final int categoryId = 1;
        TodoItem todoItem = new TodoItemImpl(todo, categoryId);

        assertEquals(todoItem.getCategoryId(), categoryId);
    }

    public void testGetCategoryName() throws Exception {
        TodoItem todoItem = new TodoItemImpl();

        assertEquals(todoItem.getCategoryName(), "category name...");
    }

    public void testSetIsDone() throws Exception {
        TodoItem todoItem = new TodoItemImpl();
        todoItem.setIsDone(true);

        assertTrue(todoItem.getIsDone());
    }

    public void testGetIsDone() throws Exception {
        final String todo = "test set todo";
        final int categoryId = 0;
        final boolean isDone = true;
        TodoItem todoItem = new TodoItemImpl(todo, categoryId, isDone);

        assertTrue(todoItem.getIsDone());
    }
}