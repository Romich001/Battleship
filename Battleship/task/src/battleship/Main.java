package battleship;

public class Main {

    public static void main(String[] args) {

        Field player1 = new Field("Player1");
        Field player2 = new Field("Player2");
        String winner;
        Game game = new Game();
        game.prepareField(player1);
        game.prepareField(player2);
        Field shooting = player1;
        Field shot = player2;
        while(true) {
             game.move(shooting, shot);
            //System.out.println(shot.getName() + " " + shot.getShipNum());
             if(player1.getShipNum() == 0 || player2.getShipNum() == 0) break;
             game.passTurn();
             Field temp = shooting;
             shooting = shot;
             shot = temp;
        }
        game.closeScanner();
        System.out.println("\nYou sank the last ship. You won. Congratulations!");

    }



}
