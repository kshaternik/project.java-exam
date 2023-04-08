package ru.rra;

import java.util.Comparator;

public class ToysComparator implements Comparator<ToysShop> {
    @Override
    public int compare(ToysShop t1, ToysShop t2) {
        if (t1.getChance() < t2.getChance())
            return 1;
        if (t1.getChance() > t2.getChance())
            return -1;
        return 0;
    }
}
