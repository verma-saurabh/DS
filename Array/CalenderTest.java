package Array;

import java.util.TreeMap;

enum Month {
    Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
}

class Date implements Comparable<Date> {

    private final Integer dayNum;
    private final Month month;

    public Date(Integer dayNum, Month month) {
        this.dayNum = dayNum;
        this.month = month;
    }

    @Override
    public int compareTo(Date date) {
        if (month == date.month) return dayNum.compareTo(date.dayNum);
        return month.compareTo(date.month);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (!this.getClass().getName().equals(obj.getClass().getName()))
            return false;

        return equals(obj);
    }

    private boolean equals(Date obj) {
        return obj.month == month && obj.dayNum == dayNum;
    }

}

public class CalenderTest {
    public static void main(String[] args) {
        Date firstJan = new Date(1, Month.Jan);
        Date firstFeb = new Date(1, Month.Feb);

        // this you need to compare dates
        System.out.println("1st Jan greater than 1st feb " + firstJan.compareTo(firstFeb));
        System.out.println("1st feb greater than 1st Jan " + firstFeb.compareTo(firstJan));


        // this you need to sort the dates
        TreeMap<Month, Integer> map = new TreeMap<>();

        map.put(Month.Feb, 1);
        map.put(Month.Jan, 2);

        System.out.println(map);


    }
}
