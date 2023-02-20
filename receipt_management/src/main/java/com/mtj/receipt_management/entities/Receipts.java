package com.mtj.receipt_management.entities;

import com.mtj.receipt_management.utils.enums.InputType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "receipts")
public class Receipts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private double currentAmount;

    @Column
    private String description;
    @Column
    private InputType inputType;

    @CreationTimestamp
    @Column
    private Date dateCreate;
    @UpdateTimestamp
    @Column
    private Date dateUpdate;


}
