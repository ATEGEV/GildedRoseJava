package com.gildedrose.domain;

public abstract class QualityIncreasesWithUpdateItem extends QsItem {

    public QualityIncreasesWithUpdateItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality() {
        if (quality < 50) {
            quality++;
        }
    }
}
