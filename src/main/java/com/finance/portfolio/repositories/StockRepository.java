package com.finance.portfolio.repositories;

import com.finance.portfolio.domain.dao.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Page<Stock> findAll(Pageable pageable);
    Optional<Stock> findByTicker(String ticker);
}
