import java.util.Random;
class Deck{
    Card[] cards = new Card[52];
    int cardsDealt = 0;
    private String[] cardNumbers = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] suites = {"Diamonds", "Clubs", "Hearts", "Spades"};
    public Deck(){
        int count = 0;
        for (int number=0; number < 13; number++){
            for (int suite=0; suite < 4; suite++){
                String name = cardNumbers[number] + " of " + suites[suite];
                if (number == 0){
                    cards[count] = new Card(name, suites[suite], number+1, true);
                }
                else if((number ==9)||(number == 10) || (number == 11) || (number == 12)){
                    cards[count] = new Card(name, suites[suite], 10, false);
                }
                else{
                    cards[count] = new Card(name, suites[suite], number+1, false);
                }
                count += 1;
            }
        }
    }
    public void shuffle(){
        Card temp;
        int index;
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--){
            index = random.nextInt(i + 1);
            temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }
    public Card deal(){
        Card card = cards[cardsDealt];
        cardsDealt++;
        return card;
    } 
}