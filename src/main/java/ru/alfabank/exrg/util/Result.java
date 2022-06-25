package ru.alfabank.exrg.util;

public enum Result {
    RICH("rich"),
    BROKE("broke"),
    ERROR("ERROR");

    private final String value;
    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
