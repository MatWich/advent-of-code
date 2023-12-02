package pl.agroniks.day2;

import java.util.*;

public class CubeConundrum {

    private List<String> inputs;
    private Map<Integer, List<GameSet>> gameSets;
    private GameSet maxGameSet;
    public CubeConundrum(String input) {
        inputs = List.of(input.split("\n"));
        inputs.forEach(System.out::println);
        gameSets = new HashMap<>();
        maxGameSet = new GameSet(0,12, 13, 14);
    }

    // second part
    public void multiplyLowestCubesAmountToPLayEachGame() {
        createGameSets();
        int sum = 0;
        for (Map.Entry<Integer,List<GameSet>> entry : gameSets.entrySet() ) {
            List<GameSet> gamePhrases = entry.getValue();
            Integer biggestRedCubesAmount = getBiggestRedCubesAmount(gamePhrases);
            Integer biggestGreenCubesAmount = getBiggestGreenCubesAmount(gamePhrases);
            Integer biggestBlueCubesAmount = getBiggestBlueCubesAmount(gamePhrases);
            int result = biggestRedCubesAmount * biggestGreenCubesAmount * biggestBlueCubesAmount;
            sum += result;
        }
        System.out.println("Part two answer: " + sum);
    }

    private Integer getBiggestRedCubesAmount(List<GameSet> gamePhrases) {
        return gamePhrases.stream().map(GameSet::getRedCubes).max(Integer::compare).get();
    }

    private Integer getBiggestGreenCubesAmount(List<GameSet> gamePhrases) {
        return gamePhrases.stream().map(GameSet::getGreenCubes).max(Integer::compare).get();
    }

    private Integer getBiggestBlueCubesAmount(List<GameSet> gamePhrases) {
        return gamePhrases.stream().map(GameSet::getBlueCubes).max(Integer::compare).get();
    }

    // first part
    public void sumGameNumbers() {
        createGameSets();
        Integer sumOfGameNumbers = 0;
        for (Map.Entry<Integer, List<GameSet>> entry : gameSets.entrySet()) {
            Integer gameNumber = entry.getKey();
            List<GameSet> gameSetToTest = entry.getValue();
            boolean playable = true;
            for (GameSet game : gameSetToTest) {
                if (!game.isLowerThan(maxGameSet)) {
                    playable = false;
                }
            }
            if (playable)
                sumOfGameNumbers += gameNumber;
        }
        System.out.println("Part one answer: " + sumOfGameNumbers);
    }

    public void createGameSets() {
        for (String line : inputs) {
            // create a list of game sets
            int gameNumber = extractGameNumber(line);
            List<GameSet> gameSet = extractGameSets(line);
            gameSets.put(gameNumber, gameSet);
        }
    }

    private List<GameSet> extractGameSets(String line) {
        List<GameSet> gameSetList = new ArrayList<>();
        line = line.replaceFirst("Game.*: ", "");
        line = line.replaceAll(" ", "");
        String[] gamePhrases = line.split(";");
        for (int i = 0; i < gamePhrases.length; i++) {
            String[] colorCubes = gamePhrases[i].split(",");
            GameSet gameSet = new GameSet();
            for (int j = 0; j < colorCubes.length; j++) {
                String colorOfCubes = colorCubes[j].replaceAll("\\d", "");
                Integer amountOfCubes = Integer.valueOf(colorCubes[j].replaceAll("[a-zA-Z]+", ""));

                if (colorOfCubes.equalsIgnoreCase("red"))
                    gameSet.setRedCubes(amountOfCubes);
                else if(colorOfCubes.equalsIgnoreCase("green"))
                    gameSet.setGreenCubes(amountOfCubes);
                else if(colorOfCubes.equalsIgnoreCase("blue"))
                    gameSet.setBlueCubes(amountOfCubes);
                else
                    System.out.println("something went wrong");
            }
            System.out.println(gameSet.toString());
            gameSetList.add(gameSet);
        }
        return gameSetList;
    }

    private Integer extractGameNumber(String line) {
        String gameNumber = line.replaceFirst(":.*", "");
        gameNumber = gameNumber.replaceFirst("Game ", "");
        return Integer.valueOf(gameNumber);
    }
}
