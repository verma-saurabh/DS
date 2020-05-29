package Array;

enum Rank {
    one(1), two(2),three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9),
    ten(10), jack(11), queen(12), king(13), ace(14);

    private int value;
    Rank(int value){
        this.value=value;
    }

}

enum Suit {
    Diamond(4), Spade(3), Heart(2), Culb(1);
    private int value;

    Suit(int value) {
        this.value = value;
    }

}

 class Card {
    Suit suit;
    Rank rank;
}

public class CardTest{

}
