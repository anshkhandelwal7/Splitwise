package dev.ansh.Splitwise.mapper;

import dev.ansh.Splitwise.dto.GroupResponseDTO;
import dev.ansh.Splitwise.dto.UserFriendResponseDTO;
import dev.ansh.Splitwise.dto.UserLoginResponseDTO;
import dev.ansh.Splitwise.entity.Group;
import dev.ansh.Splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class EntityDTOMapper {
    public static UserLoginResponseDTO toDTO(User user) {
        UserLoginResponseDTO responseDTO = new UserLoginResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());

        //conversion of user friends to friendList
        List<UserFriendResponseDTO> friendList = new ArrayList<>();
        if (user.getFriends() != null) {
            for (User friend : user.getFriends()) {
                friendList.add(toFriendDTO(friend));
            }
            responseDTO.setFriendList(friendList);
        }
        if(user.getGroups() != null) {
            //conversion of group to groupResponseDTO
            List<GroupResponseDTO> groups = new ArrayList<>();
            for (Group group : user.getGroups()) {
                groups.add(toDTO(group));
            }
            responseDTO.setGroups(groups);

        }
        return responseDTO;
    }
    public static UserFriendResponseDTO toFriendDTO(User user){
        UserFriendResponseDTO responseDTO = new UserFriendResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        return responseDTO;
    }

    public static GroupResponseDTO toDTO(Group group){
        return null;
    }

    }
