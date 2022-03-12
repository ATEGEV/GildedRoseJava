package com.gildedrose.domain;

import com.gildedrose.domain.Item;

public abstract class QsItem extends Item {

    public QsItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateItem();

    public String getName() {
        return this.name;
    }

    public int getSellin() {
        return this.sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    protected void updateSellin() {
        sellIn--;
    }

    //until now only backstage pass items needs this, but that can can change
    protected void setQualityToZero() {
        this.quality = 0;
    }
}
