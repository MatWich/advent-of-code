package pl.agroniks.day10;

import java.util.List;
import java.util.stream.Collectors;

public class PipeMaze {
    private List<String> inputs;
    private PipeStartingPoint startingPoint;

    public PipeMaze(String input) {
        inputs = List.of(input.split("\n"));
        replaceSymbolsToMoreReadable();
        inputs.forEach(System.out::println);
        getStartingPoint();
        getLengthOfPipe();
    }

    private void getLengthOfPipe() {
        Integer[] vel = {0, 1};
        int counter = 0;
        boolean run = true;

        while (run) {
            startingPoint.setX(startingPoint.getX() + vel[0]);
            startingPoint.setY(startingPoint.getY() + vel[1]);
            char pipeSymbol = inputs.get(startingPoint.getY()).charAt(startingPoint.getX());
            System.out.print(pipeSymbol + " ");
            counter++;

            if (pipeSymbol == PipeMazeConstants.UP_LEFT_PIPE) {
                if (vel[0] == 1) {
                    vel[0] = 0;
                    vel[1] = -1;
                } else  {
                    vel[0] = -1;
                    vel[1] = 0;
                }
            } else if (pipeSymbol == PipeMazeConstants.UP_RIGHT_PIPE) {
                if (vel[1] == 1) {
                    vel[0] = 1;
                    vel[1] = 0;
                } else {
                    vel[0] = 0;
                    vel[1] = -1;
                }
            } else if (pipeSymbol == PipeMazeConstants.RIGHT_DOWN_PIPE) {
                if (vel[0] == -1) {
                    vel[0] = 0;
                    vel[1] = 1;
                } else {
                    vel[0] = 1;
                    vel[1] = 0;
                }
            } else if (pipeSymbol == PipeMazeConstants.LEFT_DOWN_PIPE) {
                if (vel[0] == 1) {
                    vel[0] = 0;
                    vel[1] = 1;
                } else {
                    vel[0] = -1;
                    vel[1] = 0;
                }
            } else if (pipeSymbol == PipeMazeConstants.START_POINT) {
                run = false;
                break;
            }


        }
        System.out.println("Place you should go: " + counter/2);
    }

    private void replaceSymbolsToMoreReadable() {
        inputs = inputs.stream()
                .map(line -> line.replaceAll("7", PipeMazeConstants.LEFT_DOWN_PIPE.toString())
                        .replaceAll("F", PipeMazeConstants.RIGHT_DOWN_PIPE.toString())
                        .replaceAll("J", PipeMazeConstants.UP_LEFT_PIPE.toString())
                        .replaceAll("L", PipeMazeConstants.UP_RIGHT_PIPE.toString()))
                .collect(Collectors.toList());
    }

    public void getStartingPoint() {
        startingPoint = new PipeStartingPoint(-1, -1);
        for (int i = 0; i < inputs.size() - 1; i++) {
            String line = inputs.get(i);

            if (line.contains("S")) {
                startingPoint.setX(line.lastIndexOf('S'));
                startingPoint.setY(i);
            }

        }
        System.out.println(startingPoint);
    }
}
