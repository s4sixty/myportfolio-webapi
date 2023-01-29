package com.finance.portfolio.domain.dto.ticker;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TickerInfoResponse {
    private String currency;
    private String exchange;
    private String timezone;
    private float shares;
    private float market_cap;
    private float last_price;
    private float previous_close;
    private float open;
    private float day_high;
    private float day_low;
    private float regular_market_previous_close;
    private float last_volume;
    private float fifty_day_average;
    private float two_hundred_day_average;
    private float ten_day_average_volume;
    private float three_month_average_volume;
    private float year_high;
    private float year_low;
    private float year_change;
}
