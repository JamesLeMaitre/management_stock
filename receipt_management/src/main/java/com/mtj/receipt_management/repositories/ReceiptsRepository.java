package com.mtj.receipt_management.repositories;

import com.mtj.receipt_management.entities.Receipts;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsRepository extends ReactiveCrudRepository<Receipts,Long> {
}

