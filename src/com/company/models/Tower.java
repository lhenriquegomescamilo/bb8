package com.company.models;

import javax.swing.text.html.Option;
import java.util.*;

public class Tower {

    private String name;
    private List<Integer> elementsForTower;

    public Tower() {
        this.name = "";
        this.elementsForTower = new LinkedList<>();
    }

    public Tower(String name, List<Integer> elementsForTower) {
        this.name = name;
        this.elementsForTower = Optional.of(elementsForTower).orElse(new LinkedList<Integer>());
    }

    public String getName() {
        return name;
    }

    public Tower withName(String name) {
        this.name = name;
        return this;
    }

    public List<Integer> getElementsForTower() {
        return elementsForTower;
    }

    public void setElementsForTower(List<Integer> elementsForTower) {
        this.elementsForTower = elementsForTower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tower)) return false;

        Tower tower = (Tower) o;

        return name.equals(tower.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Tower{" +
                "name='" + name + '\'' +
                ", elementsForTower=" + elementsForTower +
                '}';
    }
}
