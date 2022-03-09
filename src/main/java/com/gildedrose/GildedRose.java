package com.gildedrose;

class GildedRose {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private void decreaseSellin(Item item) {
        item.sellIn--;
    }

    public void updateQuality() {

        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    break;
                case BACKSTAGE_PASS:
                    if (item.sellIn <= 0) {
                        setQualityToZero(item);
                    } else {
                        increaseQuality(item);
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }
                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                    decreaseSellin(item);
                    break;
                case AGED_BRIE:
                    //deze increase staat eigenlijk niet in de resuirements, maar iw wel zo gïmplementeerd in de bestaande code
                    if (item.sellIn <= 0) {
                        increaseQuality(item);
                    }
                    increaseQuality(item);
                    decreaseSellin(item);
                    break;
                default:
                    decreaseQuality(item);
                    if (item.sellIn <= 0) {
                        decreaseQuality(item);
                    }
                    decreaseSellin(item);
                    break;
            }
        }
    }
}
