package org.example.chocolateBar;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ChocolateElements {
    SOAP("O"),
    CHOCO("#");

    @Getter
    private final String value;
}
