package com.example.superbank;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);
    @Test
    void addMoney() {
        BigDecimal balance = bankService.addMoney(1L, BigDecimal.ZERO);
        assertEquals(balance, BigDecimal.TEN);   //Проверяет ли является результат правливый
    }

    @Test
    void getBalance() {
        final BigDecimal balance = bankService.getBalance(1L);
        assertEquals(balance, BigDecimal.TEN);
    }
}