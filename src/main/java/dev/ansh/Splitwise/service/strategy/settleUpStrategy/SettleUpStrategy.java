package dev.ansh.Splitwise.service.strategy.settleUpStrategy;

import dev.ansh.Splitwise.entity.Expense;
import dev.ansh.Splitwise.entity.SettlementTransaction;

import java.util.List;

public interface SettleUpStrategy {
    List<SettlementTransaction> getSettlementTransactions(List<Expense> expenses);
}
