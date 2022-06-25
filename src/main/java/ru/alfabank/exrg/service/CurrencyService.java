package ru.alfabank.exrg.service;

import ru.alfabank.exrg.util.Result;

import java.util.Set;

public interface CurrencyService {
    Set<String> getCodes();
    Result getResult(String code);
}
