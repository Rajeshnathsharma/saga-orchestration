package com.vinsguru.service;

import com.vinsguru.dto.StockPrice;

import java.util.List;

public interface StockService {
    List<StockPrice> getStocks();
}
