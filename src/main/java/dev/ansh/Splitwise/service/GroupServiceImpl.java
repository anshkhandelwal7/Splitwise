package dev.ansh.Splitwise.service;

import dev.ansh.Splitwise.entity.SettlementTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{
    @Override
    public List<SettlementTransaction> settleUp(int groupId) {
        return List.of();
    }
}
