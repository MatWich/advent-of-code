package pl.agroniks.day5;

import java.util.*;
import java.util.stream.Collectors;

public class SeedAndFertilizer {

    private List<String> inputs;
    private List<Seed> seeds;
    private Map<String, List<Almanac>> almanacs;

    public SeedAndFertilizer(String input, int challengePart) {
        if (challengePart <=0 || challengePart > 3 )
            throw new RuntimeException("Challenge part can be only 1 or 2");

        inputs = List.of(input.split("\n"));
        removeEmptyLines();
        seeds = new ArrayList<>();
        if (challengePart == 1)
            getSeeds();
        if (challengePart == 2)
            getSeedsForRanges();

        almanacs = new HashMap<>();
        getAlmanacs();
        getSeedsLocations();
        getLowestLocation();
    }

    private void getLowestLocation() {
        System.out.println("Lowest Location is: " + seeds.stream().map(Seed::getLocation).min(Long::compare).get());
    }

    private void getSeedsLocations() {
        for (Seed seed : seeds) {
            seed.calculateSoil(almanacs.get(AlmanacConstants.SEED_TO_SOIL));
            seed.calculateFertilizer(almanacs.get(AlmanacConstants.SOIL_TO_FERTILIZER));
            seed.calculateWater(almanacs.get(AlmanacConstants.FERTILIZER_TO_WATER));
            seed.calculateLight(almanacs.get(AlmanacConstants.WATER_TO_LIGHT));
            seed.calculateTemperature(almanacs.get(AlmanacConstants.LIGHT_TO_TEMPERATURE));
            seed.calculateHumidity(almanacs.get(AlmanacConstants.TEMPERATURE_TO_HUMIDITY));
            seed.calculateLocation(almanacs.get(AlmanacConstants.HUMIDITY_TO_LOCATION));
        }
    }


    private void getAlmanacs() {
        List<String> almanacsAsStrings = inputs.stream().skip(1).toList();
        // TODO: Wyciągnąć linie w których są constanty
        List<Integer> indexesOfMaps = getIndexesOfMaps(almanacsAsStrings);
        indexesOfMaps.forEach(System.out::println);

        // TODO: Wyciągnąć linie pomiędzy constantami do osobnych tablic
        int currentAlmanac = -1;
        for (int i = 0; i < almanacsAsStrings.size(); i++) {
            String line = almanacsAsStrings.get(i);
            if (!Character.isDigit(line.charAt(0))) {
                currentAlmanac++;
            } else {
                List<String> strings = Arrays.stream(almanacsAsStrings.get(i).split(" ")).toList();
                if (strings.size() != 3) {
                    throw new RuntimeException("BAD DATA POINT");
                }
                almanacs.get(AlmanacConstants.ALL_ALMANAC_NAMES.get(currentAlmanac))
                        .add(new Almanac(AlmanacConstants.ALL_ALMANAC_NAMES.get(currentAlmanac),
                        strings));
            }
        }
//        for (Map.Entry<String, List<Almanac>> entry : almanacs.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
    }

    private List<Integer> getIndexesOfMaps(List<String> almanacsAsStrings) {
        List<Integer> indexOfMaps = new ArrayList<>();
        indexOfMaps.add(getStringIndex(AlmanacConstants.SEED_TO_SOIL, almanacsAsStrings));
        almanacs.put(AlmanacConstants.SEED_TO_SOIL, new ArrayList<>());
        indexOfMaps.add(getStringIndex(AlmanacConstants.SOIL_TO_FERTILIZER, almanacsAsStrings));
        almanacs.put(AlmanacConstants.SOIL_TO_FERTILIZER, new ArrayList<>());
        indexOfMaps.add(getStringIndex(AlmanacConstants.FERTILIZER_TO_WATER, almanacsAsStrings));
        almanacs.put(AlmanacConstants.FERTILIZER_TO_WATER, new ArrayList<>());
        indexOfMaps.add(getStringIndex(AlmanacConstants.WATER_TO_LIGHT, almanacsAsStrings));
        almanacs.put(AlmanacConstants.WATER_TO_LIGHT, new ArrayList<>());
        indexOfMaps.add(getStringIndex(AlmanacConstants.LIGHT_TO_TEMPERATURE, almanacsAsStrings));
        almanacs.put(AlmanacConstants.LIGHT_TO_TEMPERATURE, new ArrayList<>());
        indexOfMaps.add(getStringIndex(AlmanacConstants.TEMPERATURE_TO_HUMIDITY, almanacsAsStrings));
        almanacs.put(AlmanacConstants.TEMPERATURE_TO_HUMIDITY, new ArrayList<>());
        indexOfMaps.add(getStringIndex(AlmanacConstants.HUMIDITY_TO_LOCATION, almanacsAsStrings));
        almanacs.put(AlmanacConstants.HUMIDITY_TO_LOCATION, new ArrayList<>());
        return indexOfMaps;
    }

    private Integer getStringIndex(String phrase, List<String> almanacsAsStrings) {
        return  almanacsAsStrings.indexOf(phrase + " map:");
    }
    private void getSeeds() {
        List<Long> seedNumbers = getIntegersFromString(inputs.get(0));

        for (Long seedNumber : seedNumbers) {
            seeds.add(new Seed(seedNumber));
        }
    }

    private void getSeedsForRanges() {
        List<Long> seedNumbers = getIntegersFromString(inputs.get(0));
        for (int i = 0; i < seedNumbers.size(); i+=2) {
            Long startingSeedNumber = seedNumbers.get(i);

            for (Long j = startingSeedNumber; j < startingSeedNumber + seedNumbers.get(i+1); j++) {
                seeds.add(new Seed(j));
            }
        }
    }

    private List<Long> getIntegersFromString(String line) {
        List<Long> numbers = new ArrayList<>();
        line = line.replaceAll("seeds: ", "");
        String[] numbersAsStrings = line.split(" ");

        for (String number : numbersAsStrings) {
            numbers.add(Long.parseLong(number));
        }
        return numbers;
    }


    private void removeEmptyLines() {
        inputs = inputs.stream().filter(line -> !line.isEmpty()).collect(Collectors.toList());
    }


}
