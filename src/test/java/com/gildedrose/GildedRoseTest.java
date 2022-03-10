package com.gildedrose;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";

    @Test
    void qualityItemDecreasesByOneUntilSellinDate() {
        Item[] items = new Item[]{new Item("testItem", 6, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(1);
    }

    @Test
    void qualityItemDecreasesByTwoAfterSellinDate() {
        Item[] items = new Item[]{new Item("testItem", -1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
    }

    @Test
    void qualityItemCannotBeNegative() {
        Item[] items = new Item[]{new Item("testItem", 6, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
    }

    @Test
    void qualityAgedBrieIncreasesByOneUntilSellinDate() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 6, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(3);
    }

    @Test
    void qualityItemCannotMoreTha50() {
        Item[] items = new Item[]{new Item(AGED_BRIE, 6, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(50);
    }

    @Test
    void sellinSulfurasNeverChanges() {
        Item[] items = new Item[]{new Item(SULFURAS, 9, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].sellIn).isEqualTo(9);
    }

    @Test
    void qualitySulfurasNeverChanges() {
        Item[] items = new Item[]{new Item(SULFURAS, 9, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(80);
    }

    @Test
    @DisplayName("quality backstagepasses +1 if sellin is > 10")
    void qualityBackstagePassesIncreasesByOneIfSellinLargerThen10() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 16, 2),
                new Item(BACKSTAGE_PASS, 11, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(3);
        assertThat(items[1].quality).isEqualTo(8);
    }

    @Test
    @DisplayName("quality backstagepasses +2 if sellin is in [10, 5[")
    void qualityBackstagePassesIncreasesByTwoIfSellinLargerorequalThen10AndLargerThen5() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 10, 2), new Item(BACKSTAGE_PASS, 6, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(4);
        assertThat(items[1].quality).isEqualTo(9);
    }

    @Test
    @DisplayName("quality backstagepasses +3 if sellin is in [5, 0[")
    void qualityBackstagePassesIncreasesByThreeIfSellinLargerorequalThen5AndLargerThen0() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 5, 2),
                new Item(BACKSTAGE_PASS, 1, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(5);
        assertThat(items[1].quality).isEqualTo(10);
    }

    @Test
    void qualityItemDropsToZeroAfterSellinDate() {
        Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 0, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(0);
    }

    @Test
    void qualityConjuredItemsDecreasesByTwo() {
        Item[] items = new Item[]{new Item("conjured testItem", 16, 9)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(7);
    }

    @Test
    void qualityConjuredItemDecreasesByFourAfterSellinDate() {
        Item[] items = new Item[]{new Item("conjured testItem", 0, 8)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality).isEqualTo(4);
    }



}
