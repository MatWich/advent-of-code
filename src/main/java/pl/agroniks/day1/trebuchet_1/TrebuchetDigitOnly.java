package pl.agroniks.day1.trebuchet_1;

import java.util.ArrayList;
import java.util.List;

public class TrebuchetDigitOnly {
    private List<String> inputs;
    private List<Integer> allCoordinates = new ArrayList<>();

    public TrebuchetDigitOnly(String strings) {
        this.inputs = List.of(strings.split("\n"));
    }


    public Integer getSumOfCoordinatesValues() {
        getAllCombinedValues();
        return sumCoordinatesValues();
    }

    private void getAllCombinedValues() {
        for (String line : inputs) {
            allCoordinates.add(getCombinedValueOfCoordinates(line));
        }
    }

    private Integer getCombinedValueOfCoordinates(String line) {
        List<Character> coordinates = getCoordinates(line);
        return Character.getNumericValue(getFirstDigit(coordinates)) * 10 + Character.getNumericValue(getLastDigit(coordinates));
    }

    private List<Character> getCoordinates(String line) {
        List<Character> numbers = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                numbers.add(line.charAt(i));
            }
        }
        return numbers;
    }

    private Character getFirstDigit(List<Character> coordinates) {
        return coordinates.get(0);
    }

    private Character getLastDigit(List<Character> coordinates) {
        return coordinates.get(coordinates.size() - 1);
    }

    private Integer sumCoordinatesValues() {
        int sum = 0;
        for (Integer number : allCoordinates) {
            sum += number;
        }
        return sum;
    }


}
