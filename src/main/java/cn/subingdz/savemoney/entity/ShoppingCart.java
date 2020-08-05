package cn.subingdz.savemoney.entity;

import java.util.*;

public class ShoppingCart {

    private static ShoppingCart shoppingCart;

    private HashMap<Integer , Shop> shopMap;
    private int total;

    static {
        shoppingCart = new ShoppingCart();
    }

    private ShoppingCart() {
        shopMap = new HashMap<>();
        total = 0;
    }

    public HashMap<Integer, Shop> getShopMap() {
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
        total = 0;
        if (shopMap.size() > 0){
            ArrayList<Shop> shopList = (ArrayList) shopMap.values();
            for (Shop shop: shopList) {
                total += shop.getTotal();
            }
            return total;
        }
        return total;
    }

    public static ShoppingCart getInstance(){
        return shoppingCart;
    }
}
