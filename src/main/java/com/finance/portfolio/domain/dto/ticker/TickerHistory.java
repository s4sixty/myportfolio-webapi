package com.finance.portfolio.domain.dto.ticker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TickerHistory {
    @JsonProperty("Date")
    private Timestamp date;
    @JsonProperty("Datetime")
    private Timestamp dateTime;
    @JsonProperty("Open")
    private float open;
    @JsonProperty("High")
    private float high;
    @JsonProperty("Low")
    private float low;
    @JsonProperty("Close")
    private float Close;
    @JsonProperty("Volume")
    private long volume;
    @JsonProperty("Devidends")
    private float dividends;
    @JsonProperty("Stock Splits")
    private float stockSplits;
}
