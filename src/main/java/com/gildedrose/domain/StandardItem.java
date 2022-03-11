package com.gildedrose.domain;

public class StandardItem extends QualityDecreasesWithUpdateItem {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (this.sellIn <= 0) {
            updateQuality();
        }
        updateQuality();
        updateSellin();
    }

}

