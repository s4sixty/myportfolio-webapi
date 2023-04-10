package com.finance.portfolio.domain.dao;

import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "etfunds")
public class Etfund extends TickerBase {
}
