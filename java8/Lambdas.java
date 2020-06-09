package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambdas {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
        Stream<String> stream1 = Stream.of("hello", "hola", "hallo", "ciao").sorted();
        Stream<String> stream = list.stream();
        System.out.println(stream);
        stream.forEach((s) -> {
            System.out.println(s);
        });

        stream1.forEach((s) -> {
            System.out.println(s);
        });

    }
}
