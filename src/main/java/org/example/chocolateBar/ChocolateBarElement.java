package org.example.chocolateBar;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ChocolateBarElement {
    SOAP("O"),
    CHOCO("#"),
    EMPTY("~");

    @Getter
    private final String value;
}
