package pl.agroniks.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoatRace {
    private List<String> inputs;
    private List<Long> times;
    private List<Long> distances;

    public BoatRace(String input, int part) {
        this.inputs = List.of(input.split("\n"));
        getTimes();
        getDistances();
        if (part == 2) {
            getTimesPart2();
            getDistancesPart2();
        }
    }

    private void getDistancesPart2() {
        distances = new ArrayList<>();
        String distancesLine = inputs.get(1);
        if (!distancesLine.startsWith("Distance:")) {
            throw new RuntimeException("Distance inputs not found");
        }
        distancesLine = distancesLine.replaceAll(" ", "");
        distancesLine = distancesLine.replaceAll("Distance:", "");
        distances.add(Long.parseLong(distancesLine));

    }

    private void getTimesPart2() {
        times = new ArrayList<Long>();
        String timesLine = inputs.get(0);
        if (!timesLine.startsWith("Time:")) {
            throw new RuntimeException("Time inputs not found.");
        }
        timesLine = timesLine.replaceAll(" ", "");
        timesLine = timesLine.replaceAll("Time:", "");
        times.add(Long.parseLong(timesLine));
        System.out.println("TIME: " + timesLine);
    }

    private void getDistances() {
        distances = new ArrayList<>();
        String distancesLine = inputs.get(1);
        if (!distancesLine.startsWith("Distance:")) {
            throw new RuntimeException("Distance inputs not found");
        }

        distancesLine = distancesLine.replaceAll("Distance:\\s+", "");
        distancesLine = distancesLine.replaceAll("\\s+", " ");
        distances = List.of(distancesLine.split(" ")).stream().map(Long::parseLong).collect(Collectors.toList());
    }

    private void getTimes() {
        times = new ArrayList<Long>();
        String timesLine = inputs.get(0);
        if (!timesLine.startsWith("Time:")) {
            throw new RuntimeException("Time inputs not found.");
        }

        timesLine = timesLine.replaceAll("Time:\\s+", "");
        timesLine = timesLine.replaceAll("\\s+", " ");
        times = List.of(timesLine.split(" ")).stream().map(Long::parseLong).collect(Collectors.toList());
    }

    public void getAllRaceWaysToBeatHighScoreMultiplied() {
        long multipliedWaysTOBeatHighScore = 1;
        List<Integer> waysToBeatHighScorePerRace = new ArrayList<>();

        for (int raceNumber = 0; raceNumber < times.size(); raceNumber++) {
            Long time = times.get(raceNumber);
            long highScore = distances.get(raceNumber);
            int numberOfWaysToBeatHighScore = foundALlWaysThatExceedsCurrentHighScore(time, highScore);
            waysToBeatHighScorePerRace.add(numberOfWaysToBeatHighScore);
        }

        for (Integer i : waysToBeatHighScorePerRace) {
            System.out.println(i);
            multipliedWaysTOBeatHighScore *= i;
        }
        System.out.println("Answer: " + multipliedWaysTOBeatHighScore);
    }

    private Integer foundALlWaysThatExceedsCurrentHighScore(Long time, Long highScore) {
        int waysToBeatHighScore = 0;
        for (int velocity = 1; velocity < time; velocity++) {    // lest be honest if we will pull btn whole time we won't move
            long timeLeft = time - velocity;
            long distance = calculateDistance(timeLeft, velocity);
            if (distance > highScore) {
                waysToBeatHighScore++;
            }
        }

        return waysToBeatHighScore;
    }

    private long calculateDistance(long time, Integer velocity) {
        return time * velocity;
    }

}
