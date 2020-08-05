package cn.subingdz.savemoney.entity;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.subingdz.savemoney.util.Constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 店铺
 * 仅暴露get方法，其余属性皆在内部运算，基础属性在初始化时赋值
 * @author subingdz
 */
public class Shop {
    /**
     * 店铺id---辨识店铺
     */
    private int id;
    /**
     * 店铺名字
     */
    private String name;
    /**
     * 购物车里，该店铺的商品集
     */
    private HashMap<Integer,Integer> goodsMap;
    /**
     * 邮费
     */
    private int freight;
    /**
     *多少钱包邮
     */
    private int priceForFreeFreight;
    /**
     * 是否包邮
     */
    private boolean freightForFree;
    /**
     * 该店铺付款总价
     */
    private int total;

    private static Log logger = LogFactory.get(Shop.class);

    /**
     * 创建店铺对象时必须赋予店铺的name及运费属性
     * @param
     * @param freight
     */
    public Shop(String name, int freight ,int priceForFreeFreight) {
        this.id = ++Constant.idConst;
        this.name = name;
        this.freight = freight;
        this.priceForFreeFreight = priceForFreeFreight;
        this.freightForFree = false;
        this.goodsMap = new HashMap<>();
        this.total = 0;
    }

    /**
     * 添加商品，并计算总价
     * @param goods
     */
    public void addGoods(Goods goods) {
        //初始添加商品时计算入邮费
        if (goodsMap.size() == 0){
            total += freight;
        }
        if (Constant.NULL !=goods && !this.goodsMap.containsKey(goods.getId())){
            goodsMap.put(goods.getId(),goods.getPrice());
            total += goods.getPrice();
            //计算包邮
            if (!freightForFree && total > priceForFreeFreight){
                total -= freight;
                freightForFree = true;
            }
            logger.info("shop["+this.id+"]--goods添加成功！"+goods.toString());
        }else {
            logger.info("shop["+this.id+"]--goods添加失败！Goods已存在："+goods.toString());
        }
    }

    /**
     * 删除商品，并计算总价
     * @param goods
     */
    public void removeGoods(Goods goods) {
        if (Constant.NULL !=goods && this.goodsMap.containsKey(goods.getId())){
            goodsMap.remove(goods.getId());
            total -= goods.getPrice();
            if (freightForFree && total < priceForFreeFreight){
                total += freight;
                freightForFree = false;
            }
            logger.info("shop["+this.id+"]--goods删除成功！"+goods.toString());
        }else {
            logger.info("shop["+this.id+"]--goods删除失败！Goods不存在："+goods.toString());
        }
        //商品删光时，总额清零
        if (goodsMap.size()==0){
            total = 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Integer> getGoodsMap() {
        return goodsMap;
    }

    public int getFreight() {
        return freight;
    }

    public int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public boolean isFreightForFree() {
        return freightForFree;
    }

    public int getPriceForFreeFreight() {
        return priceForFreeFreight;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsMap=" + goodsMap +
                ", freight=" + freight +
                ", priceForFreeFreight=" + priceForFreeFreight +
                ", freightForFree=" + freightForFree +
                ", total=" + total +
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
        Shop shop = (Shop) o;
        return id == shop.id &&
                freight == shop.freight &&
                priceForFreeFreight == shop.priceForFreeFreight &&
                name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, freight, priceForFreeFreight);
    }
}
