package lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainDZ {

    private static final int ARRAY_CAPACITY = 10_000;
    private static final int MAX_VALUE = 10_000;

    public static void main(String[] args) {
        ArrayImpl<Integer> arr1 = new ArrayImpl<Integer>(ARRAY_CAPACITY);
        ArrayImpl<Integer> arr2 = new ArrayImpl<Integer>(ARRAY_CAPACITY);
        ArrayImpl<Integer> arr3 = new ArrayImpl<Integer>(ARRAY_CAPACITY);

        Random random = new Random();
        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            arr1.add(value);
            arr2.add(value);
            arr3.add(value);
        }

        long startTime1 = System.nanoTime();
        arr1.sortBubble(true);
        long finishTime1 = System.nanoTime();
        long duration1 = finishTime1 - startTime1;
        System.out.printf("%s took time: %d micros. %n", "SortBubble", TimeUnit.NANOSECONDS.toMicros(duration1));


        long startTime2 = System.nanoTime();
        arr2.sortSelect();
        long finishTime2 = System.nanoTime();
        long duration2 = finishTime2 - startTime2;
        System.out.printf("%s took time: %d micros. %n", "SortSelect", TimeUnit.NANOSECONDS.toMicros(duration2));


        long startTime3 = System.nanoTime();
        arr3.sortInsert();
        long finishTime3 = System.nanoTime();
        long duration3 = finishTime3 - startTime3;
        System.out.printf("%s took time: %d micros. %n", "SortInsert", TimeUnit.NANOSECONDS.toMicros(duration3));
    }

}

