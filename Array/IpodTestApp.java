package Array;


// Shuffle songs app for ipod

// shuffle songs and not repeat untill all are played

import java.util.List;
import java.util.Random;

class Ipod {

    public static void main(String[] arr) {

        int numberOfSongs = 20;
        Ipod device = new Ipod();
        int[] sequence = device.shuffle(numberOfSongs);

        for (int sequenceNumber : sequence) {
            System.out.println(sequenceNumber);
        }

    }

    public int[] shuffle(int n) {
        int[] sequence = new int[n];

        Random r = new Random(n + 1);

        for (int i = 0; i < n; i++) {
            sequence[i] = r.nextInt();
        }
        return sequence;
    }
}

public class IpodTestApp{

}



