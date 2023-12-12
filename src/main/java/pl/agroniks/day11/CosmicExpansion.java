package pl.agroniks.day11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.Math;

public class CosmicExpansion {
    private List<List<Character>> grid;
    private List<CosmicPoint> startingPoints;
    private Map<String, Integer> distances = new HashMap<>();
    private List<Integer> emptyRows = new ArrayList<>();
    private List<Integer> emptyColumns = new ArrayList<>();

    public CosmicExpansion(String input) {
        grid = Arrays.stream(input.split("\n"))
                .map(line -> line.chars()
                        .mapToObj(c -> (char) c).collect(Collectors.toList())).collect(Collectors.toList());

        grid.forEach(System.out::println);
        getGalaxies();
        getEmptyRows();
        System.out.println(emptyRows.size());
        getEmptyColumns();
        System.out.println(emptyColumns);
//        calculateDistances(2);    // PART 1
        calculateDistances(1_000_000);  // PART 2
        distances.forEach((k, v) -> System.out.println(k + ": " + v));
//        System.out.println("Distances size: " + distances.size());
        sumUpDistances();
    }

    private void sumUpDistances() {
        long sum = 0;
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            sum += entry.getValue();
        }
        System.out.println("Summed up: " + sum);
    }

    private void getEmptyColumns() {
        for (int i = 0; i < grid.get(0).size(); i++) {
            boolean foundGalaxy = false;
            for (int j = 0; j < grid.size(); j++) {
                if (grid.get(j).get(i) == '#')
                    foundGalaxy = true;
            }
            if (!foundGalaxy)
                emptyColumns.add(i);
        }
    }

    private void getEmptyRows() {
        for (int i = 0; i < grid.size(); i++) {
            if (!grid.get(i).contains('#')) {
                emptyRows.add(i);
            }
        }
    }

    private void getGalaxies() {
        int[] indexName = new int[1];

        startingPoints = IntStream.range(0, grid.size())
                .boxed()
                .flatMap(i -> IntStream.range(0, grid.get(i).size())
                        .filter(j -> grid.get(i).get(j) == '#')
                        .mapToObj(j -> new CosmicPoint(indexName[0]++, j, i)))
                .collect(Collectors.toList());
        startingPoints.forEach(System.out::println);
    }


    private Integer calculateDistance(CosmicPoint point1, CosmicPoint point2) {
        return Math.abs(point1.x() - point2.x()) + Math.abs(point1.y() - point2.y());
    }

    private void calculateDistances(long expansionRate) {
        for (int i = 0; i < startingPoints.size(); i++) {
            for (int j = i + 1; j < startingPoints.size(); j++) {

                int distance = calculateDistance(startingPoints.get(i), startingPoints.get(j));
                String galaxies = startingPoints.get(i).index()+"->"+startingPoints.get(j).index();
                var olderGalaxy = startingPoints.get(i);
                var newerGalaxy = startingPoints.get(j);

                var extraRows = emptyRows.stream().filter(row -> (olderGalaxy.y() < row && row < newerGalaxy.y()) || (olderGalaxy.y() > row && newerGalaxy.y() < row))
                        .count() * (expansionRate - 1);

                var extraCol = emptyColumns.stream().filter(col -> (olderGalaxy.x() < col && col < newerGalaxy.x()) || (olderGalaxy.x() > col && col > newerGalaxy.x()))
                        .count() * (expansionRate - 1);

                distance += extraRows + extraCol;
                distances.put(galaxies, distance);
            }
        }
    }
}
