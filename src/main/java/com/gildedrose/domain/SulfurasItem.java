package com.gildedrose.domain;

public class SulfurasItem extends QualityStaysFixWithUpdateItem {

    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        //nothing needs to happen; quality stays 80, sellin stays -1;
    }
}
