import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Initialise
        System.out.println("Welcome to Blackjack");
        Scanner k = new Scanner(System.in);
        System.out.println("How many people are playing?");
        int numberOfPlayers = k.nextInt();
        Player[] players = new Player[numberOfPlayers+1];
        k.nextLine();
        for (int n=0;n<numberOfPlayers;n++){
            System.out.println("Enter player name:");
            String player = k.nextLine();
            players[n] = new Player(player);
        }

        // Start a game
        Deck deckOfCards = new Deck();
        deckOfCards.shuffle();
        int count = 0;
        for (int i = 0; i <= 1; i++){
            for(int x=0; x<numberOfPlayers; x++){
                Card tmp = deckOfCards.deal();
                System.out.println(tmp.points);
                players[x].recieveCard(tmp);
            }
        }

        // Continue game until it's over
        int y = 0; // Player whose turn it is
        boolean gameOver = false;
        while (gameOver == false){
            int u = numberOfPlayers-1;
            if (y > u){
                y -= numberOfPlayers;
            }
            System.out.println(y);
            int cardsInHand = players[y].showNumOfCards();
            Card[] hand = players[y].showHand();
            System.out.println("Hello " + players[y].name + ", you have " + players[y].valueOfHand() + " points");
            System.out.println("Your cards are ...");
            for (int i = 0; i < cardsInHand; i++){
                if (hand[i] != null){
                    System.out.println(hand[i].getName());
                }
            }
            System.out.println("Do you want to HIT or STAND");
            String action = k.nextLine();
            if (action.equals("HIT")){
                players[y].recieveCard(deckOfCards.deal());
                int value = players[y].valueOfHand();
                if (value== 21){
                    System.out.println("WINNER!");
                    gameOver = true;
                }
                else if (value > 21){
                    System.out.println("BUST!");
                    gameOver = true;
                }
            }
            y = y + 1;
        }
        System.out.println("Thanks for playing!");
    }

}
