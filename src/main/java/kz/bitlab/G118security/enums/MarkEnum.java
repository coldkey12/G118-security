package kz.bitlab.G118security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MarkEnum {
    GREAT("G"),
    NOT_BAD("NB"),
    BAD("B");

    @Getter
    private String key;
}
