package com.finance.portfolio.domain.dto.ticker;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TickerInfoResponse {
    private float RegularMarketPrice;
    private float PreMarketPrice;
    private String LogoUrl;
    private float TrailingPegRatio;
    private float ClosePrice;
    private float MoveRatio;
}
