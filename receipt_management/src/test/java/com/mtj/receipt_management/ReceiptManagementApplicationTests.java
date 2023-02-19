package com.mtj.receipt_management;

import com.mtj.receipt_management.entities.Receipts;
import com.mtj.receipt_management.models.ReceiptDTO;
import com.mtj.receipt_management.services.ReceiptsService;
import com.mtj.receipt_management.utils.enums.InputType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@SpringBootTest
@Slf4j
class ReceiptManagementApplicationTests {

    @Autowired
    private ReceiptsService  receiptsService;
    @Test
    void contextLoads() {

        ReceiptDTO receiptDTO = ReceiptDTO.builder()
                .currentAmount(2500.0)
                .description("Vente de A")
                .inputType(InputType.ENTRY)
                .dateCreate(new Date())
                .dateUpdate(new Date())
                .build();
        Mono<ReceiptDTO> receiptMono = receiptsService.saveReceipts(receiptDTO);

        Flux<ReceiptDTO> getAll = receiptsService.getAll();

        getAll.subscribe(r->{log.info("Receipt data : {}", r.getCurrentAmount());});

//        receiptMono.subscribe(receipt -> log.info("Receipt data : {}", receipt));
//        receiptMono.subscribe(System.out::println);

    }

}
