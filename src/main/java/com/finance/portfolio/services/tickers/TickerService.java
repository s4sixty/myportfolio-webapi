package com.finance.portfolio.services.tickers;

import com.finance.portfolio.domain.dao.Stock;
import com.finance.portfolio.domain.dto.ticker.TickerHistoryResponse;
import com.finance.portfolio.domain.dto.ticker.TickerInfoResponse;
import com.finance.portfolio.domain.exceptions.BusinessCoreException;
import com.finance.portfolio.domain.exceptions.SanityCheckException;
import com.finance.portfolio.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TickerService {

    private final TickerServiceConnector tickerServiceConnector;
    private final StockRepository stockRepository;

    public Page<Stock> getStocks(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return stockRepository.findAll(pageRequest);
    }

    public TickerInfoResponse getTickerInfo(String tickerId) throws BusinessCoreException {
        var stock = getStockIfExists(tickerId.toUpperCase());
        return tickerServiceConnector.getTickerInfo(stock.getTicker());
    }

    public TickerHistoryResponse getTickerHistory(String tickerId, String period, String interval) throws BusinessCoreException {
        var stock = getStockIfExists(tickerId.toUpperCase());
        return tickerServiceConnector.getTickerHistory(stock.getTicker(), period, interval);
    }

    private Stock getStockIfExists(String stockTicker) throws BusinessCoreException {
        return stockRepository.findByTicker(stockTicker).orElseThrow(() ->
                new SanityCheckException(String.format("Stock ticker %s not found", stockTicker)));
    }
}
