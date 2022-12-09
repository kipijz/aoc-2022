package org.example.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day4 {
    public static void solve() {
        Scanner scanner;

        try {
            scanner = new Scanner(new File("src/main/resources/day4/assignment-pairs.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int overlapCounter = 0;

        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();

            String[] pairAssignment = nextLine.split(",");
            String[] firstSection = pairAssignment[0].split("-");
            String[] secondSection = pairAssignment[1].split("-");

            List<Integer> fullFirstSection = test(Integer.parseInt(firstSection[0]), Integer.parseInt(firstSection[1]));
            List<Integer> fullSecondSection = test(Integer.parseInt(secondSection[0]), Integer.parseInt(secondSection[1]));

            if (hasOverlap(fullFirstSection, fullSecondSection)) {
                overlapCounter++;
            }
        }
        scanner.close();

        System.out.printf("Total range overlap: %d%n", overlapCounter);
    }

    private static boolean hasOverlap(List<Integer> fullFirstSection, List<Integer> fullSecondSection) {
        return fullFirstSection.containsAll(fullSecondSection)
                || fullSecondSection.containsAll(fullFirstSection);
    }

    private static List<Integer> test(int sectionStart, int sectionEnd) {
        List<Integer> range = new ArrayList<>();
        for (int i = sectionStart; i <= sectionEnd; i++) {
            range.add(i);
        }
        return range;
    }
}

