package com.finance.portfolio.domain.dto.ticker;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TickerHistoryResponse {
    private List<TickerHistory> history;
}
