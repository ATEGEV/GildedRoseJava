package com.gildedrose.domain;

public class ConjuredItem extends QualityDecreasesWithUpdateItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {

    }
}
