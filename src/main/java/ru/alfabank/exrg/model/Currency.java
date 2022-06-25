package ru.alfabank.exrg.model;

import lombok.Data;

import java.util.TreeMap;

@Data
public class Currency {
    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private TreeMap<String, Double> rates;
}
