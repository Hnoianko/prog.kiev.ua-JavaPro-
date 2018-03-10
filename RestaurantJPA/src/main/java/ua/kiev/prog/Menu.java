package ua.kiev.prog;

import javax.persistence.*;

@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String dishName;
    private Double dishPrice;
    private Double dishWeight;
    private Boolean discount;

    public Menu(String dishName, Double dishPrice, Double dishWeight, Boolean discount) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishWeight = dishWeight;
        this.discount = discount;
    }

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public Double getDishWeight() {
        return dishWeight;
    }

    public void setDishWeight(Double dishWeight) {
        this.dishWeight = dishWeight;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", dishPrice=" + dishPrice +
                ", dishWeight=" + dishWeight +
                ", discount=" + discount +
                '}';
    }
}
