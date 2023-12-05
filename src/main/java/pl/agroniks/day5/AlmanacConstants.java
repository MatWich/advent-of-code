package pl.agroniks.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlmanacConstants {
    private AlmanacConstants() {}

    public static final String SEED_TO_SOIL = "seed-to-soil";
    public static final String SOIL_TO_FERTILIZER = "soil-to-fertilizer";
    public static final String FERTILIZER_TO_WATER = "fertilizer-to-water";
    public static final String WATER_TO_LIGHT = "water-to-light";
    public static final String LIGHT_TO_TEMPERATURE = "light-to-temperature";
    public static final String TEMPERATURE_TO_HUMIDITY = "temperature-to-humidity";
    public static final String HUMIDITY_TO_LOCATION = "humidity-to-location";

    public static final List<String> ALL_ALMANAC_NAMES =  Arrays.asList(
            SEED_TO_SOIL,
            SOIL_TO_FERTILIZER,
            FERTILIZER_TO_WATER,
            WATER_TO_LIGHT,
            LIGHT_TO_TEMPERATURE,
            TEMPERATURE_TO_HUMIDITY,
            HUMIDITY_TO_LOCATION);
    public static final Integer NUMBER_OF_ALMANACS = ALL_ALMANAC_NAMES.size();
}
