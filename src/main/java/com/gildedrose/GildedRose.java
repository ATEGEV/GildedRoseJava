package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.QsItem;

class GildedRose {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "conjured";

    QsItem[] items;

    public GildedRose(QsItem[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (var item : items) {
            item.updateItem();
        }
    }
}
