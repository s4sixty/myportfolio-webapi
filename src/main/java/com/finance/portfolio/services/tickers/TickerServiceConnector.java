package com.finance.portfolio.services.tickers;

import com.finance.portfolio.domain.dto.ticker.TickerHistory;
import com.finance.portfolio.domain.dto.ticker.TickerHistoryResponse;
import com.finance.portfolio.domain.dto.ticker.TickerInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "tickerService", url = "${ticker-service-api.url}")
public interface TickerServiceConnector {

    @GetMapping(value = "tickers/{ticker_id}/info")
    TickerInfoResponse getTickerInfo(@PathVariable("ticker_id") String ticker);

    @GetMapping(value = "tickers/{ticker_id}/history")
    TickerHistoryResponse getTickerHistory(@PathVariable("ticker_id") String ticker, @RequestParam String period, @RequestParam String interval);
}
