package Array;

import java.util.Comparator;

enum Rank {
    one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9),
    ten(10), jack(11), queen(12), king(13), ace(14);

    private int value;

    Rank(int value) {
        this.value = value;
    }

}

enum Suit {
    Diamond(4), Spade(3), Heart(2), Culb(1);
    private int value;

    Suit(int value) {
        this.value = value;
    }

}

class Card implements Comparable<Card> {
    Suit suit;
    Rank rank;

    Card(Rank rank) {
        this.rank = rank;
    }

    Card of(Suit suit) {
        this.suit = suit;
        return this;
    }

    @Override
    public int compareTo(Card card) {
        if(this.suit==card.suit){
            return 0;
        }else {
            return 1;
        }
    }
}

public class CardTest {
    public static void main(String[] args) {
        Card card1 = new Card(Rank.six).of(Suit.Culb);
        Card card2 = new Card(Rank.six).of(Suit.Diamond);

        card1.compareTo(card2);

    }
}
