package pl.agroniks.day10;

public class PipeStartingPoint {
    private Integer x;
    private Integer y;

    public PipeStartingPoint(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "PipeStartingPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
