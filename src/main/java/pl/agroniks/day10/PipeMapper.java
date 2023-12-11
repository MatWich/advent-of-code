package pl.agroniks.day10;

public class PipeMapper {
    private PipeMapper() {}

    public Character mapToPipe(Character symbol) {
        switch (symbol) {
            case 'J':
                return PipeMazeConstants.UP_LEFT_PIPE;
            case 'L':
                return PipeMazeConstants.UP_RIGHT_PIPE;
            case 'F':
                return PipeMazeConstants.RIGHT_DOWN_PIPE;
            case '7':
                return PipeMazeConstants.LEFT_DOWN_PIPE;
            default:
                return symbol;
        }
    }
}
