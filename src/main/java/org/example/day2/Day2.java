package org.example.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.example.day2.OutcomeType.*;
import static org.example.day2.SelectionType.*;

public class Day2 {
    public static void solve() {
        Scanner scanner;

        try {
            scanner = new Scanner(new File("src/main/resources/day2/strategy-guide.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int score = 0;

        while (scanner.hasNext()) {
            String[] selections = scanner.nextLine().split(" ");
            score += getRoundScore(selections);
        }
        scanner.close();

        System.out.printf("My total score: %d%n", score);
    }

    private static int getRoundScore(String[] selections) {
        SelectionType opponentsSelection = fromSelection(selections[0]);
        SelectionType mySelection = fromSelection(selections[1]);

        int roundScore = mySelection.getValue();

        if (opponentsSelection.equals(mySelection)) {
            return roundScore + DRAW.getValue();
        }

        if (hasOpponentLost(opponentsSelection, mySelection)) {
            return roundScore + WIN.getValue();
        }

        return roundScore + LOSE.getValue();
    }

    private static boolean hasOpponentLost(SelectionType opponentsSelection, SelectionType mySelection) {
        return (opponentsSelection.equals(ROCK) && mySelection.equals(PAPER))
                || (opponentsSelection.equals(PAPER) && mySelection.equals(SCISSORS)
                || (opponentsSelection.equals(SCISSORS) && mySelection.equals(ROCK)));
    }
}
