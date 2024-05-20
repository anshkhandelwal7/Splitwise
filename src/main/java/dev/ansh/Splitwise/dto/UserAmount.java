package dev.ansh.Splitwise.dto;

import dev.ansh.Splitwise.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserAmount {
    private User user;

    public UserAmount(User user, double amount) {
        this.amount = amount;
        this.user = user;
    }

    private double amount;
}
