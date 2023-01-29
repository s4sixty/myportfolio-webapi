package com.finance.portfolio.domain.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stocks")
public class Stock extends TickerBase {
    private String categoryName;
    private String country;
}
