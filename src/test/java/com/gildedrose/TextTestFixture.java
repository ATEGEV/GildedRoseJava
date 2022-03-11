package com.gildedrose;

import com.gildedrose.domain.*;

public class TextTestFixture {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemBuilder builder = new ItemBuilder();

        QsItem[] items = new QsItem[]{
                /*
                builder.withName("Test").withQuality(16).withSellin(9).buildItem(),
                builder.withName("Sulfuras, Hand of Ragnaros").withQuality(16).withSellin(9).buildItem(),
                builder.withName("Aged Brie").withQuality(-16).withSellin(1).buildItem(),
                */
                //*
                new StandardItem("+5 Dexterity Vest", 10, 21), //
                new StandardItem("Elixir of the Mongoose", 5, 7), //
                //*/
                //*
                new AgedBrieItem("Aged Brie", 2, 0), //
                new AgedBrieItem("Aged Brie", 5, 7), //
                //*/
                //*
                new SulfurasItem("Sulfuras, Hand of Ragnaros", 5, 80), //
                new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80),
                //*/
                //*
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                //*/
                // this conjured item does not work properly yet
                new ConjuredItem("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        int days = 22;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (var item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }


}
