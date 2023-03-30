package com.example.superbank;

import lombok.val;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    //private final Map<Long, BigDecimal> storage = new HashMap<Long, BigDecimal>();
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TEN));
    public BigDecimal getBalanceFold(Long accountId)
    {
        return storage.get(accountId);
    }

    public BigDecimal save(Long to, BigDecimal amount) {
        val currentBalance = storage.get(to);     //val - для того, чтобы нельзя было изменить данную переменную

        if(currentBalance == null)
        {
            storage.put(to, amount);
            return amount;
        }
        else
        {
            //currentBalance += amount;
            storage.put(to, currentBalance.add(amount));    //plus - возвращает новый объъек, а не зменяет исходный
            return storage.get(to);
        }
    }

    public void safe( Long id, BigDecimal updatedToBalance) {
        storage.put(id, updatedToBalance);
    }

    public Map<Long, BigDecimal> allInformation() {
        return storage;
    }
}
