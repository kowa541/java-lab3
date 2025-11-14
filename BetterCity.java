package ru.stepina.UnitSix;

import java.util.*;

public class BetterCity {
    private final String name;
    private final List<String> roads;

    public BetterCity(String name) {
        this(name, new ArrayList<>());
    }

    public BetterCity(String name, List<String> roads) {
        this.name = name;
        if (roads == null) {
            this.roads = new ArrayList<>();
        } else {
            this.roads = new ArrayList<>(roads);
        }
    }

    public void addRoad(String road) {
        roads.add(road);
    }

    @Override
    public String toString() {
        return name + " " + roads;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BetterCity other)) return false;


        return new HashSet<>(this.roads).equals(new HashSet<>(other.roads));
    }

    @Override
    public int hashCode() {
        return Objects.hash(new HashSet<>(roads));
    }
}