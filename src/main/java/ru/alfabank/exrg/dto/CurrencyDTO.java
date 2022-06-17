package ru.alfabank.exrg.dto;

import lombok.Data;

import java.util.TreeMap;

@Data
public class CurrencyDTO {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private TreeMap<String, Double> rates;
}
