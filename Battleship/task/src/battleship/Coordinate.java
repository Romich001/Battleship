package battleship;

public class Coordinate {
    private final int X;
    private final int Y;

    public Coordinate(int y, int x) {
        Y = y;
        X = x;
    }

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public static Coordinate getCoordinate(String input) {
        int x = Integer.parseInt(input.substring(1)) - 1;
        int y = input.charAt(0) - 65;
        return new Coordinate(y, x);
    }

}
