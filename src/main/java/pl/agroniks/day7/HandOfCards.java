package pl.agroniks.day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HandOfCards {
    private Integer bid;
    private String cards;
    private String combination = CamelCardConstants.NONE;


    public HandOfCards(String line) {
        bid = Integer.parseInt(line.split(" ")[1]);
        cards = line.split(" ")[0];
        defineCombination();
    }

    private void defineCombination() {
        Map<Character, Integer> cardsAmount = new HashMap<>();
        for (int i = 0; i < cards.length(); i++) {
            Character currentCard = cards.charAt(i);
            if (cardsAmount.get(currentCard) == null)
                cardsAmount.put(currentCard, 1);
            else
                cardsAmount.replace(currentCard, cardsAmount.get(currentCard) + 1);
        }

        if (isPair(cardsAmount)) {
            combination = CamelCardConstants.PAIR;
        }

        if (isTwoOfPair(cardsAmount)) {
            combination = CamelCardConstants.TWO_OF_PAIR;
        }

        if (isThreeOfKind(cardsAmount)) {
            combination = CamelCardConstants.THREE_OF_PAIR;
        }

        if (isFullHouse(cardsAmount)) {
            combination = CamelCardConstants.FULL_HOUSE;
        }

        if (isFourOfKind(cardsAmount)) {
            combination = CamelCardConstants.FOUR_OF_KIND;
        }

        if (isFiveOdKinds(cardsAmount)) {
            combination = CamelCardConstants.FIVE_OF_KIND;
        }

    }

    private boolean isFiveOdKinds(Map<Character, Integer> cardsAmount) {
        if (cardsAmount.containsKey('1') && cardsAmount.size() == 2) {
            return true;
        }

        return cardsAmount.values().stream().max(Integer::compareTo).get() == 5;
    }

    private boolean isFourOfKind(Map<Character, Integer> cardsAmount) {
        if (cardsAmount.containsKey('1')) {
            for (Character symbol : cardsAmount.keySet()) {
                if (symbol != '1') {
                    cardsAmount.replace(symbol, cardsAmount.get(symbol) + cardsAmount.get('1'));
                }
            }
        }
        return cardsAmount.values().stream().max(Integer::compareTo).get() == 4;
    }


    private boolean isFullHouse(Map<Character, Integer> cardsAmount) {

        if (cardsAmount.containsKey('1')) {
            Map<Character, Integer> cardsToConsider = new HashMap<>();
            int jokers = cardsAmount.get('1');
            for (Map.Entry<Character, Integer> entry : cardsAmount.entrySet()) {
                if (entry.getKey() != '1') {
                    cardsToConsider.put(entry.getKey(), entry.getValue());
                }
            }
            return cardsToConsider.size() == 2 && cardsToConsider.values().stream().max(Integer::compareTo).get() == 2;
        } else {
            return cardsAmount.size() == 2 && isThreeOfKind(cardsAmount);

        }
    }


    private boolean isThreeOfKind(Map<Character, Integer> cardsAmount) {
        if (cardsAmount.containsKey('1')) {
            return cardsAmount.values().stream().max(Integer::compareTo).get() >= 3 - cardsAmount.get('1');
        }
        return cardsAmount.values().stream().max(Integer::compareTo).get() == 3;
    }

    private boolean isTwoOfPair(Map<Character, Integer> cardsAmount) {
        return cardsAmount.size() == 3 && cardsAmount.values().stream().max(Integer::compareTo).get() == 2;
    }

    private boolean isPair(Map<Character, Integer> cardsAmount) {
        if (cardsAmount.containsKey('1'))
            return true;
        return cardsAmount.values().stream().max(Integer::compareTo).get() == 2;
    }

    @Override
    public String toString() {
        return "HandOfCards{" +
                "bid=" + bid +
                ", cards='" + cards + '\'' +
                ", combination='" + combination + '\'' +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public String getCards() {
        return cards;
    }

    public String getCombination() {
        return combination;
    }
}
