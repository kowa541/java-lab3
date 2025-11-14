package ru.stepina.UnitTwo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class City {
    private final String name;
    private final Set<City> roads;

    public City(String name) {
        this(name, new HashSet<>());
    }

    public City(String name, Set<City> roads) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя города не может быть пустым.");
        }
        this.name = name.trim();
        this.roads = Collections.unmodifiableSet(new HashSet<>(roads));
    }

    public City addRoad(City destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }
        if (this.equals(destination)) {
            System.out.println("Нельзя добавить дорогу в себя самого");
            return this;
        }

        Set<City> newRoads = new HashSet<>(this.roads);
        if (newRoads.add(destination)) {
            return new City(this.name, newRoads);
        } else {
            return this;
        }
    }


    public City removeRoad(City destination) {
        if (destination == null) return this;

        if (!this.roads.contains(destination)) {
            System.out.println("Дорога не найдена.");
            return this;
        }

        Set<City> newRoads = new HashSet<>(this.roads);
        newRoads.remove(destination);
        return new City(this.name, newRoads);
    }

    public String getName() {
        return name;
    }

    public Set<City> getRoads() {
        return roads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}