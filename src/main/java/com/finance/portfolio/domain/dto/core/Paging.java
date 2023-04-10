package com.finance.portfolio.domain.dto.core;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paging {
    private int page;
    private int size;
    private long total;

}
