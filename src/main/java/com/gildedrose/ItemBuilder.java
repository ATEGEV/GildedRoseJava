package com.gildedrose;

import com.gildedrose.domain.Item;

class ItemBuilder {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private String name;
    private int quality;
    private int sellin;

    ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    ItemBuilder withQuality(int quality) {
        if (this.name.equals(SULFURAS) && quality != 80) {
            System.out.println("Sulfuras always have qualty 80");
            quality = 80;
        } else if (quality > 50 && !this.name.equals(SULFURAS)) {
            System.out.println("Quality cannot be larger then 50.");
            quality = 50;
        } else if (quality < 0) {
            System.out.println("Quality cannot be negative.");
            quality = 0;
        }
        this.quality = quality;
        return this;
    }

    ItemBuilder withSellin(int sellin) {
        if (this.name.equals(SULFURAS) && sellin != -1) {
            System.out.println("Sulfuras wil never be sold.");
            sellin = -1;
        }
        this.sellin = sellin;
        return this;
    }

    Item buildItem() {
        return new Item(name, sellin, quality);
    }

}
