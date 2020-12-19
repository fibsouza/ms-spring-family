package com.devsuperior.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment{
    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double total;

    public Payment(String name, double income, Integer days) {
        this.name = name;
        this.dailyIncome = income;
        this.days = days;
        this.total = getTotal();
    }

    public Double getTotal(){
       total = days * dailyIncome;
       return total;
    }
}
