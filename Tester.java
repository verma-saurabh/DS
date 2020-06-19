import java.io.IOException;

class AirPlane {
    public AirPlane() throws IOException {
        System.out.print("AirPlane");
        throw new IOException();
    }
}
class AirJet extends AirPlane {
    public AirJet() throws IOException {
        System.out.println("Airjet");
        try {
            super();
        } catch (IOException e) {
            System.out.print("IOException is thrown in AirJet");
        }
    }
}
public class Tester {
    public static void main(String args[]) {
        try {
            new AirJet();
        } catch (IOException e) {
            System.out.print("IOException is thrown in Tester");
        }
    }
}