package com.devsuperior.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {
    private Long id;
    private String name;
    private Double dailyIncome;
}
