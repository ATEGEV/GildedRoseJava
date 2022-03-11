package com.gildedrose.domain;

public class BackstagePassItem extends QualityIncreasesWithUpdateItem {

    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (this.sellIn <= 0) {
            setQualityToZero();
        } else {
            updateQuality();
            if (this.sellIn < 11) {
                updateQuality();
            }
            if (this.sellIn < 6) {
                updateQuality();
            }
        }
        updateSellin();
    }
}
