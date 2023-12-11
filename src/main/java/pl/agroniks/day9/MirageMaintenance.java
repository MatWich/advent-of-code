package pl.agroniks.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MirageMaintenance {
    private List<String> inputs;
    private List<Sequences> sequences = new ArrayList<>();
    public MirageMaintenance(String input) {
        inputs = List.of(input.split("\n"));
        createSequences();
        predictNextValues();
        sumPredictedValues();

        predictBackwards();
    }

    private void predictBackwards() {
        int sum = 0;
        for (Sequences seq : sequences) {
            seq.predictBackwards();
            sum += seq.getSequences().get(0).get(0);
        }
        System.out.println("Summed up number(part 2): " + sum);
    }

    private void sumPredictedValues() {
        int sum = 0;

        for (Sequences seq : sequences) {
            sum += seq.getSequences().get(0).get(seq.getSequences().get(0).size() - 1);
        }

        System.out.println("Summed up number: " + sum);
    }

    private void predictNextValues() {
        for (Sequences seq : sequences) {
            seq.predictNextValue();
        }
//        sequences.forEach(System.out::println);
    }

    private void createSequences() {
        for (String line : inputs) {
            sequences.add(new Sequences(extractNumbers(line)));
        }

        sequences.forEach(System.out::println);
    }

    private List<Integer> extractNumbers(String line) {
        return Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }


}
