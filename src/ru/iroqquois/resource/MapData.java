package ru.iroqquois.resource;

import java.util.HashMap;
import java.util.Map;

public class MapData {
    private Map<Long, Integer> data = new HashMap<>();
    private static MapData INSTANCE = null;

    public static MapData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MapData();
        }

        return INSTANCE;
    }

    public synchronized Map<Long, Integer> getData() throws InterruptedException {
        wait();

        return Map.copyOf(data);
    }

    public synchronized void setData(Map<Long, Integer> map) {
        this.data = map;
        notify();
    }
}
