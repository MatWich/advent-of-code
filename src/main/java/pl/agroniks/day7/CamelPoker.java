package pl.agroniks.day7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CamelPoker {
    private List<String> inputs;
    private List<String> changedCards = new ArrayList<>();
    private List<HandOfCards> handsOfCards = new ArrayList<>();
    private Integer part = 1;
    private List<HandOfCards> noCombinations = new ArrayList<>();
    private List<HandOfCards> pairs = new ArrayList<>();
    private List<HandOfCards> twoOfPair = new ArrayList<>();
    private List<HandOfCards> threeOfKind = new ArrayList<>();
    private List<HandOfCards> fullHouses = new ArrayList<>();
    private List<HandOfCards> fourOfKind = new ArrayList<>();
    private List<HandOfCards> fiveOfKind = new ArrayList<>();


    public CamelPoker(String input, Integer part) {
        inputs = List.of(input.split("\n"));
        this.part = part;
        prepareData();
        createListForEachCombination();
        sumAllCombinationsBids();

    }

    private void sumAllCombinationsBids() {
        long totalScore = 0;
        final long powerAfterNoCombinations = noCombinations.size() + 1;
        final long powerAfterPairs = powerAfterNoCombinations + pairs.size();
        final long powerAfterTwoOfPairs = powerAfterPairs + twoOfPair.size();
        final long powerAfterThreeOfKind = powerAfterTwoOfPairs + threeOfKind.size();
        final long powerAfterFullHouse = powerAfterThreeOfKind + fullHouses.size();
        final long powerAfterFourOFKinds = powerAfterFullHouse + fourOfKind.size();

        List<HandOfCards> merge = new ArrayList<>();
        merge.addAll(noCombinations);
        merge.addAll(pairs);
        merge.addAll(twoOfPair);
        merge.addAll(threeOfKind);
        merge.addAll(fullHouses);
        merge.addAll(fourOfKind);
        merge.addAll(fiveOfKind);
        merge.forEach(System.out::println);
        System.out.print("Answer 1: ");
        System.out.println(IntStream.range(0, merge.size())
                .mapToLong(i -> merge.get(i).getBid() * (i+1)).sum());

    }

    private void createListForEachCombination() {
        createListForNoCombinations();
        createListForPairs();
        createListForTwoOfPairs();
        createListForThreeOfKind();
        createListForFullHouse();
        createListForFourOfKind();
        createListForFiveOfKind();
    }

    private void createListForNoCombinations() {
        noCombinations = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.NONE))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void createListForPairs() {
        pairs = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.PAIR))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void createListForTwoOfPairs() {
        twoOfPair = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.TWO_OF_PAIR))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void createListForThreeOfKind() {
        threeOfKind = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.THREE_OF_PAIR))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void createListForFullHouse() {
        fullHouses = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.FULL_HOUSE))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void createListForFourOfKind() {
        fourOfKind = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.FOUR_OF_KIND))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void createListForFiveOfKind() {
        fiveOfKind = handsOfCards.stream()
                .filter(handOfCards -> handOfCards.getCombination().equals(CamelCardConstants.FIVE_OF_KIND))
                .sorted(Comparator.comparing(HandOfCards::getCards))
                .collect(Collectors.toList());
    }

    private void prepareData() {
        for(String line : inputs) {
            line = line.replaceAll("A", "Z");
            line = line.replaceAll("K", "Y");
            line = line.replaceAll("Q", "X");
            if (part == 1)
                line = line.replaceAll("J", "W");
            if (part == 2)
                line = line.replaceAll("J", "1");
            line = line.replaceAll("T", "V");
            handsOfCards.add(new HandOfCards(line));
        }
    }


}
