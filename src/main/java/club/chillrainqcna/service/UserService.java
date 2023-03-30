package club.chillrainqcna.service;

import club.chillrainqcna.bean.User;
import club.chillrainqcna.bean.result.Result;


public interface UserService {
    String register(User user);

    Result login(User user);
}
