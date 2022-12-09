package org.example.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {
    public static void solve() {
        Scanner scanner;

        try {
            scanner = new Scanner(new File("src/main/resources/day3/rucksack-content.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Character> allRucksackDuplicates = new ArrayList<>();

        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();

            int middle = nextLine.length() / 2;
            String firstHalf = nextLine.substring(0, middle);
            String secondHalf = nextLine.substring(middle);

            Set<Character> singleRucksackDuplicates = new HashSet<>();

            for (int i = 0; i < firstHalf.length(); i++) {
                for (int j = 0; j < secondHalf.length(); j++) {
                    if (firstHalf.charAt(i) == secondHalf.charAt(j)) {
                        singleRucksackDuplicates.add(firstHalf.charAt(i));
                        break;
                    }
                }
            }
            allRucksackDuplicates.addAll(singleRucksackDuplicates);
        }
        scanner.close();

        int prioritiesSum = allRucksackDuplicates.stream()
                .map(character -> {
                    if (Character.isUpperCase(character)) {
                        return character - 'A' + 27;
                    }
                    return character - 'a' + 1;
                })
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.printf("The sum of priorities: %d%n", prioritiesSum);
    }
}
