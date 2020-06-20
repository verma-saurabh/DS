package Array;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

/*
Problem Statement

There are n students in the classroom.
They are asked to stand in a straight line and they randomly arrange themselves in a straight line.
You are allowed to ask the student their names in a sequence from student 1 on to
student n and multiple students can have the same name. Write an algorithm to print
the names and the count of the same name in the same order which they occur as u ask them.
Brute Force solutions will be rejected please attempt with more efficient solutions and provide the
Complexity of your solution using Big O notation.

For Example
n=9
Alok, amit, suresh , amit, vidya, sindhu, vidya, vidya, alok

Output:
Alok -> 2
amit -> 2
suresh -> 1
vidya -> 3
sindhu -> 1
 */
public class OutputSameOrderWithOccurences {
    public static void main(String[] args) {
        String[] input = {"Alok", "amit", "suresh", "amit", "vidya", "sindhu", "vidya", "vidya", "Alok"};
        OutputSameOrderWithOccurences obj = new OutputSameOrderWithOccurences();
        //obj.computeUsingMap(input);
        //obj.computeUsingSet(input);
        obj.computeUsingStream(input);

        String s1 = "abc";
        String s2 = s1;
        s1 += "d";
        System.out.println(s1 + " " + s2 + " " + (s1 == s2));

        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = sb1;
        sb1.append("d");
        System.out.println(sb1 + " " + sb2 + " " + (sb1 == sb2));
        new OutputSameOrderWithOccurences();
        int x = 3 & 5;
        int y = 3 | 5;
        System.out.println(x + " " + y);


        PriorityQueue toDo = new PriorityQueue();
        toDo.add("dishes");
        toDo.add("laundry");
        toDo.add("bills");
        toDo.offer("bills");
        System.out.print(toDo.size() + " " + toDo.poll());
        System.out.print(" " + toDo.peek() + " " + toDo.poll());
        System.out.println(" " + toDo.poll() + " " + toDo.poll());


    }

    public void computeUsingMap(String[] input) {
        // used Linked HashMap so that the insertion order is maintained
        HashMap<String, Integer> map = new LinkedHashMap<>();

        // maintained the count of each occurence while maintaining the insertion order
        for (String name : input) {
            int count = map.getOrDefault(name, 0);
            map.put(name, count + 1);
        }

        //printed the ans
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void computeUsingSet(String[] arr) {
        List<String> list = Arrays.asList(arr);
        Set<String> set = new LinkedHashSet<String>(list);

        for (String name : set) {
            System.out.println(name + " " + Collections.frequency(list, name));
        }

    }

    public void computeUsingStream(String[] arr) {
        Arrays.stream(arr).collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> System.out.println(k + "   -->   " + v.size()));

    }

    class Inner {
        void test() {
            if (OutputSameOrderWithOccurences.this.flag) {
                sample();
            }
        }
    }

    private boolean flag = true;

    public void sample() {
        System.out.println("Sample");
    }

    public OutputSameOrderWithOccurences() {
        (new Inner()).test();
    }
}
