package web.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private String model;

    public Car(int id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

