package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemBuilderTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String TEST = "TestItem";
    private ItemBuilder builder;

    @BeforeEach
    void beforeEach() {
        builder = new ItemBuilder();
    }

    @Test
    void buildSulfurasItem() {
        var item = builder.withName(SULFURAS).withSellin(-1).withQuality(80).buildItem();
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void buildSulfurasItemWithInputSellinOtherThanMinus1() {
        var item = builder.withName(SULFURAS).withSellin(16).withQuality(80).buildItem();
        assertThat(item.sellIn).isEqualTo(-1);
    }

    @Test
    void buildSulfurasItemWithInputQualityOtherThan80() {
        var item = builder.withName(SULFURAS).withSellin(-1).withQuality(16).buildItem();
        assertThat(item.quality).isEqualTo(80);
    }

   @Test
    void buildItemWithInputQualityLowerThan0() {
        var item = builder.withName(TEST).withSellin(16).withQuality(-6).buildItem();
        assertThat(item.quality).isEqualTo(0);
    }

   @Test
    void buildItemWithInputQualityHigherThan50() {
        var item = builder.withName(TEST).withSellin(16).withQuality(55).buildItem();
        assertThat(item.quality).isEqualTo(50);
    }

}