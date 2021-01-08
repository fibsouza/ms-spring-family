package com.devensaio.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.lang.annotation.Documented;

@EntityScan
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private Long id;
    private String name;
    private Double dailyIncome;
}
