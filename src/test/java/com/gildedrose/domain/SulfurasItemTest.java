package com.gildedrose.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SulfurasItemTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    void sellinSulfurasNeverChanges() {
        var sulfurasItem = new SulfurasItem(SULFURAS, 9, 80);
        sulfurasItem.updateItem();
        assertThat(sulfurasItem.sellIn).isEqualTo(9);
    }

    @Test
    void qualitySulfurasNeverChanges() {
        var sulfurasItem = new SulfurasItem(SULFURAS, 9, 80);
        sulfurasItem.updateItem();
        assertThat(sulfurasItem.quality).isEqualTo(80);
    }

}