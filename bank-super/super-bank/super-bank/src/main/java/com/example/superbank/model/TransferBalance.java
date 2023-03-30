package com.example.superbank.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TransferBalance {
    private Long to;
    private Long from;
    private BigDecimal amount;


}
