package com.example.FinanceTracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOTAL_BALANCE", nullable = false)
    private BigDecimal totalBalance = BigDecimal.ZERO;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}


//{
//        "id": 1,
//        "name": "sambit sarkar",
//        "total": "14000",
//        "email": "sambit@gmail.com",
//        "password": "qwerty"
//        },
