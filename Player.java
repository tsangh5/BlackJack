class Player{
    Card[] hand = new Card[11];
    int cardsInHand;
    String name;
    int points=0;
    public Player(String name){
        cardsInHand = 0;
        this.name = name;
    }
    public void recieveCard(Card h){
        hand[cardsInHand] = h;
        cardsInHand += 1;
        points += h.points;
    }
    public String getName(){
        return name;
    }
    public int valueOfHand(){
        return points;
    }
    public void resetGame(){
        
    }
    public Card[] showHand(){
        return hand;
    }
    public int showNumOfCards(){
        return cardsInHand;
    }
}