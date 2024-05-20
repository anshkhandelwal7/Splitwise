package dev.ansh.Splitwise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;

    public UserExpense() {
    }

    public UserExpense(User user, double amount, UserExpenseType userExpenseType) {
        this.user = user;
        this.amount = amount;
        this.userExpenseType = userExpenseType;
    }
}
