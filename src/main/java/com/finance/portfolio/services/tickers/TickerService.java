package com.finance.portfolio.services.tickers;

import com.finance.portfolio.domain.dao.Stock;
import com.finance.portfolio.domain.dto.ticker.TickerHistoryResponse;
import com.finance.portfolio.domain.dto.ticker.TickerInfoResponse;
import com.finance.portfolio.domain.exceptions.BusinessCoreException;
import com.finance.portfolio.domain.exceptions.ItemNotFoundException;
import com.finance.portfolio.domain.exceptions.SanityCheckException;
import com.finance.portfolio.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TickerService {

    private final TickerServiceConnector tickerServiceConnector;
    private final StockRepository stockRepository;

    public TickerInfoResponse getTickerInfo(String tickerId) throws BusinessCoreException {
        var stock = GetStockIfExists(tickerId.toUpperCase());
        var response = tickerServiceConnector.getTickerInfo(stock.getTicker());
        return response;
    }

    public TickerHistoryResponse getTickerHistory(String tickerId, String period, String interval) throws BusinessCoreException {
        var stock = GetStockIfExists(tickerId.toUpperCase());
        var response = tickerServiceConnector.getTickerHistory(stock.getTicker(), period, interval);
        return response;
    }

    private Stock GetStockIfExists(String stockTicker) throws BusinessCoreException {
        var stock = stockRepository.findByTicker(stockTicker).orElseThrow(() ->
                new SanityCheckException(String.format("Stock ticker %s not found", stockTicker)));
        return stock;
    }
}
