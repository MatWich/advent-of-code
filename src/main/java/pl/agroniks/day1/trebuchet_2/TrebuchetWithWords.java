package pl.agroniks.day1.trebuchet_2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrebuchetWithWords {
    private final List<String> inputs;
    private final List<String> onlyDigitsInputs;
    private final List<Integer> mergedCoordinates;


    public TrebuchetWithWords(String input) {
        this.inputs = List.of(input.split("\n"));
        onlyDigitsInputs = new ArrayList<>();
        mergedCoordinates = new ArrayList<>();
    }

    public void countCoordinates() {
        replaceWordsToDigits();
        getCombinedNumbers();
        sumAllCombinedNumbers();

    }

    private void replaceWordsToDigits() {
        for (String line : inputs) {
            line = insertCorrectNumberInWord(line, "zero", 0);
            line = insertCorrectNumberInWord(line, "one", 1);
            line = insertCorrectNumberInWord(line, "two", 2);
            line = insertCorrectNumberInWord(line, "three", 3);
            line = insertCorrectNumberInWord(line, "four", 4);
            line = insertCorrectNumberInWord(line, "five", 5);
            line = insertCorrectNumberInWord(line, "six", 6);
            line = insertCorrectNumberInWord(line, "seven", 7);
            line = insertCorrectNumberInWord(line, "eight", 8);
            line = insertCorrectNumberInWord(line, "nine", 9);
            onlyDigitsInputs.add(line);
        }
    }

    private Integer mergeToNumber(Character tens, Character units) {
        return Character.getNumericValue(tens) * 10 + Character.getNumericValue(units);
    }

    private void getCombinedNumbers() {
        for (String str : onlyDigitsInputs) {
            List<Character> coordinates = getCoordinates(str);
            int combined = mergeToNumber(getFirstDigit(coordinates), getLastDigit(coordinates));
            System.out.println(combined);
            mergedCoordinates.add(combined);
        }
    }

    private List<Character> getCoordinates(String line) {
        List<Character> digits = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                digits.add(line.charAt(i));
            }
        }
        return digits;
    }

    private Character getLastDigit(List<Character> coordinates) {
        return coordinates.get(coordinates.size() - 1);
    }

    private Character getFirstDigit(List<Character> coordinates) {
        return coordinates.get(0);
    }

    private void sumAllCombinedNumbers() {
        int sum = 0;
        for (int i : mergedCoordinates) {
            sum += i;
        }
        System.out.println("Coordinates sum:" + sum);
    }


    private String insertCorrectNumberInWord(String line, String word, Integer digit) {
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find())
            return matcher.replaceAll(word + digit + word);
        return line; // nothing changed
    }

}
