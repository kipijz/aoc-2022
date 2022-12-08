package org.example.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void solve() {
        Scanner scanner;

        try {
            scanner = new Scanner(new File("src/main/resources/day1/calories.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> carriedCalories = new ArrayList<>();
        int calories = 0;

        while (scanner.hasNext()){
            String nextLine = scanner.nextLine();

            if (nextLine.equals("")) {
                carriedCalories.add(calories);
                calories = 0;
            } else {
                calories += Integer.parseInt(nextLine);
            }
        }
        scanner.close();

        Integer mostCalories = Collections.max(carriedCalories);
        System.out.printf("Most calories carried by elf: %d%n", mostCalories);
    }
}
