package club.chillrainqcna.util;

import club.chillrainqcna.bean.User;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author ChillRain 2023 03 19
 */
public class TokenUtil {
    private static final String SALT = "あいうえお";
    //token格式：   (username + ":" + 当前时间) -> base64加密 = TempToken; (TempToken + ":" + salt) -> base64加密
    /**
     * 转为token
     * @param user
     * @return
     */

    public static String toToken(User user) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String tempToken = base64Encoder.encode((user.getUsername() + ":" + System.currentTimeMillis()).getBytes());
        String token = base64Encoder.encode((tempToken + ":" + SALT).getBytes());
        return token;
    }

    /**
     * 逆向 token转为username
     * @param token
     * @return
     */
    public static String parseToken(String token) throws IOException {
        String username = null;
        BASE64Decoder base64Decoder = new BASE64Decoder();
        String tempToken = new String(base64Decoder.decodeBuffer(token));
        tempToken = tempToken.substring(0, tempToken.indexOf(":"));
        tempToken = new String(base64Decoder.decodeBuffer(tempToken));
        username = tempToken.substring(0,tempToken.indexOf(":"));
        return username;
    }
}
