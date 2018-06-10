package jp.model;

public class Item {

    private String description;
    private boolean completed;
    private String name;
    private int id;
    private String belongsTo;

    public Item(String description, boolean completed, String name, int id, String belongsTo){
        this.description = description;
        this.completed = completed;
        this.name = name;
        this.id = id;
        this.belongsTo = belongsTo;
    }

    public String getDescription() {
        return description;
    }

    public String getHisName(){
        return name;
    }

    public String getBelongsTo(){
        return belongsTo;
    }

    public boolean isCompleted() {
        return completed;
    }
}
