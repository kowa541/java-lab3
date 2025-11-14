package ru.stepina.UnitTwo;
import java.util.*;
import java.util.stream.Collectors;


public final class Route {
    private final Map<City, Set<City>> graph;
    private City start;
    private City end;

    public Route(Map<City, Set<City>> graph, City start, City end) {
        if (graph == null) {
            throw new IllegalArgumentException("Граф не может быть null");
        }
        if (start == null || end == null) {
            throw new IllegalArgumentException("Начало и конец маршрута не могут быть null");
        }
        this.graph = graph;
        this.start = start;
        this.end = end;
    }


    public Route setStart(City start) {
        if (start == null) {
            throw new IllegalArgumentException("Начало маршрута не может быть null");
        }
        return new Route(graph, start, end);
    }


    public Route setEnd(City end) {
        if (end == null) {
            throw new IllegalArgumentException("Конец маршрута не может быть null");
        }
        return new Route(graph, start, end);
    }


    public City[] getRoute() {
        List<City> path = findPathBFS(start, end);
        return path.toArray(new City[0]);
    }


    private List<City> findPathBFS(City start, City end) {
        if (start.equals(end)) {
            return List.of(start);
        }

        Map<City, City> predecessors = new HashMap<>();
        Queue<City> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            City current = queue.poll();

            for (City neighbor : graph.getOrDefault(current, Collections.emptySet())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    predecessors.put(neighbor, current);
                    queue.add(neighbor);

                    if (neighbor.equals(end)) {
                        return buildPath(predecessors, start, end);
                    }
                }
            }
        }

        return Collections.emptyList();
    }

    private List<City> buildPath(Map<City, City> predecessors, City start, City end) {
        List<City> path = new ArrayList<>();
        City current = end;

        while (current != null) {
            path.add(0, current);
            current = predecessors.get(current);
        }

        return path;
    }

    @Override
    public String toString() {
        City[] route = getRoute();
        if (route.length == 0) {
            return start.getName() + " → [путь не найден]";
        }
        return Arrays.stream(route)
                .map(City::getName)
                .collect(Collectors.joining(" → "));
    }


    public City getStart() { return start; }
    public City getEnd() { return end; }
}
