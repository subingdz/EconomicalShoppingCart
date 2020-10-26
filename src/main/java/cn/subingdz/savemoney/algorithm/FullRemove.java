package cn.subingdz.savemoney.algorithm;

import cn.subingdz.savemoney.entity.Shop;
import cn.subingdz.savemoney.entity.ShoppingCart;
import cn.subingdz.savemoney.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author subingdz
 */
public class FullRemove {
    public static ShoppingCart addAllGoods(ShoppingCart shoppingCart){
        if (Constant.NULL == shoppingCart){
            return shoppingCart;
        }
        HashMap<Integer, Shop> shopHashMap = shoppingCart.getShopMap();
        if (shopHashMap.size() == 0){
            return shoppingCart;
        }
        ArrayList<Shop> shopList = (ArrayList<Shop>) shopHashMap.values();
        if (shopList.size() == 0){
            return shoppingCart;
        }

        return shoppingCart;
    }
}
