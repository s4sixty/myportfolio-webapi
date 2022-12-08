package com.finance.portfolio.domain.dto.core;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private List<String> details;
    private String stackTrace;
}
