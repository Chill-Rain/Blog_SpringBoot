package club.chillrainqcna.util;

import club.chillrainqcna.bean.User;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author ChillRain 2023 03 15
 */
public class MD5Util {
    public static User MD5Register(User user){
        String password = user.getPassword();
        UUID uuid = UUID.randomUUID();//随机盐
        password = DigestUtils.md5DigestAsHex((password + uuid).getBytes());//存储密码的形式为： MD5（pwd + uuid）
        user.setPassword(password);
        user.setSalt(String.valueOf(uuid));
        return user;
    }

    public static String MD5Login(String s) {
        String password = DigestUtils.md5DigestAsHex(s.getBytes());
        return password;
    }
}
