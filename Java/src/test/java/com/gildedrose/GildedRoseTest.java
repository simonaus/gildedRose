package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    public void normalItemUpdateQualityBeforeSellDate() {
        Item[] items = new Item[] { new Item("normal", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("normal", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void normalItemUpdateQualityPastSellDate() {
        Item[] items = new Item[] { new Item("normal", 0, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("normal", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void qualityDoesNotGoBelowZero() {
        Item[] items = new Item[] { new Item("normal", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("normal", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void sulfurasHandOfRagnarosDoesNotDegrade() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
