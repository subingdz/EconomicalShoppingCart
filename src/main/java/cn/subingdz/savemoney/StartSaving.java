package cn.subingdz.savemoney;

import cn.subingdz.savemoney.algorithm.FullRemove;
import cn.subingdz.savemoney.entity.Goods;
import cn.subingdz.savemoney.entity.Shop;
import cn.subingdz.savemoney.entity.ShoppingCart;

/**
 * @author subingdz
 */
public class StartSaving {

    public static void main(String[] args) {
        Goods c1 = new Goods(1,"巧克力",12);
        Goods c2 = new Goods(1,"巧克力",5);
        Goods c3 = new Goods(1,"巧克力",9);

        Goods f1 = new Goods(2,"腐乳",14);
        Goods f2 = new Goods(2,"腐乳",22);
        Goods f3 = new Goods(2,"腐乳",16);

        Goods p1 = new Goods(3,"苹果",4);
        Goods p2 = new Goods(3,"苹果",6);

        Goods x1 = new Goods(4,"香蕉",43);
        Goods x2 = new Goods(4,"香蕉",42);
        Goods x3 = new Goods(4,"香蕉",50);

        Goods n1 = new Goods(5,"牛奶",44);
        Goods n2 = new Goods(5,"牛奶",41);
        Goods n3 = new Goods(5,"牛奶",36);

        Shop s1 = new Shop("楼下超市",8,20);
        s1.addGoods(c1);s1.addGoods(f1);s1.addGoods(p1);s1.addGoods(x1);s1.addGoods(n1);
        Shop s2 = new Shop("天猫",10,30);
        s2.addGoods(c2);s2.addGoods(f2);s2.addGoods(p2);s2.addGoods(x2);s2.addGoods(n2);
        Shop s3 = new Shop("拼多多",8,25);
        s3.addGoods(c3);s3.addGoods(f3);s3.addGoods(x3);s3.addGoods(n3);

        ShoppingCart shoppingCart = ShoppingCart.getInstance();
        shoppingCart.addShop(s1);shoppingCart.addShop(s2);shoppingCart.addShop(s3);

        shoppingCart = FullRemove.addAllGoods(shoppingCart);

        System.out.println(shoppingCart.getTotal());
    }
}
