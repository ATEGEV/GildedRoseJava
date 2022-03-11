package com.gildedrose.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassItemTest {

    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    @DisplayName("quality backstagepasses +1 if sellin is > 10")
    void qualityBackstagePassesIncreasesByOneIfSellin16() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 16, 2);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(3);
    }

    @Test
    @DisplayName("quality backstagepasses +1 if sellin is > 10: edge case 11")
    void qualityBackstagePassesIncreasesByOneIfSellin11() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 11, 7);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(8);
    }

    @Test
    @DisplayName("quality backstagepasses +2 if sellin is in [10, 5[")
    void qualityBackstagePassesIncreasesByTwoIfSellin7() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 7, 7);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(9);
    }

    @Test
    @DisplayName("quality backstagepasses +2 if sellin is in [10, 5[: upper edge case 10")
    void qualityBackstagePassesIncreasesByTwoIfSellin10() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 10, 2);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(4);
    }

    @Test
    @DisplayName("quality backstagepasses +2 if sellin is in [10, 5[: lower edge case 6")
    void qualityBackstagePassesIncreasesByTwoIfSellin6() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 6, 7);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(9);
    }

    @Test
    @DisplayName("quality backstagepasses +3 if sellin is in [5, 0[")
    void qualityBackstagePassesIncreasesByThreeIfSellin2() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 2, 7);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(10);
    }

    @Test
    @DisplayName("quality backstagepasses +3 if sellin is in [5, 0[: upper edge case 5")
    void qualityBackstagePassesIncreasesByThreeIfSellin5() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 5, 2);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(5);
    }

    @Test
    @DisplayName("quality backstagepasses +3 if sellin is in [5, 0: lower edge case 1[")
    void qualityBackstagePassesIncreasesByThreeIfSellin1() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 1, 9);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(12);
    }

    @Test
    void qualityItemDropsToZeroAfterSellinDate() {
        var backstagePassItem = new BackstagePassItem(BACKSTAGE_PASS, 0, 25);
        backstagePassItem.updateItem();
        assertThat(backstagePassItem.quality).isEqualTo(0);
    }

}