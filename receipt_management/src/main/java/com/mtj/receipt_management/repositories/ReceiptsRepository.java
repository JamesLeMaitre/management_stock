package com.mtj.receipt_management.repositories;

import com.mtj.receipt_management.entities.Receipts;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsRepository extends R2dbcRepository<Receipts,Long> {
}

