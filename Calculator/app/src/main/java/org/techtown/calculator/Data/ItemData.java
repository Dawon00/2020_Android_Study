package org.techtown.calculator.Data;

public class ItemData {
    private String name;
    private String description;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ItemData(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }


}
