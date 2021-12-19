class Card{
    String rank;
    String suit;
    int points;
    boolean ace;
    public Card(String rank, String suit, int points, boolean ace){
        this.rank = rank;
        this.suit = suit;
        this.points = points;
        this.ace = ace;
    }
    public String getName(){
        return rank;
    }
    public int getPoints(){
        return points;
    }
    public boolean getAce(){
        return ace;
    }
}