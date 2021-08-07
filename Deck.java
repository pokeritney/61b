public class Deck {
    public static int[] cards;
    public Deck() {
        cards = new int[]{1, 3, 4, 10};
    }

    public static void main(String[] args) {
        Deck dingie = new Deck();
        dingie.cards[3] = 3; //[1, 3, 4, 3]

        Deck pilates = new Deck();
        pilates.cards[1] = 2; //[1, 2, 4, 10]

        int[] newArrWhoDis = {2, 2, 4, 1, 3};
        dingie.cards = pilates.cards; //[1, 2, 4, 10]
        pilates.cards = newArrWhoDis; //[2, 2, 4, 1, 3]
        newArrWhoDis = null;
    }
}