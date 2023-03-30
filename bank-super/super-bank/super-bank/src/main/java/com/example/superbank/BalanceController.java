package com.example.superbank;

import com.example.superbank.model.TransferBalance;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j                          //Логирование
@RestController("/balance")
@AllArgsConstructor             //На этапе компиляции создает конструктор без явного его написания
public class BalanceController {
//@Autowired - неуместное использование!   Автоматическая иньекция зависимостей! Автоматически внедрит его в класс

    private final BankService bankService;

    /*public BalanceController(BankService bankService) {    не используется так использована аанотация от lambok
        this.bankService = bankService;
    }*/
    @GetMapping("list")
    public Map<Long, BigDecimal> allList()
    {
        return bankService.jsonList();
    }
    @GetMapping("/{accountId}")                          //localhost:8080/{accountId} // localhost:8080/1
    public BigDecimal getBalance(@PathVariable Long accountId)
    {
            return bankService.getBalance(accountId);
    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance)
    {
            return bankService.addMoney(transferBalance.getTo() , transferBalance.getAmount());
    }
    @PostMapping("/transfer")
    public void transfer (@RequestBody TransferBalance transferBalance )
    {
            bankService.makeTransfer(transferBalance);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException ex)
    {
        log.error(ex.getMessage());
        return "В данном сервесе возникла ошибка!";
    }
}
