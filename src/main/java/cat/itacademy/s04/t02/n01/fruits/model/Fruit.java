package cat.itacademy.s04.t02.n01.fruits.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @Min(value = 0, message = "Quantity must be 0 or superior.")
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
