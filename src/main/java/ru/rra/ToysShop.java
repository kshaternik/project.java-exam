package ru.rra;

import java.util.Comparator;
import java.util.Objects;

//public class ToysShop implements Comparator<ToysShop> {
public class ToysShop implements Comparable<ToysShop>{
    private String id;
    private String name;
    private int chance;

    public ToysShop(String id, String name, int chance) {
        this.id = id;
        this.name = name;
        this.chance = chance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToysShop toysShop = (ToysShop) o;
        return chance == toysShop.chance && Objects.equals(id, toysShop.id) && Objects.equals(name, toysShop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, chance);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getChance() {
        return chance;
    }

    @Override
    public int compareTo(ToysShop other) {
        return Integer.valueOf(this.getId()) - Integer.valueOf(other.getId());
//        return Integer.valueOf(other.getId()) - Integer.valueOf(this.getId());
//        return other.getChance() - this.getChance();
    }

    @Override
    public String toString() {
        return "ToysShop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", chance=" + chance +
                '}';
    }


//    public int compare(ToysShop o1, ToysShop o2) {
//        if (o1.getChance() < o2.getChance())
//            return 1;
//        if (o1.getChance() > o2.getChance())
//            return -1;
//        return 0;
//
//    }
}

