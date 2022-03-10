package com.gildedrose.domain;

import com.gildedrose.domain.Item;

public abstract class QsItem extends Item {

    public QsItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateItem();

    protected void updateSellin() {
        sellIn--;
    }
}
