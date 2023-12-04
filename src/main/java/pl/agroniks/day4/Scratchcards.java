package pl.agroniks.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scratchcards {
    List<String> inputs;
    List<List<Integer>> winningNumbers;
    List<List<Integer>> playerNumbers;
    Map<Integer, Integer> additionalScratchCards;

    public Scratchcards(String input) {
        inputs = List.of(input.split("\n"));
        winningNumbers = new ArrayList<>();
        playerNumbers = new ArrayList<>();
        additionalScratchCards = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++)
            additionalScratchCards.put(i, 1);
    }

    public void sumAllWinningPoints() {
        prepareWinningAndPlayersNumbers();

    }

    private void prepareWinningAndPlayersNumbers() {
        for (String line : inputs) {
            String modifiedLine = removeCardNumber(line);
            modifiedLine = removeAdditionalSpaceAtBeggining(modifiedLine);
            System.out.println(modifiedLine);
            extractNumbers(modifiedLine);
        }
        if (playerNumbers.size() == winningNumbers.size()) // everything works ok
            findPairsForEachCardAndAddTheirWinningValue();
    }

    private void findPairsForEachCardAndAddTheirWinningValue() {
        int sum = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            int matches = 0;
            for (int number : winningNumbers.get(i)) {
                if (playerNumbers.get(i).contains(number))
                    matches += 1;
            }
            // TODO: Update for all newly won scratch cards
            for (int j = 1; j <= matches; j++)
            {
                additionalScratchCards.replace(i+j, additionalScratchCards.get(i+j) + 1 * additionalScratchCards.get(i));
            }
            sum += calculatePoints(matches);
        }
        System.out.println("Answer for part 1: " + sum);
        System.out.println("Answer for part 2: " + sumAllScratchCards());
    }

    private Integer sumAllScratchCards() {
        int sumOfScratchCards = 0;
        for (Map.Entry<Integer, Integer> entry : additionalScratchCards.entrySet()) {
            sumOfScratchCards += entry.getValue();
        }
        return sumOfScratchCards;
    }

    private int calculatePoints(Integer matches) {
        if (matches <= 0)
            return 0;
        else if (matches == 1)
            return 1;
        else {
            int score = 1;
            for (int i = 0; i < matches -1; i++){
                score *= 2;
            }
            return score;
        }



    }


    private void extractNumbers(String line) {
        boolean arePlayerNumbers = true;
        List<Integer> playerNumbersPerGame = new ArrayList<>();
        List<Integer> winningNumberPerGame = new ArrayList<>();

        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            char symbol = line.charAt(i);
            if (Character.isDigit(symbol)) {
                numbers.append(symbol);
            }

            if (symbol == ' ' || i == line.length() -1) {
                if (!numbers.isEmpty()) {
                    if (arePlayerNumbers)
                        playerNumbersPerGame.add(Integer.parseInt(numbers.toString()));
                    else
                        winningNumberPerGame.add(Integer.parseInt(numbers.toString()));
                    numbers.setLength(0);
                }
            }

            if (symbol == '|' || i == 0)
                arePlayerNumbers = !arePlayerNumbers;
        }

        playerNumbers.add(playerNumbersPerGame);
        winningNumbers.add(winningNumberPerGame);
    }

    private String removeAdditionalSpaceAtBeggining(String modifiedLine) {
        if (modifiedLine.charAt(0) == ' ') {
            return modifiedLine.replaceFirst(" ", "");
        }
        return modifiedLine;
    }

    private String removeCardNumber(String line) {
        return line.replaceAll("Card.*: ", "");
    }

}
