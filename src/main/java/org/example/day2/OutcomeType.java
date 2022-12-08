package org.example.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OutcomeType {
    WIN(6),
    LOSE(0),
    DRAW(3);

    private int value;
}
