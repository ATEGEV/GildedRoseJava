package com.gildedrose.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieItemTest {

    private static final String AGED_BRIE = "Aged Brie";

    @Test
    void qualityAgedBrieIncreasesByOneBeforeSellinDate() {
        var agedBrieItem = new AgedBrieItem(AGED_BRIE, 6, 2);
        agedBrieItem.updateItem();
        assertThat(agedBrieItem.quality).isEqualTo(3);
    }

    @Test
    void qualityAgedBrieIncreasesByOneWithSellinDaysOne() {
        var agedBrieItem = new AgedBrieItem(AGED_BRIE, 1, 2);
        agedBrieItem.updateItem();
        assertThat(agedBrieItem.quality).isEqualTo(3);
    }

    //staat niet zo in requirements maar is wel zo gecodeerd door Leeroy in originele GildedroseTest
    @Test
    void qualityAgedBrieIncreasesByYwoWithSellinDaysZero() {
        var agedBrieItem = new AgedBrieItem(AGED_BRIE, 0, 2);
        agedBrieItem.updateItem();
        assertThat(agedBrieItem.quality).isEqualTo(5);
    }

    @Test
    void qualityAgedBrieGoesFrom49To50() {
        var agedBrieItem = new AgedBrieItem(AGED_BRIE, 6, 49);
        agedBrieItem.updateItem();
        assertThat(agedBrieItem.quality).isEqualTo(50);
    }

    @Test
    void qualityAgedBrieCannotMoreTha50() {
        var agedBrieItem = new AgedBrieItem(AGED_BRIE, 6, 50);
        agedBrieItem.updateItem();
        assertThat(agedBrieItem.quality).isEqualTo(50);
    }

    @Test
    void sellinAgedBrieItemDecreasesByOneAfterUpdate() {
        var item = new AgedBrieItem(AGED_BRIE, 6, 2);
        item.updateItem();
        assertThat(item.sellIn).isEqualTo(5);
    }

}