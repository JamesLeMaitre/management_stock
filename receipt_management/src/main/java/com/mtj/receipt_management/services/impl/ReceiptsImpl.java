package com.mtj.receipt_management.services.impl;

import com.mtj.receipt_management.entities.Receipts;
import com.mtj.receipt_management.models.ReceiptDTO;
import com.mtj.receipt_management.repositories.ReceiptsRepository;
import com.mtj.receipt_management.services.ReceiptsService;
import com.mtj.receipt_management.utils.JavaUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Slf4j
public class ReceiptsImpl implements ReceiptsService {

    private final ReceiptsRepository receiptsRepository;
    private final JavaUtils utils;

    @Override
    public Flux<ReceiptDTO> getAll() {
//        log.info("Entity : {}",{});
        return receiptsRepository.findAll().map(entity -> utils.entityToDTO(entity, ReceiptDTO.class));
    }

    @Override
    public Mono<ReceiptDTO> getById(Long id) {
        return receiptsRepository.findById(id).flatMap(entity -> Mono.just(utils.entityToDTO(entity, ReceiptDTO.class))).switchIfEmpty(Mono.error(new NoSuchElementException("Receipt not found")));
    }


    @Override
    public Mono<ReceiptDTO> saveReceipts(ReceiptDTO receiptDTO) {
        return receiptsRepository.save(utils.dtoToEntity(receiptDTO, Receipts.class)).map(entity -> utils.entityToDTO(entity, ReceiptDTO.class));
    }

    @Override
    public Mono<ReceiptDTO> deleteReceipts(Long id) {
        return receiptsRepository.deleteById(id).then(Mono.just(new ReceiptDTO()));
    }

    @Override
    public Mono<ReceiptDTO> updateReceipts(ReceiptDTO receiptDTO, Long id) {
        return receiptsRepository.findById(id)
                .flatMap(existingReceipt -> {
                    existingReceipt.setCurrentAmount(receiptDTO.getCurrentAmount());
                    return receiptsRepository.save(existingReceipt).map(updatedReceipt -> utils.entityToDTO(updatedReceipt, ReceiptDTO.class));})
                .switchIfEmpty(Mono.error(new NoSuchElementException("Receipt not found")));
    }


}
