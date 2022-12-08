package com.finance.portfolio.repositories;

import com.finance.portfolio.domain.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    @Query(value = "SELECT u from User u LEFT JOIN FETCH u.roles where u.id = :id")
    Optional<User> findByIdWithRoles(@Param("id") Long id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
