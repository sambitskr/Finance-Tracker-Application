package com.example.FinanceTracker.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "INCOME")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "SOURCE", nullable = false)
    private String source;

    @Column(name = "DATE", nullable = false)
    private LocalDate date;  // Changed to lowercase 'date'

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)  // Foreign key column will be created automatically
    private User user;
}
