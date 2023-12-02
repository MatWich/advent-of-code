package pl.agroniks.day2;

public class CubeConundrumMain {
    public static void main(String[] args) {
        String input = "Game 1: 1 blue; 4 green, 5 blue; 11 red, 3 blue, 11 green; 1 red, 10 green, 4 blue; 17 red, 12 green, 7 blue; 3 blue, 19 green, 15 red\n" +
                "Game 2: 17 red, 10 green; 3 blue, 17 red, 7 green; 10 green, 1 blue, 10 red; 7 green, 15 red, 1 blue; 7 green, 8 blue, 16 red; 18 red, 5 green, 3 blue\n" +
                "Game 3: 10 blue, 3 green, 8 red; 15 green, 14 blue, 1 red; 8 blue, 11 red, 2 green; 5 red, 9 green, 6 blue\n" +
                "Game 4: 1 red, 3 blue; 3 blue, 3 green, 1 red; 11 blue, 2 green; 2 green, 14 blue; 1 green, 7 blue; 11 blue, 5 green\n" +
                "Game 5: 9 green, 5 red, 10 blue; 9 red, 4 blue, 12 green; 9 green, 6 blue, 14 red; 16 green, 8 red, 6 blue; 11 blue, 13 red, 1 green\n" +
                "Game 6: 1 blue, 2 green, 16 red; 1 green, 19 red; 1 blue; 3 blue, 2 red, 1 green; 18 red, 2 blue, 1 green\n" +
                "Game 7: 2 blue, 9 red, 5 green; 11 blue, 6 green, 4 red; 7 red, 3 green, 5 blue; 5 green, 11 blue, 7 red; 17 blue, 4 red, 3 green; 20 blue, 1 green, 2 red\n" +
                "Game 8: 1 green, 6 red, 4 blue; 8 green, 4 blue, 2 red; 2 blue, 5 green\n" +
                "Game 9: 1 green, 5 blue; 4 blue; 2 red, 1 blue\n" +
                "Game 10: 1 green, 12 blue; 6 red, 4 green; 5 green, 14 blue, 9 red; 6 red, 13 blue, 2 green; 6 red, 17 blue, 1 green\n" +
                "Game 11: 19 green, 1 red; 15 red, 7 green; 1 blue, 8 red, 14 green; 1 blue, 11 green, 1 red\n" +
                "Game 12: 4 red, 3 green, 12 blue; 4 green, 13 red; 2 green, 15 blue, 5 red; 5 red, 10 blue, 3 green; 3 green, 17 blue, 17 red; 1 red, 4 green, 15 blue\n" +
                "Game 13: 5 red, 7 blue; 6 red, 1 green, 11 blue; 17 blue, 11 green, 4 red; 6 red, 9 green, 5 blue; 4 green, 14 blue\n" +
                "Game 14: 6 red, 15 blue, 3 green; 4 green, 4 blue, 3 red; 3 blue, 1 green, 5 red\n" +
                "Game 15: 4 green, 3 blue, 6 red; 3 blue, 2 red, 4 green; 15 red, 3 green, 4 blue; 11 red, 2 blue, 1 green\n" +
                "Game 16: 4 green, 1 blue, 12 red; 10 green, 6 blue, 10 red; 1 blue, 2 green, 15 red; 1 green, 3 red, 4 blue\n" +
                "Game 17: 10 green, 11 blue; 13 green, 10 blue, 3 red; 8 red, 3 green, 10 blue\n" +
                "Game 18: 3 red; 4 red, 1 blue; 3 green, 3 red; 10 green, 1 blue; 4 red, 6 green, 1 blue; 3 green\n" +
                "Game 19: 4 red, 6 green; 11 red, 4 blue, 2 green; 4 green, 8 red; 9 red, 7 green, 2 blue; 13 red, 4 blue; 9 red\n" +
                "Game 20: 2 blue, 1 green, 8 red; 3 green, 11 blue, 1 red; 5 blue, 4 red, 6 green; 6 green, 7 red, 5 blue; 7 red, 2 green, 1 blue\n" +
                "Game 21: 7 blue, 3 green; 2 green, 2 red, 7 blue; 6 blue, 3 red, 1 green; 9 blue, 1 green, 3 red\n" +
                "Game 22: 7 red, 5 blue, 9 green; 6 red, 1 blue, 5 green; 18 red, 7 green, 5 blue; 13 red, 11 green, 1 blue; 13 red, 1 blue, 11 green\n" +
                "Game 23: 10 green, 1 blue, 5 red; 2 red, 4 green; 9 green, 2 red; 10 green, 1 blue, 5 red\n" +
                "Game 24: 2 red, 6 green, 16 blue; 3 blue, 12 red, 3 green; 6 blue, 4 red, 12 green; 12 green, 14 blue, 3 red\n" +
                "Game 25: 5 red, 2 blue, 1 green; 4 blue, 14 red, 2 green; 16 blue, 4 red; 5 red; 12 blue, 16 red; 2 red, 6 blue, 1 green\n" +
                "Game 26: 10 blue, 6 green, 5 red; 2 red, 2 green; 8 blue, 5 red; 7 blue, 11 green; 8 green, 9 blue\n" +
                "Game 27: 1 red, 2 green; 6 green, 10 blue; 1 red, 6 green, 11 blue; 4 blue, 1 green, 1 red; 1 red, 7 blue; 5 green, 2 blue, 1 red\n" +
                "Game 28: 6 blue, 5 red, 3 green; 5 blue, 1 green; 1 green, 8 red, 1 blue; 2 blue, 4 green; 4 red, 5 blue\n" +
                "Game 29: 2 red, 4 green, 6 blue; 6 blue, 2 green, 1 red; 10 green, 13 blue, 2 red; 11 green, 11 blue, 2 red; 5 red, 10 green\n" +
                "Game 30: 4 green, 4 blue, 5 red; 6 red, 18 green, 7 blue; 1 red, 11 green, 2 blue; 11 red, 2 blue, 1 green\n" +
                "Game 31: 1 red, 7 green, 2 blue; 5 red, 6 green, 9 blue; 3 green, 1 red, 9 blue; 3 red; 8 blue, 6 green, 1 red; 14 blue, 4 green, 7 red\n" +
                "Game 32: 11 red, 2 blue, 2 green; 18 blue, 1 green; 6 blue, 1 green, 15 red; 4 red, 2 green; 13 red, 6 green, 5 blue; 7 blue, 5 green\n" +
                "Game 33: 12 blue, 2 red, 2 green; 5 blue, 3 green; 2 green, 6 red, 4 blue; 12 blue, 13 red; 10 blue, 12 red, 1 green; 4 blue, 4 red\n" +
                "Game 34: 2 blue, 1 red, 6 green; 2 blue, 1 green; 1 red, 2 green, 2 blue; 17 red, 1 blue, 2 green; 4 green, 2 red\n" +
                "Game 35: 2 blue, 12 red, 2 green; 2 green, 8 red, 11 blue; 17 red, 16 blue; 8 blue, 8 red; 1 green, 6 red, 9 blue\n" +
                "Game 36: 6 red, 14 green, 7 blue; 1 green, 1 red, 6 blue; 9 red, 10 blue, 9 green; 11 blue, 14 green, 8 red; 10 red, 6 green, 3 blue\n" +
                "Game 37: 6 green; 2 red, 5 green; 4 blue, 4 red, 5 green; 1 red, 7 green, 4 blue\n" +
                "Game 38: 1 green, 8 red, 10 blue; 3 green, 5 red, 12 blue; 13 blue, 5 red, 1 green; 3 green, 1 red; 3 red, 15 blue, 6 green; 3 green, 6 red, 4 blue\n" +
                "Game 39: 15 green, 3 blue; 3 green; 3 blue, 3 red, 8 green; 4 blue, 10 green, 4 red; 2 green, 5 blue, 4 red; 3 green, 3 blue, 1 red\n" +
                "Game 40: 2 red, 3 green, 15 blue; 5 blue, 13 green, 2 red; 11 blue, 1 red; 5 blue, 20 green, 5 red\n" +
                "Game 41: 1 red, 2 green, 1 blue; 10 red; 11 green, 1 blue, 5 red; 10 red, 13 green\n" +
                "Game 42: 10 red, 8 green, 2 blue; 5 green, 4 red; 6 red; 5 red, 9 green, 2 blue; 2 blue, 2 red, 3 green; 1 blue, 7 red, 2 green\n" +
                "Game 43: 8 red, 6 blue, 12 green; 11 green, 2 red, 2 blue; 4 blue, 3 red, 8 green; 14 red, 3 blue; 9 green, 1 blue, 5 red\n" +
                "Game 44: 4 red, 5 blue, 4 green; 9 blue, 1 green; 10 green, 2 blue, 4 red; 5 red, 15 green, 12 blue\n" +
                "Game 45: 1 red, 2 green; 5 blue; 3 blue, 1 red; 1 blue; 4 green, 1 red\n" +
                "Game 46: 3 green, 8 red, 5 blue; 1 blue, 10 red, 5 green; 2 green, 5 red, 3 blue; 5 green, 4 red, 13 blue\n" +
                "Game 47: 2 green, 1 blue; 2 red, 2 green, 6 blue; 1 green, 1 red, 1 blue; 2 green, 4 blue, 4 red; 2 green, 6 blue, 3 red\n" +
                "Game 48: 4 blue, 1 green, 2 red; 6 blue, 1 red; 4 blue\n" +
                "Game 49: 16 blue, 18 green, 13 red; 7 red, 13 blue; 14 green, 12 red; 20 green, 14 red, 12 blue\n" +
                "Game 50: 8 blue, 2 red, 1 green; 4 red, 2 green, 5 blue; 6 blue, 2 green; 8 blue, 3 green, 5 red; 1 green, 4 blue\n" +
                "Game 51: 2 blue, 8 red; 2 green, 3 red, 2 blue; 12 green; 3 blue, 10 green, 1 red; 13 green, 3 blue, 5 red\n" +
                "Game 52: 12 blue, 5 red, 16 green; 4 blue, 13 green; 2 red, 5 blue, 5 green; 4 green, 8 blue, 3 red\n" +
                "Game 53: 7 blue, 5 green; 8 green, 8 blue; 4 red, 1 green; 8 blue, 5 red, 11 green\n" +
                "Game 54: 4 blue, 3 green, 1 red; 10 green, 4 red, 7 blue; 1 red, 6 blue, 2 green\n" +
                "Game 55: 2 red, 10 blue; 13 red, 10 blue; 4 red, 5 blue, 4 green; 3 green, 8 blue; 5 blue, 7 red, 2 green\n" +
                "Game 56: 6 green, 7 blue, 9 red; 3 blue, 4 green; 15 red, 3 blue, 3 green; 5 red, 8 green, 7 blue\n" +
                "Game 57: 9 red, 13 blue, 2 green; 3 red, 2 green, 3 blue; 1 blue, 5 red, 3 green; 9 blue, 2 green, 2 red; 3 red, 12 blue, 3 green; 2 green, 7 red\n" +
                "Game 58: 4 blue, 7 red; 2 blue, 5 green, 1 red; 17 blue, 3 red; 5 green, 1 blue, 4 red; 4 green, 14 blue, 3 red\n" +
                "Game 59: 5 blue, 4 red; 7 red; 4 blue, 4 red, 1 green; 1 green, 1 blue, 5 red\n" +
                "Game 60: 4 red, 2 green; 1 green, 2 blue; 2 red, 2 green; 4 red, 2 green; 3 red\n" +
                "Game 61: 6 red, 14 green; 12 green, 3 blue; 3 blue, 16 green, 11 red\n" +
                "Game 62: 12 green, 2 red, 1 blue; 14 red, 2 blue, 4 green; 7 red, 5 green, 1 blue; 4 green, 14 red, 1 blue; 2 blue, 7 green, 3 red; 14 red, 9 green, 2 blue\n" +
                "Game 63: 1 red, 8 blue, 12 green; 3 green, 10 blue, 4 red; 2 red, 1 blue, 2 green; 2 red, 8 green; 4 red, 3 blue, 9 green; 13 green, 4 blue\n" +
                "Game 64: 4 blue, 9 green, 4 red; 10 green, 6 blue, 7 red; 10 green, 8 red, 1 blue; 13 blue, 8 green, 8 red; 4 green, 1 red, 8 blue\n" +
                "Game 65: 16 blue, 5 red, 13 green; 5 red, 9 green, 10 blue; 2 green, 14 red; 6 red, 5 green, 5 blue; 19 blue, 4 green, 14 red; 7 red, 1 blue, 4 green\n" +
                "Game 66: 7 blue, 11 green, 5 red; 7 green, 8 red, 10 blue; 3 red, 1 green\n" +
                "Game 67: 9 green, 2 blue, 13 red; 11 red, 10 blue; 14 red, 1 green, 1 blue; 1 red, 13 green, 6 blue; 7 blue, 3 green, 5 red; 3 green, 2 blue\n" +
                "Game 68: 6 green, 2 blue; 1 blue, 3 red, 5 green; 1 blue, 10 green\n" +
                "Game 69: 4 red, 6 blue, 1 green; 6 blue, 2 red, 4 green; 9 green, 7 blue, 2 red\n" +
                "Game 70: 11 blue, 1 green, 4 red; 7 blue, 1 green; 6 red, 9 blue; 1 green, 3 red, 7 blue; 1 green, 9 blue, 2 red\n" +
                "Game 71: 2 green, 6 red; 1 blue, 2 green, 15 red; 6 red, 1 blue; 2 green, 5 red\n" +
                "Game 72: 5 green, 6 red; 8 red, 1 blue, 12 green; 1 blue, 9 red, 15 green; 11 green, 1 blue, 6 red; 14 green, 5 red\n" +
                "Game 73: 9 green, 13 red, 1 blue; 14 green, 5 blue, 13 red; 13 green, 10 red, 16 blue; 3 blue, 7 red, 1 green; 7 red, 6 green, 11 blue\n" +
                "Game 74: 1 blue, 9 red, 15 green; 3 blue, 7 green; 9 green, 1 blue, 7 red\n" +
                "Game 75: 5 blue, 12 red, 2 green; 2 blue, 2 green; 4 green, 2 red, 7 blue; 4 green, 7 blue, 5 red; 1 green, 7 blue, 3 red\n" +
                "Game 76: 1 blue; 8 red, 13 blue; 4 green, 7 blue, 7 red; 3 red, 12 blue, 2 green; 2 green, 2 blue, 1 red\n" +
                "Game 77: 4 blue; 4 blue; 1 blue, 1 red; 1 red, 5 blue; 10 blue, 1 green\n" +
                "Game 78: 3 blue, 10 green, 6 red; 12 red, 7 blue, 8 green; 2 green, 18 red, 5 blue; 2 red, 15 blue, 14 green; 4 green, 6 blue, 13 red\n" +
                "Game 79: 7 red, 1 green; 1 blue, 6 red, 2 green; 1 blue, 12 red\n" +
                "Game 80: 4 red, 6 blue, 2 green; 5 blue, 2 red; 6 blue, 7 red, 2 green\n" +
                "Game 81: 2 green, 9 red; 2 green, 2 blue, 7 red; 12 red, 7 green; 8 green, 3 red, 3 blue\n" +
                "Game 82: 4 green, 5 blue; 2 red, 16 blue; 2 red, 2 green, 18 blue\n" +
                "Game 83: 14 red, 2 green; 3 blue, 16 red, 2 green; 4 green, 13 red, 1 blue\n" +
                "Game 84: 10 green, 6 blue, 2 red; 5 red, 6 blue; 7 green, 6 red, 9 blue\n" +
                "Game 85: 1 red; 12 red, 1 blue, 2 green; 6 red, 1 green; 12 red, 2 green\n" +
                "Game 86: 14 red, 1 green, 3 blue; 3 blue; 4 green, 8 red, 2 blue; 10 red, 2 green\n" +
                "Game 87: 4 red, 9 green, 8 blue; 3 green, 6 blue, 7 red; 4 blue, 1 red; 2 red, 7 blue, 11 green; 8 green, 2 blue, 5 red; 6 blue, 10 green, 8 red\n" +
                "Game 88: 1 green, 1 red; 2 green, 1 blue; 3 green, 1 red, 1 blue; 4 green; 1 blue, 3 green, 1 red\n" +
                "Game 89: 11 green, 7 blue, 8 red; 7 blue, 3 green, 2 red; 7 green, 6 red, 4 blue; 1 blue, 2 green, 10 red; 3 red, 2 blue, 1 green\n" +
                "Game 90: 10 green, 12 red, 2 blue; 7 red, 7 blue, 8 green; 2 blue, 11 red, 7 green; 6 green, 5 red, 2 blue; 7 red, 10 green\n" +
                "Game 91: 12 red, 8 green; 8 red, 6 green, 3 blue; 12 red, 4 blue, 2 green\n" +
                "Game 92: 10 blue, 3 green; 4 red, 13 blue, 8 green; 7 green, 8 blue, 7 red\n" +
                "Game 93: 7 red, 4 green, 1 blue; 15 green, 4 red; 2 blue, 15 red\n" +
                "Game 94: 10 red, 10 green, 11 blue; 3 red, 1 green, 7 blue; 9 red, 4 green, 9 blue; 7 red, 9 green, 13 blue; 9 blue, 2 green, 10 red\n" +
                "Game 95: 4 blue, 12 green; 7 green, 1 red, 5 blue; 2 blue, 8 green, 8 red\n" +
                "Game 96: 12 green, 2 blue; 11 green, 3 blue; 3 red, 2 green, 5 blue; 12 green, 2 blue, 4 red; 2 blue, 1 green, 1 red; 3 red, 11 green, 3 blue\n" +
                "Game 97: 6 red, 3 blue, 1 green; 1 blue, 2 red, 14 green; 4 blue, 14 green\n" +
                "Game 98: 13 green, 1 red, 5 blue; 2 red, 5 green, 7 blue; 19 green, 5 blue; 4 blue, 13 green; 5 green, 8 blue\n" +
                "Game 99: 11 red, 8 green; 16 red, 10 green; 9 red, 6 green; 3 blue, 2 red, 4 green\n" +
                "Game 100: 4 red, 2 blue, 4 green; 2 green, 1 red, 1 blue; 3 green, 4 blue, 5 red; 18 red, 2 blue; 9 red, 5 green, 4 blue";

        CubeConundrum cubes = new CubeConundrum(input);
//        cubes.sumGameNumbers();
        cubes.multiplyLowestCubesAmountToPLayEachGame();
    }
}
