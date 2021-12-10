package battleship;

public enum Fleet {

    CARRIER(5, "Aircraft Carrier"),
    BATTLESHIP(4, "Battleship"),
    SUBMARINE(3, "Submarine"),
    CRUISER(3, "Cruiser"),
    DESTROYER (2, "Destroyer");

    private final int decksNum;
    private final String type;

    Fleet(int decksNum, String type) {
        this.decksNum = decksNum;
        this.type = type;
    }

    public int getDecksNum() {
        return decksNum;
    }

    public String getType() {
        return type;
    }
}
