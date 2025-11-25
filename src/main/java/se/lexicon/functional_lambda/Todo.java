package se.lexicon.functional_lambda;

public class Todo {
    private String title;
    private boolean isCompleted;
    private int priority;

    // Constructor
    public Todo(String title, boolean isCompleted, int priority) {
        this.title = title;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }


    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{title='" + title + "', isCompleted=" + isCompleted + ", priority=" + priority + "}";
    }
}
