package com.gildedrose.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StandardItemTest {

    private static final String TEST_ITEM = "testItem";

    @Test
    void qualityItemDecreasesByOneUntilSellinDate() {
        var item = new StandardItem(TEST_ITEM, 6, 2);
        item.updateItem();
        assertThat(item.quality).isEqualTo(1);
    }

    @Test
    void qualityItemDecreasesByTwoAfterSellinDate() {
        var item = new StandardItem(TEST_ITEM, -1, 2);
        item.updateItem();
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void qualityItemCannotBeNegative() {
        var item = new StandardItem(TEST_ITEM, 6, 0);
        item.updateItem();
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void sellinItemDecreasesByOneAfterUpdate() {
        var item = new StandardItem(TEST_ITEM, 6, 2);
        item.updateItem();
        assertThat(item.sellIn).isEqualTo(5);
    }

}