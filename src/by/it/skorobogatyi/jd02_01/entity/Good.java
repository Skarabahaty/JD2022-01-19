package by.it.skorobogatyi.jd02_01.entity;

import java.math.BigDecimal;

public class Good {

    public final String name;
    public final BigDecimal price;


    public Good(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }


    public Good() {
        this.name = "noname";
        this.price = BigDecimal.valueOf(0);
    }

    @Override
    public String toString() {
        return "good " + name + " \\ " + "price= " + price;
    }
}
