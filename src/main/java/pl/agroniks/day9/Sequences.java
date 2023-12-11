package pl.agroniks.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sequences {
    private List<List<Integer>> sequences = new ArrayList<>();

    public Sequences(List<Integer> sequence) {
        createSequences(sequence);
    }

    private void createSequences(List<Integer> sequence) {
        boolean areNotSequencesZeros = true;
        int currentIndex = 0;
        sequences.add(sequence); // add first sequence
        while (areNotSequencesZeros) {
            List<Integer> nextSequence = createNextSequence(sequences.get(currentIndex));
            sequences.add(nextSequence);
            if (areWholeSequenceZeros(sequences.get(sequences.size() -1)))
                areNotSequencesZeros = false;
            currentIndex++;
        }
    }

    private List<Integer> createNextSequence(List<Integer> integers) {
        return IntStream.range(0, integers.size() - 1)
                .mapToObj(i -> integers.get(i + 1) - integers.get(i))
                .collect(Collectors.toList());
    }

    private boolean areWholeSequenceZeros(List<Integer> listToCheck) {
        return listToCheck.stream().allMatch(element -> element.equals(0));
    }

    public void predictNextValue() {

        for (int i = sequences.size() - 2; i >= 0; i--) {
            List<Integer> listWithNewValue = sequences.get(i);
            int valueFromPreviousSeq = sequences.get(i + 1).get(sequences.get(i + 1).size() - 1);
            int lastValueOfNewList = listWithNewValue.get(listWithNewValue.size() - 1);
            listWithNewValue.set(listWithNewValue.size() - 1, lastValueOfNewList + valueFromPreviousSeq);
        }
        System.out.println("Predicted Number = " + sequences.get(0).get(sequences.get(0).size() - 1));
    }

    public List<List<Integer>> getSequences() {
        return sequences;
    }

    public void predictBackwards() {
        for (int i = sequences.size() - 2; i >= 0; i--) {
            List<Integer> listWithNewValue = sequences.get(i);
            int valueFromPreviousSeq = sequences.get(i + 1).get(0);
            int lastValueOfNewList = listWithNewValue.get(0);
            List<Integer> newListWithInsertedValue = new ArrayList<>();
            newListWithInsertedValue.add(lastValueOfNewList - valueFromPreviousSeq);
            newListWithInsertedValue.addAll(sequences.get(i));
            sequences.set(i, newListWithInsertedValue);
        }
        System.out.println("Predicted backwards number = " + sequences.get(0).get(0));
    }

    @Override
    public String toString() {
        return "Sequences{" +
                "sequences=" + sequences +
                '}';
    }
}

