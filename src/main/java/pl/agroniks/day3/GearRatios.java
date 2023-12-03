package pl.agroniks.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GearRatios {
    private List<String> inputs;
    private List<Integer> partNumbers;
    private List<List<Character>> characters = new ArrayList<>();

    public GearRatios(String input) {
        inputs = List.of(input.split("\n"));
//        inputs.forEach(System.out::println);
        partNumbers = new ArrayList<>();
    }


    private boolean isNotDot(Integer inputsIndex, Integer digitIndex) {
        return inputs.get(inputsIndex).charAt(digitIndex) != '.';
    }

    private boolean isNotDigit(Integer inputsIndex, Integer digitIndex) {
        return !Character.isDigit(inputs.get(inputsIndex).charAt(digitIndex));
    }

    private boolean isNeitherDigitOrDot(Integer inputsIndex, Integer digitIndex) {
        return isNotDot(inputsIndex, digitIndex) && isNotDigit(inputsIndex, digitIndex);
    }

    public boolean isAdjacentToSymbol(Integer inputsIndex, Integer digitIndex) {
        int left = digitIndex - 1;
        int right = digitIndex + 1;
        int up = inputsIndex - 1;
        int down = inputsIndex + 1;

        // check left
        if (left >= 0)  // check for out of bounds
            if (isNeitherDigitOrDot(inputsIndex, left))
                return true;

        // check right
        if (right <= inputs.get(inputsIndex).length() - 1) // check for out of bounds
            if (isNeitherDigitOrDot(inputsIndex, right))
                return true;

        // check up
        if (up >= 0)  // check for out of bounds
            if (isNeitherDigitOrDot(up, digitIndex))
                return true;

        // check down
        if (down < inputs.size())  // check for out of bounds
            if (isNeitherDigitOrDot(down, digitIndex))
                return true;

        // check up-left
        if (up >= 0 && left >= 0) // check for out of bounds
            if (isNeitherDigitOrDot(up, left))
                return true;

        // check up-right
        if (up >= 0 && right <= inputs.get(inputsIndex).length() - 1)  // check for out of bounds
            if (isNeitherDigitOrDot(up, right))
                return true;

        // check bottom-left
        if (down < inputs.size() && left >= 0) // check for out of bounds
            if (isNeitherDigitOrDot(down, left))
                return true;

        // check bottom-right
        if (down < inputs.size() && right <= inputs.get(inputsIndex).length() - 1)  // check for out of bounds
            if (isNeitherDigitOrDot(down, right))
                return true;

        return false;
    }

    public void getGearPartNumbers() {
        String numbers = "";
        int lineNumber = 0;
        for (String line : inputs) {
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    numbers+=line.charAt(i);
                } else {
                    if (!numbers.toString().equals("")) {
                        if (checkIfNumbersAreAdjacentToSymbol(lineNumber, i - 1, numbers.toString().length())) {
                            partNumbers.add(Integer.parseInt(numbers.toString()));
                            System.out.println(numbers.toString());
                            numbers = "";
                        } else {
                            System.out.println(numbers.toString());
                            numbers = "";
                        }

                    }
                }
            }
            lineNumber++;
        }
    }

    private boolean checkIfNumbersAreAdjacentToSymbol(int lineNumber, int stringIndex, int stringLength) {
        for (int i = 0; i < stringLength; i++) {
            if (isAdjacentToSymbol(lineNumber, stringIndex - i)) {
                System.out.println("Znalazlo dla : " + inputs.get(lineNumber).charAt(stringIndex - i));
                return true;
            }
            System.out.println("Nie znalazlo dla: " + inputs.get(lineNumber).charAt(stringIndex - i));
        }
        return false;
    }

    public Integer sumUpAllPartNumbers() {
        return partNumbers.stream().reduce(0, Integer::sum);
    }
}
