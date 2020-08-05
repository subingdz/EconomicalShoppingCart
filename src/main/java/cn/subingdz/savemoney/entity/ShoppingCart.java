package cn.subingdz.savemoney.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private static ShoppingCart shoppingCart;

    private Map<Integer , Shop> shopMap;
    private int total;

    static {
        shoppingCart = new ShoppingCart();
    }

    private ShoppingCart() {
        shopMap = new HashMap<>();
        total = 0;
    }

    public Map<Integer, Shop> getShopMap() {
        return shopMap;
    }

    public void addShop(Shop shop) {
        this.shopMap.put(shop.getId(),shop);
        this.total += shop.getTotal();
    }

    public void removeShop(Shop shop) {
        this.shopMap.remove(shop.getId());
        this.total -= shop.getTotal();
    }

    public int getTotal() {
        return total;
    }

    public static ShoppingCart getInstance(){
        return shoppingCart;
    }
}
