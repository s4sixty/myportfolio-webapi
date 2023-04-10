package com.finance.portfolio.controllers;

import com.finance.portfolio.config.annotations.RestControllerWrapper;
import com.finance.portfolio.domain.dto.ticker.TickerHistoryResponse;
import com.finance.portfolio.domain.dto.ticker.TickerInfoResponse;
import com.finance.portfolio.domain.exceptions.BusinessCoreException;
import com.finance.portfolio.services.tickers.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerWrapper
@RequestMapping("api/v1/tickers")
@RequiredArgsConstructor
public class TickersController {

    private final TickerService tickerService;

    @GetMapping("{tickerId}/info")
    public ResponseEntity<TickerInfoResponse> getTickerInfo(@PathVariable(value="tickerId") String tickerId) throws BusinessCoreException {
        var response = tickerService.getTickerInfo(tickerId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{tickerId}/history")
    public ResponseEntity<TickerHistoryResponse> getTickerHistory(@PathVariable(value="tickerId") String tickerId,
                                                                  @RequestParam String period,
                                                                  @RequestParam String interval) throws BusinessCoreException {
        var response = tickerService.getTickerHistory(tickerId, period, interval);
        return ResponseEntity.ok().body(response);
    }
}
