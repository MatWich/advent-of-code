package pl.agroniks.day3.advanced;

import java.util.*;

public class GearStarRatio {
    private List<String> inputs;
    private List<StarLocation> starLocations;
    private List<Integer> numbers;

    public GearStarRatio(String input) {
        inputs = List.of(input.split("\n"));
        starLocations = new ArrayList<>();
    }

    public void sumAllGearsRatio() {
        // create list of all * positions
        for (int y = 0; y < inputs.size(); y++) {
            for (int x = 0; x < inputs.get(y).length(); x++) {
                if (isStar(x, y))
                    starLocations.add(new StarLocation(x, y));
            }
        }

        // find digits that are adjacent to *
        int sum = 0;
        for (StarLocation starLocation : starLocations) {
            List<DigitsLocation> neighbors = getNeighbors(starLocation);
            Set<Integer> numbersToMultiply = findNumbers(neighbors);
            System.out.println(numbersToMultiply.toString());
            if (numbersToMultiply.size() == 2) {
                List<Integer> integers = numbersToMultiply.stream().toList();
                sum += integers.get(0) * integers.get(1);
            }
        }

        System.out.println("Answer: " + sum);
    }

    private Set<Integer> findNumbers(List<DigitsLocation> neighbors) {
        Set<Integer> numbers = new HashSet<>();
        for (DigitsLocation digitsLocation : neighbors) {
            StringBuilder numberWithDots = new StringBuilder();
            int x = digitsLocation.x();
            int y = digitsLocation.y();
            if (x - 2 >= 0 && isDigit(x - 2, y))
                numberWithDots.append(inputs.get(digitsLocation.y()).charAt(x - 2));
            if (x - 1 >= 0 && isDigit(x - 1, y))
                numberWithDots.append(inputs.get(digitsLocation.y()).charAt(x - 1));
            else
                numberWithDots.setLength(0);

            numberWithDots.append(digitsLocation.value());

            if (x + 1 < inputs.get(y).length() && isDigit(x + 1, y)) {
                numberWithDots.append(inputs.get(digitsLocation.y()).charAt(x + 1));
                if (x + 2 < inputs.get(y).length() && isDigit(x + 2, y))
                    numberWithDots.append(inputs.get(digitsLocation.y()).charAt(x + 2));
            }

            String number = numberWithDots.toString();
            number = number.replaceAll("\\D", "");
            numbers.add(Integer.parseInt(number));

        }
        return numbers;
    }

    private List<DigitsLocation> getNeighbors(StarLocation starLocation) {
        int x = starLocation.x();
        int y = starLocation.y();
        int left = x - 1;
        int right = x + 1;
        int up = y - 1;
        int down = y + 1;

        List<DigitsLocation> neighbors = new ArrayList<>();


        // check left
        if (left >= 0)  // check for out of bounds
            if (isDigit(left, y))
                neighbors.add(new DigitsLocation(left, y, inputs.get(y).charAt(left)));


        // check right
        if (right < inputs.get(x).length()) // check for out of bounds
            if (isDigit(right, y))
                neighbors.add(new DigitsLocation(right, y, inputs.get(y).charAt(right)));

        // check up
        if (up >= 0)  // check for out of bounds
            if (isDigit(x, up))
                neighbors.add(new DigitsLocation(x, up, inputs.get(up).charAt(x)));

        // check down
        if (down < inputs.size())  // check for out of bounds
            if (isDigit(x, down))
                neighbors.add(new DigitsLocation(x, down, inputs.get(down).charAt(x)));

        // check up-left
        if (up >= 0 && left >= 0) // check for out of bounds
            if (isDigit(left, up))
                neighbors.add(new DigitsLocation(left, up, inputs.get(up).charAt(left)));

        // check up-right
        if (up >= 0 && right < inputs.get(x).length())  // check for out of bounds
            if (isDigit(right, up))
                neighbors.add(new DigitsLocation(right, up, inputs.get(up).charAt(right)));

        // check bottom-left
        if (down < inputs.size() && left >= 0) // check for out of bounds
            if (isDigit(left, down))
                neighbors.add(new DigitsLocation(left, down, inputs.get(down).charAt(left)));

        // check bottom-right
        if (down < inputs.size() && right < inputs.get(x).length())  // check for out of bounds
            if (isDigit(right, down))
                neighbors.add(new DigitsLocation(right, down, inputs.get(down).charAt(right)));

        return neighbors;
    }

    private boolean isDigit(Integer x ,Integer y) {
        return Character.isDigit(inputs.get(y).charAt(x));
    }


    private boolean isStar(int x, int y) {
        return inputs.get(y).charAt(x) == '*';
    }
}
