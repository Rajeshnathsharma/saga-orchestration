package com.vinsguru.controller;

import com.vinsguru.dto.StockPrice;
import com.vinsguru.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public List<StockPrice> getStockPrices(){
        return this.stockService.getStocks();
    }

}
