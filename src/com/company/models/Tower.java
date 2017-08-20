package com.company.models;

import java.util.List;

public class Tower {

    private String name;
    private List<String> elementsForTower;

    public Tower() {
    }

    public Tower(String name, List<String> elementsForTower) {
        this.name = name;
        this.elementsForTower = elementsForTower;
    }

    public String getName() {
        return name;
    }

    public Tower setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getElementsForTower() {
        return elementsForTower;
    }

    public void setElementsForTower(List<String> elementsForTower) {
        this.elementsForTower = elementsForTower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tower)) return false;

        Tower tower = (Tower) o;

        if (name != null ? !name.equals(tower.name) : tower.name != null) return false;
        return elementsForTower != null ? elementsForTower.equals(tower.elementsForTower) : tower.elementsForTower == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (elementsForTower != null ? elementsForTower.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "name='" + name + '\'' +
                ", elementsForTower=" + elementsForTower +
                '}';
    }
}
