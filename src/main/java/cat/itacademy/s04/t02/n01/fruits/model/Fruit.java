package cat.itacademy.s04.t02.n01.fruits.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Fruit {

    private int id;
    private String name;
    private int quantityKg;

    public Fruit() {}

    public Fruit(int id, String name) {
        this.id = id;
        this.name = name;
        this.quantityKg = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }
}
