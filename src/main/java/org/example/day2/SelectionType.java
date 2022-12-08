package org.example.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum SelectionType {
    ROCK(List.of("A", "X"), 1),
    PAPER(List.of("B", "Y"), 2),
    SCISSORS(List.of("C", "Z"), 3);

    private List<String> abbreviations;
    private int value;

    public static SelectionType fromSelection(String selection) {
        for (SelectionType type : values()) {
            if (type.abbreviations.contains(selection)) {
                return type;
            }
        }
        return null;
    }
}
