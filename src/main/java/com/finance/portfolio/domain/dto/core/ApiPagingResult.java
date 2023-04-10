package com.finance.portfolio.domain.dto.core;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
public class ApiPagingResult<T> extends ApiResult<T> {
    T data;
    Paging paging;
}
