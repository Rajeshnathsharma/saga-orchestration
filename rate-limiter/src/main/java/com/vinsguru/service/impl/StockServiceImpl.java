package com.vinsguru.service.impl;

import com.vinsguru.dto.StockPrice;
import com.vinsguru.service.StockService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    private List<String> stocks;
    private List<StockPrice> stockPrices;

    @PostConstruct
    private void init(){
        this.stocks = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        this.stockPrices = Collections.emptyList();
    }

    @Override
    @RateLimiter(name="stockService", fallbackMethod = "getFallbackStocks")
    public List<StockPrice> getStocks() {
        this.stockPrices = this.stocks.stream()
                                .map(stock -> new StockPrice(stock, ThreadLocalRandom.current().nextInt(1, 100)))
                                .collect(Collectors.toList());
        //IO intensive call
        this.sleep(3000);
        return this.stockPrices;
    }

    public List<StockPrice> getFallbackStocks(Exception e) {
        return this.stockPrices;
    }

    private void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
