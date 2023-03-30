package club.chillrainqcna.mapper;

import club.chillrainqcna.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author ChillRain 2023 03 11
 */
@Repository
public interface UserMapper {
    void insUser(User user);

    String selSalt(User user);

    User selUser(User user);
    User selUserByUserName(String username);
}
