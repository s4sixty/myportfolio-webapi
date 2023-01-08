package com.finance.portfolio.services.tickers;

import com.finance.portfolio.domain.dto.ticker.TickerHistoryResponse;
import com.finance.portfolio.domain.dto.ticker.TickerInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TickerService {
    @Autowired
    private TickerServiceConnector tickerServiceConnector;

    public ResponseEntity<TickerInfoResponse> getTickerInfo(String tickerId) {
        var response = tickerServiceConnector.getTickerInfo(tickerId);
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<TickerHistoryResponse> getTickerHistory(String tickerId, String period, String interval) {
        var response = tickerServiceConnector.getTickerHistory(tickerId, period, interval);
        return ResponseEntity.ok().body(response);
    }
}
