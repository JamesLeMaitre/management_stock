package com.mtj.receipt_management.services;

import com.mtj.receipt_management.models.ReceiptDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReceiptsService {

    public Flux<ReceiptDTO> getAll();

    Mono<ReceiptDTO> getById(Long id);

    Mono<ReceiptDTO> saveReceipts(ReceiptDTO receiptDTO);

    Mono<ReceiptDTO> deleteReceipts(Long id);
    
    Mono<ReceiptDTO> updateReceipts(ReceiptDTO receiptDTO,Long id);

}
