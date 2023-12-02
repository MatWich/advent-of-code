package pl.agroniks.day2;

public class GameSet {
    private Integer gameNumber;
    private Integer redCubes = 0;
    private Integer greenCubes = 0;
    private Integer blueCubes = 0;


    public GameSet(Integer gameNumber, Integer redCubes, Integer greenCubes, Integer blueCubes) {
        this.gameNumber = gameNumber;
        this.redCubes = redCubes;
        this.blueCubes = blueCubes;
        this.greenCubes = greenCubes;
    }

    public GameSet() {
        redCubes = 0;
        greenCubes = 0;
        blueCubes = 0;
    }

    public boolean isLowerThan(GameSet gameSet) {
        return this.redCubes <= gameSet.redCubes && this.greenCubes <= gameSet.greenCubes && this.blueCubes <= gameSet.blueCubes;
    }

    public Integer getRedCubes() {
        return redCubes;
    }

    public void setRedCubes(Integer redCubes) {
        this.redCubes = redCubes;
    }

    public Integer getGreenCubes() {
        return greenCubes;
    }

    public void setGreenCubes(Integer greenCubes) {
        this.greenCubes = greenCubes;
    }

    public Integer getBlueCubes() {
        return blueCubes;
    }

    public void setBlueCubes(Integer blueCubes) {
        this.blueCubes = blueCubes;
    }

    @Override
    public String toString() {
        return "GameSet{" +
                "redCubes=" + redCubes +
                ", greenCubes=" + greenCubes +
                ", blueCubes=" + blueCubes +
                '}';
    }
}
