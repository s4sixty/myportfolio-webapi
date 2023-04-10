package com.finance.portfolio.domain.dao;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name="mutual_funds")
public class MutualFunds extends TickerBase {
}
