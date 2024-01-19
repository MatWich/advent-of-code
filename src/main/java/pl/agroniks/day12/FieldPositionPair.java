package pl.agroniks.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FieldPositionPair {
    private String field;
    private List<Integer> damagedGroups;
    public FieldPositionPair(String[] s) {
        field = s[0];
        damagedGroups = extractNumbers(s[1]);
    }

    private List<Integer> extractNumbers(String s) {
        return Arrays.stream(s.split(",")).map(Integer::parseInt).toList();
    }

    public Integer generateAllPossibilities() {
        int possibilities = 0;

        List<Integer> questionMark = getQuestionMarkPositions();
        System.out.println(questionMark);



        return possibilities;
    }

    private List<Integer> getQuestionMarkPositions() {
        return IntStream.range(0, field.length())
                .filter(i -> field.charAt(i) == '?').boxed().toList();
    }

    @Override
    public String toString() {
        return "FieldPositionPair{" +
                "field='" + field + '\'' +
                ", damagedGroups=" + damagedGroups +
                '}';
    }
}
