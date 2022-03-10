package com.gildedrose.domain;

public abstract class QualityDecreasesWithUpdateItem extends QsItem{

    public QualityDecreasesWithUpdateItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        if (quality > 0) {
            quality--;
        }
    }

}
