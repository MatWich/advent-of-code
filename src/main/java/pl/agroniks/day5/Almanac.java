package pl.agroniks.day5;

import java.util.List;

public class Almanac {
    private String name;
    private Long sourceStart;
    private Long destinationStart;
    private Long length;

    public Almanac(String name, Long source, Long destination, Long length) {
        this.name = name;
        this.sourceStart = source;
        this.destinationStart = destination;
        this.length = length;
    }

    public Almanac(String name, List<String> inputs) {
        this.name = name;
        if (inputs.size() == 3) {
            this.destinationStart = Long.parseLong(inputs.get(0));
            this.sourceStart = Long.parseLong(inputs.get(1));
            this.length = Long.parseLong(inputs.get(2));
        } else {
            throw new RuntimeException("Input size should be 3 actual: " + inputs.size());
        }

    }

    public long getSourceEnd() {
        return sourceStart + length;
    }

    public long getDestinationEnd() {
        return destinationStart + length;
    }

    public String getName() {
        return name;
    }

    public Long getSourceStart() {
        return sourceStart;
    }

    public Long getDestinationStart() {
        return destinationStart;
    }

    public Long getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Almanac{" +
                "name='" + name + '\'' +
                ", sourceStart=" + sourceStart +
                ", destinationStart=" + destinationStart +
                ", length=" + length +
                '}';
    }
}
