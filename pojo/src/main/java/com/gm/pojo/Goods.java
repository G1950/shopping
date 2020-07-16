package com.gm.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author Gm
 * @Date 2020/7/15/015 14:37
 * @Version 1.0
 **/
public class Goods implements Serializable {
    //商品
    private TbGoods goods;

    //商品扩展
    private TbGoodsDesc goodsDesc;

    //商品sku列表
    private List<TbItem> items;

    public TbGoods getGoods() {
        return goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }


    public List<TbItem> getItems() {
        return items;
    }

    public void setItems(List<TbItem> items) {
        this.items = items;
    }
}
