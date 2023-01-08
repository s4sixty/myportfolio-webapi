package com.finance.portfolio.controllers;

import com.finance.portfolio.services.tickers.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1/tickers")
@RequiredArgsConstructor
public class TickersController {

    private final TickerService tickerService;

    @GetMapping("{tickerId}/info")
    public ResponseEntity getTickerInfo(@PathVariable(value="tickerId") String tickerId) {
        return tickerService.getTickerInfo(tickerId);
    }

    @GetMapping("{tickerId}/history")
    public ResponseEntity getTickerHistory(@PathVariable(value="tickerId") String tickerId, @RequestParam String period, @RequestParam String interval) {
        return tickerService.getTickerHistory(tickerId, period, interval);
    }
}
