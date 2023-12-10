package pl.agroniks.day8;

public class HauntedWastelandMain {

    public static void main(String[] args) {

        String inputPart2 = "LR\n" +
                "\n" +
                "11A = (11B, XXX)\n" +
                "11B = (XXX, 11Z)\n" +
                "11Z = (11B, XXX)\n" +
                "22A = (22B, XXX)\n" +
                "22B = (22C, 22C)\n" +
                "22C = (22Z, 22Z)\n" +
                "22Z = (22B, 22B)\n" +
                "XXX = (XXX, XXX)";

        HauntedWasteland wasteland = new HauntedWasteland(inputPart2 ,1);

    }
}
