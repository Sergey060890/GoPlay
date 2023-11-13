package project.service.dto.mapper;

import project.models.User;
import project.service.dto.UserDTO;

/**
 * UserMapper
 */
public class UserMapper {
    public static UserDTO mapFrom(User user) {
        return new UserDTO(user.getUser_id(),
                user.getUser_name(), user.getUser_surname(), user.getUser_nickname(),
                user.getSex(), user.getCountry(), user.getCity(), user.getAge(),
                user.getAbout_me(), user.getSocial(), user.getFavorites(), user.getCreatorEvents(),
                user.getUserEvents());
    }
}
