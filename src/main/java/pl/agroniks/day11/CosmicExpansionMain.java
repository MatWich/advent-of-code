package pl.agroniks.day11;

public class CosmicExpansionMain {
    public static void main(String[] args) {

        String input0 = ".........#................................#................#.................#..........................#...........................#.......\n" +
                ".#............#...................................................................................#.........................................\n" +
                "...................................................................................................................#...........#............\n" +
                ".........................#......................................#........#..................................................................\n" +
                "...................#.....................................................................................................#..................\n" +
                ".......................................#..................................................#.......................................#.........\n" +
                ".............#..................#.....................................#............................#.....#.......#........................#.\n" +
                "...........................................#................................................................................................\n" +
                "#...................................#............................................#....................................#.....................\n" +
                "............................................................................................#...............................................\n" +
                ".............................................................................#.........#....................................................\n" +
                "....#....................#...............#.........#...............#....................................................................#...\n" +
                "..................#.........................................................................................................................\n" +
                ".........................................................#................................#......................#.............#............\n" +
                "...................................................................................#...................#....................................\n" +
                ".....................#...............#........#............................#................................................................\n" +
                "..#.....#......#................#......................................................#....................................................\n" +
                ".........................#......................................#............................................#..........#..............#....\n" +
                "..........................................................#.................................................................................\n" +
                "............................................................................................................................................\n" +
                "...................................#.................................#........#............#.......................#........................\n" +
                ".............#.............................#.........................................................#......................................\n" +
                "..................................................#............................................................................#.....#......\n" +
                ".........................#.....................................................................................#............................\n" +
                ".......#......................................#....................................#.........#..........#...................................\n" +
                "....................#.....................................#..............#..................................................................\n" +
                ".............................#......#.......................................................................................................\n" +
                "............................................................................................................................#.....#.........\n" +
                "...........#................................#...............................................................................................\n" +
                "....#............................#................................................................#..........#..............................\n" +
                "..................................................................................................................#.......................#.\n" +
                "................#........#..............#...................#..........................................#....................................\n" +
                "...................................................#........................#...................................................#...........\n" +
                ".........#....................................#..............................................#........................................#.....\n" +
                "..#...........................................................................................................#.............................\n" +
                "...................................................................................................#....................#...................\n" +
                "...........................................#.....................#.......................#.........................................#........\n" +
                "...................#.........#..............................#............#.....#............................................................\n" +
                "..............#..................................#...................................................................#......................\n" +
                "........................#...................................................................................................................\n" +
                ".......................................#...................................................#.....#.....#.................#..................\n" +
                "................................#............#......#...........................................................#...............#...........\n" +
                "........#.........#..................................................#..................................................................#...\n" +
                "..........................#.................................................................................#...............................\n" +
                "..........................................#.....................#........#........#.........................................#...............\n" +
                ".........................................................#....................................#.............................................\n" +
                "....................................#..........#............................................................................................\n" +
                "..#......#..................#...............................................#...........#................#........#.........................\n" +
                "......................................................................#.....................................................................\n" +
                "............................................................................................................................................\n" +
                "..........................................................#.................................#...........................#.............#.....\n" +
                "............................................................................................................................................\n" +
                "......................#.............................................................#............#..........#...............................\n" +
                "#..........#................................................................................................................................\n" +
                ".................#.................#................................#.........................................................#.............\n" +
                "............................................................................................................................................\n" +
                "..........................#.............#...................................#................#.......................#......................\n" +
                "............................................................................................................................................\n" +
                "........................................................#..................................................................................#\n" +
                "..........#.....................#............#...............#...................#..........................................................\n" +
                "#...................#..................................................................................#....................................\n" +
                "............................................................................................................................................\n" +
                ".........................................#.........................#......#......................#....................#.....................\n" +
                "..........................#.................................................................#...................#.................#.........\n" +
                "..................................................#.........................................................................#...............\n" +
                "............................................................................................................................................\n" +
                ".....#......................................................................#........................#..................#...................\n" +
                "................................................................#.....#...................................#.................................\n" +
                "..........#.......................#.....................#......................................................................#......#.....\n" +
                "................#................................#..............................................#...........................................\n" +
                "#.....................#......#.................................................#............................................................\n" +
                "............................................................................................................................................\n" +
                "..............................................................#.......................................................#.................#...\n" +
                "......#.............................#......#.......#...............#.......................#.............#.................#.....#..........\n" +
                "....................#....................................#..................................................................................\n" +
                "...............................#................................................................................#...........................\n" +
                "..........................#.......................................................................#.........................................\n" +
                ".#............................................#..........................#..................................................................\n" +
                "........#.....#...............................................#..........................#............#......#........................#.....\n" +
                "............................................................................................................................................\n" +
                "........................................................#.................................................................#.................\n" +
                "............................................................................................................................................\n" +
                "............#................#.........#.................................................................#.......#................#........#\n" +
                ".................................................#..........................#..............#...........................#....................\n" +
                "...#.............#.......#.................#................................................................................................\n" +
                "............................................................................................................................................\n" +
                ".....................................#....................#.............#.......................#...........................................\n" +
                ".....................#.............................#....................................................#...................................\n" +
                "............#..................................................................................................#............................\n" +
                ".............................................................................#.....#........................................#...............\n" +
                "..................#...........................................#............................................................................#\n" +
                "...............................#........#.............................#.....................................................................\n" +
                ".........#...............#................................#.................................................................................\n" +
                "...#...............................#...................................................................#....................................\n" +
                "...........................................................................#...........#....................................................\n" +
                "................................................................................#...........................................................\n" +
                ".............................#.................#...................#............................................................#..........#\n" +
                "............#...............................................................................#...............................................\n" +
                ".....................#..................#.....................#....................#...............................#......#.................\n" +
                "................#.......................................................................#.........#.........................................\n" +
                "..........................................................................#................................#................................\n" +
                "................................................#................#...............................................................#..........\n" +
                ".........................#......#..............................................#.................................#..........................\n" +
                "..................#..................#...............................#.....................#.........................................#......\n" +
                "............#......................................................................#..................#.....................................\n" +
                ".....#......................................................................................................#...............................\n" +
                "......................#.....#...............#......#..........................................#...........................#...............#.\n" +
                "............................................................#..........................#....................................................\n" +
                "......................................#.........................................................................#...........................\n" +
                "......................................................................#................................................#......#.............\n" +
                "....................#..........................................#...................#.......#................................................\n" +
                "#.........................................#.................................#............................................................#..\n" +
                "...................................................#...................................................#...................#................\n" +
                "............................................................#......#.................................................#......................\n" +
                ".....#.........................#.............................................................#..................#...........................\n" +
                ".........................................................................#........................................................#.........\n" +
                "............................................................................................................................................\n" +
                ".....................................#......................................................................................................\n" +
                "........................#..................................#...............................#................#.......#......#................\n" +
                ".............................#....................#....................................................#...................................#\n" +
                "..................#..........................#.....................................................................................#........\n" +
                "...............................................................#...........#..................#.............................................\n" +
                ".................................#.................................................................#........................................\n" +
                ".......................................................................................#....................................................\n" +
                "..#................................................#........#...............................................................................\n" +
                "...........#...............................#......................................#.............................#.......#...........#.......\n" +
                "........................#...................................................................................................................\n" +
                "......#................................#....................................#..................#.....#......................................\n" +
                "..................#.....................................#..........#........................................................#...............\n" +
                ".............................#.............................................................................................................#\n" +
                "............#.....................................................................................................................#.........\n" +
                "..............................................#.........................#.................#.................................................\n" +
                ".....#.......................................................#..............................................................................\n" +
                ".....................................#...................................................................#..............#...................\n" +
                "...................................................................................................................#........................\n" +
                "...................#......#.....#........#.........................#...............#........................................................\n" +
                ".....................................................................................................................................#......\n" +
                "...........#.......................................#............................................................#..........#................\n" +
                "......................#.................................#..............#.....#...................#.......................................#..\n" +
                "............................#........#...........................#..........................#...............................................";

        String input =
                "...#......\n" +
                ".......#..\n" +
                "#.........\n" +
                "..........\n" +
                "......#...\n" +
                ".#........\n" +
                ".........#\n" +
                "..........\n" +
                ".......#..\n" +
                "#...#.....";

        CosmicExpansion cosmicExpansion = new CosmicExpansion(input0);
    }
}
