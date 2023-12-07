package pl.agroniks.day6;

public class BoatRaceMain {
    public static void main(String[] args) {
        String input =
                "Time:        58     99     64     69\n" +
                        "Distance:   478   2232   1019   1071";

        BoatRace boatRace = new BoatRace(input, 2);
        boatRace.getAllRaceWaysToBeatHighScoreMultiplied();
    }
}
