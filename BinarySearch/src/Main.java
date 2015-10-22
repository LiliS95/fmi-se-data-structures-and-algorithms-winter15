
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dimitar
 */
public class Main {

    public static void main(String[] args) {

        Random rand = new Random(1);
        int numberOfElements = 100;
        int[] numbers = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = rand.nextInt(numberOfElements * 2);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numberOfElements; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println(IterativeBinarySearch.binarySearch(0, numbers));
        System.out.println(IterativeBinarySearch.binarySearch(1, numbers));
        System.out.println(IterativeBinarySearch.binarySearch(5, numbers));
        System.out.println(IterativeBinarySearch.binarySearch(8, numbers));
        System.out.println(IterativeBinarySearch.binarySearch(36, numbers));
        System.out.println(IterativeBinarySearch.binarySearch(192, numbers));

        System.out.println(RecursiveBinarySearch.binarySearch(numbers, 0));
        System.out.println(RecursiveBinarySearch.binarySearch(numbers, 1));
        System.out.println(RecursiveBinarySearch.binarySearch(numbers, 5));
        System.out.println(RecursiveBinarySearch.binarySearch(numbers, 8));
        System.out.println(RecursiveBinarySearch.binarySearch(numbers, 36));
        System.out.println(RecursiveBinarySearch.binarySearch(numbers, 192));
    }
}
