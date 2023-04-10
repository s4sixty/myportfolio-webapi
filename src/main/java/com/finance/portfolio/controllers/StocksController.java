package com.finance.portfolio.controllers;

import com.finance.portfolio.config.annotations.RestControllerWrapper;
import com.finance.portfolio.domain.dao.Stock;
import com.finance.portfolio.domain.dto.core.ApiPagingResult;
import com.finance.portfolio.domain.dto.core.ApiResultCodes;
import com.finance.portfolio.domain.dto.core.Paging;
import com.finance.portfolio.services.tickers.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RestControllerWrapper
@RequestMapping("api/v1/tickers")
@RequiredArgsConstructor
public class StocksController {

    private final TickerService tickerService;

    @GetMapping("stocks")
    public ApiPagingResult<List<Stock>> getStocks(@RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "100") Integer size) {
        var response = tickerService.getStocks(page, size);
        return ApiPagingResult.<List<Stock>>builder()
                .paging(Paging.builder()
                        .total(response.getTotalElements())
                        .size(response.getNumberOfElements())
                        .page(response.getPageable().getPageNumber())
                        .build())
                .data(response.getContent())
                .resultCode(ApiResultCodes.SUCCESS.toString())
                .build();
    }
}
