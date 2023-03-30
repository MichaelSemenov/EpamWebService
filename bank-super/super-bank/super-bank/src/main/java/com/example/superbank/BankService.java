package com.example.superbank;

import com.example.superbank.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@AllArgsConstructor
public class BankService {
    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) {

        BigDecimal balance = repository.getBalanceFold(accountId);
        if(balance == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            return balance;
        }
    }


    public BigDecimal addMoney(Long to, BigDecimal amount) {
            return repository.save(to, amount);
    }

    public void makeTransfer(TransferBalance transferBalance) {
         BigDecimal fromBalance = repository.getBalanceFold(transferBalance.getFrom());
         BigDecimal toBalance = repository.getBalanceFold(transferBalance.getTo());
        if(fromBalance == null || toBalance == null)
            throw new IllegalArgumentException("Один из адресов не доступен или не существует, " +
                    "проверьте введенные данные и повторите попытку позже");
        if(transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("Невозможен перевод" +
                " так как недостаточно суммы на счете!");
        if(transferBalance.getTo() == transferBalance.getFrom()) throw new IllegalArgumentException("Указы одинаковые счета!");
        BigDecimal updatedFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(transferBalance.getAmount());
        repository.safe(transferBalance.getFrom() , updatedFromBalance);
        repository.safe(transferBalance.getTo(), updatedToBalance);
    }

    public Map<Long, BigDecimal> jsonList() {
        return repository.allInformation();
    }
}
