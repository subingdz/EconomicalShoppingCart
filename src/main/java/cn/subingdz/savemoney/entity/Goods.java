package cn.subingdz.savemoney.entity;

import java.util.Objects;

/**
 * 商品类型
 * @author subingdz
 */
public class Goods {
    private int id;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goods goods = (Goods) o;
        return id == goods.id &&
                price == goods.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}
