package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QsItemFactoryTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String TEST = "TestItem";

    private QsItemFactory factory;

    @BeforeEach
    void beforeEach() {
        factory = QsItemFactory.INSTANCE;
    }

    @Test
    void buildSulfurasItem() {
        var item =factory.create(SULFURAS, -1, 80);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void buildSulfurasItemWithInputSellinOtherThanMinus1() {
        var item =factory.create(SULFURAS, 16, 80);
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void buildSulfurasItemWithInputQualityOtherThan80() {
        var item =factory.create(SULFURAS, -1, 16);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void buildItemWithInputQualityLowerThan0() {
        var item =factory.create(TEST, 16, -6);
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void buildItemWithInputQualityHigherThan50() {
        var item =factory.create(TEST, 16, 55);
        assertThat(item.quality).isEqualTo(50);
    }
}