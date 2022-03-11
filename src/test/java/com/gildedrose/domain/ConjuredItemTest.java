package com.gildedrose.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredItemTest {

    private static final String CONJURED_TESTITEM = "conjured testItem";

    @Test
    void qualityConjuredItemsDecreasesByTwo() {
        var conjuredItem = new  ConjuredItem(CONJURED_TESTITEM, 16, 9);
        conjuredItem.updateItem();
        assertThat(conjuredItem.quality).isEqualTo(7);
    }

    @Test
    void qualityConjuredItemDecreasesByFourAfterSellinDate() {
        var conjuredItem = new  ConjuredItem(CONJURED_TESTITEM, 0, 8);
        conjuredItem.updateItem();
        assertThat(conjuredItem.quality).isEqualTo(4);
    }


}