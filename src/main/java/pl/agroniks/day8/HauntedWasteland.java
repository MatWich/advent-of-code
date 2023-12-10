package pl.agroniks.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HauntedWasteland {
    private List<String> inputs;
    private List<Character> instructions = new ArrayList<>();
    private Map<String, WastelandsNodes> nodes = new HashMap<>();
    private Map<String, WastelandsNodes> startingNodes = new HashMap<>();

    public HauntedWasteland(String input, int part) {
        inputs = List.of(input.split("\n"));
        inputs.forEach(System.out::println);
        initializeInstructions();
        initializeAllNodes();
        if (part == 1)
            getStepsNumberThatIsRequiredToGetToZZZ();
        if (part == 2) {
            getAllStartingPositions();
            getStepsToGetSimultaneouslyOnEndsXXZ();
        }
    }

    private void getStepsToGetSimultaneouslyOnEndsXXZ() {
        long steps = 0;
        List<String> currentPositions = new ArrayList<>();
        for (Map.Entry<String, WastelandsNodes> entry : startingNodes.entrySet()) {
            currentPositions.add(entry.getKey());
        }

        while(!areAllPositionsEndsWithZ(currentPositions)) {
            for (char instruction : instructions) {

                for (int i = 0; i < currentPositions.size(); i++) {

                    if (instruction == HauntedWastelandsConstants.LEFT)
                        currentPositions.set(i, nodes.get(currentPositions.get(i)).left());
                    if (instruction == HauntedWastelandsConstants.RIGHT)
                        currentPositions.set(i, nodes.get(currentPositions.get(i)).right());
                }
                steps++;
                if (areAllPositionsEndsWithZ(currentPositions)) {
                    System.out.println("All locations simultaneously ends with Z in " + steps + " steps.");
                    System.exit(0);
                }
            }
        }
    }

    private boolean areAllPositionsEndsWithZ(List<String> currentPositions) {
        return currentPositions.stream().allMatch(position -> position.endsWith("Z"));
    }

    private void getAllStartingPositions() {
        for (Map.Entry<String, WastelandsNodes> entry : nodes.entrySet()) {
            if (entry.getKey().endsWith("A"))
                startingNodes.put(entry.getKey(), entry.getValue());
        }
    }

    private void getStepsNumberThatIsRequiredToGetToZZZ() {
        long steps = 0;
        String currentPosition = HauntedWastelandsConstants.STARTING_POSITION;
        while (!currentPosition.equals(HauntedWastelandsConstants.FINISH)) {
            for (char instruction : instructions) {
                if (instruction == HauntedWastelandsConstants.LEFT)
                    currentPosition = nodes.get(currentPosition).left();
                if (instruction == HauntedWastelandsConstants.RIGHT)
                    currentPosition = nodes.get(currentPosition).right();
                steps++;

                if (currentPosition.equals(HauntedWastelandsConstants.FINISH)) {
                    System.out.println("Found " + HauntedWastelandsConstants.FINISH + " in " + steps + " steps.");
                    break;
                }
            }
        }
    }

    private void initializeAllNodes() {
        List<String> onlyNodes = inputs.stream().skip(2).toList();
        for (String line : onlyNodes) {
            List<String> nodeInfo = extractLetters(line);
            if (nodeInfo.size() != 3)
                throw new RuntimeException("Invalid date for node");
            nodes.put(nodeInfo.get(0), new WastelandsNodes(nodeInfo.get(1), nodeInfo.get(2)));
        }
        nodes.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    private List<String> extractLetters(String line) {
        line = line.replaceAll("\\(", "");
        line = line.replaceAll("\\)", "");
        line = line.replaceAll(",", "");
        line = line.replaceAll("= ", "");
        return List.of(line.split(" "));
    }

    private void initializeInstructions() {
        for (int i = 0; i < inputs.get(0).length(); i++) {
            char symbol = inputs.get(0).charAt(i);
            if (symbol == HauntedWastelandsConstants.RIGHT || symbol == HauntedWastelandsConstants.LEFT)
                instructions.add(symbol);
        }
    }


}
