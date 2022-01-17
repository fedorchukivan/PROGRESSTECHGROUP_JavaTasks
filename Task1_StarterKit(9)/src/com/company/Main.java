package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter integer, bigger than 1: ");
            if (scanner.hasNextInt()) {
                int max = scanner.nextInt();
                if (max < 1) {
                    System.out.println("Please, enter integer value bigger than 1!");
                    continue;
                }
                System.out.print("Perfect numbers: ");
                for (int num = 2; num < max; num+=2) {
                    if (isPerfect(num)) printDividersSum(num);
                }
                break;
            }
            else {
                System.out.println("Entered value is not an integer type!");
                scanner.nextLine();
            }
        }
    }

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int divider = 2; divider <= num/2; divider++) {
            if (num % divider == 0) sum += divider;
        }
        return sum == num;
    }

    public static void printDividersSum(int num) {
        System.out.printf("%d=(1", num);
        for (int divider = 2; divider <= num/2; divider++) {
            if (num % divider == 0) System.out.printf("+%d", divider);
        }
        System.out.print("), ");
    }
}
