package pl.agroniks.day5;

import java.util.List;

public class Seed {
    private Long number;
    private long soil = -1;
    private long fertilizer = -1;
    private long water = -1;
    private long light = -1;
    private long temperature = -1;
    private long humidity = -1;
    private long location = -1;

    public Seed(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public long getSoil() {
        return soil;
    }

    public void setSoil(long soil) {
        this.soil = soil;
    }

    public long getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(long fertilizer) {
        this.fertilizer = fertilizer;
    }

    public long getWater() {
        return water;
    }

    public void setWater(long water) {
        this.water = water;
    }

    public long getLight() {
        return light;
    }

    public void setLight(long light) {
        this.light = light;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "number=" + number +
                ", soil=" + soil +
                ", fertilizer=" + fertilizer +
                ", water=" + water +
                ", light=" + light +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", location=" + location +
                '}';
    }

    public void calculateSoil(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.number && this.number < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.number;
                setSoil(almanac.getDestinationEnd() - distance);
            }
        }
        if (getSoil() == -1) {
            setSoil(getNumber());
        }
    }

    public void calculateFertilizer(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.soil && this.soil < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.soil;
                setFertilizer(almanac.getDestinationEnd() - distance);
            }
        }

        if(getFertilizer() == -1)
            setFertilizer(getSoil());
    }

    public void calculateWater(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.fertilizer && this.fertilizer < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.fertilizer;
                setWater(almanac.getDestinationEnd() - distance);
            }
        }
        if(getWater() == -1)
            setWater(getFertilizer());
    }

    public void calculateLight(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.water && this.water < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.water;
                setLight(almanac.getDestinationEnd() - distance);
            }
        }
        if(getLight() == -1)
            setLight(getWater());
    }

    public void calculateTemperature(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.light && this.light < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.light;
                setTemperature(almanac.getDestinationEnd() - distance);
            }
        }
        if (getTemperature() == -1)
            setTemperature(getLight());
    }

    public void calculateHumidity(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.temperature && this.temperature < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.temperature;
                setHumidity(almanac.getDestinationEnd() - distance);
            }
        }
        if (getHumidity() == -1)
            setHumidity(getTemperature());
    }

    public void calculateLocation(List<Almanac> almanacs) {
        for (Almanac almanac : almanacs) {
            if (almanac.getSourceStart() <= this.humidity && this.humidity < almanac.getSourceEnd()) {
                long distance = almanac.getSourceEnd() - this.humidity;
                setLocation(almanac.getDestinationEnd() - distance);
            }
        }
        if (getLocation() == -1)
            setLocation(getHumidity());
    }
}
