package jp.model;

public class Item {

    private String description;
    private boolean completed;
    private String name;

    public Item(String description, boolean completed, String name){
        this.description = description;
        this.completed = completed;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }
}
