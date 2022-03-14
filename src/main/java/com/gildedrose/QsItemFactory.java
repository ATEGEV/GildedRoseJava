package com.gildedrose;

import com.gildedrose.domain.*;

enum QsItemFactory {

    INSTANCE;

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String CONJURED = "conjured";

    QsItem create(String name, int sellin, int quality) throws IllegalArgumentException {
        //check alq sellin en qual vwn
        if (!name.equals(SULFURAS)) {
            if (quality >= 50) {
                System.out.println("Quality cannot be more than 50.");
                quality = 50;
            }
            if (quality <= 0) {
                System.out.println("Quality cannot be negative.");
                quality = 0;
            }
            if (sellin <= 0) {
                System.out.println("Creating things that already should be sold is strange.");
                sellin = 1;
            }
        }
        var nameCheck = (name.toLowerCase().startsWith(CONJURED)) ? CONJURED : name;
        switch (nameCheck) {
            case SULFURAS:
                //check voorwaarden
                if (sellin != -1 || quality != 80) {
                    System.out.println(SULFURAS.concat(" has alway quality of 80 and sellin date of -1"));
                }
                return new SulfurasItem(SULFURAS, -1, 80);
            case BACKSTAGE_PASS:
                return new BackstagePassItem(BACKSTAGE_PASS, sellin, quality);
            case AGED_BRIE:
                return new AgedBrieItem(AGED_BRIE, sellin, quality);
            case CONJURED:
                return new ConjuredItem(name, sellin, quality);
            default:
                return new StandardItem(name, sellin, quality);
        }
    }
}
