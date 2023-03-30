package club.chillrainqcna.service.serviceImpl;

import club.chillrainqcna.bean.User;
import club.chillrainqcna.bean.result.Result;
import club.chillrainqcna.bean.result.ResultFactory;
import club.chillrainqcna.mapper.UserMapper;
import club.chillrainqcna.service.UserService;
import club.chillrainqcna.util.MD5Util;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author ChillRain 2023 03 11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private UserMapper userMapper;
    @Override
    public String register(User user) {
        System.out.println("UserService---");
        user = MD5Util.MD5Register(user);
        System.out.println("user inserting---");
        userMapper.insUser(user);
        System.out.println("user: " + user.getUsername() + " is registing---");
        return "registe success!";
    }

    /**
     * if(redis中有){
     *      登陆成功
     * }else{
     *     if(数据库中有){
     *         登陆成功并把用户信息载入redis
     *     }else{
     *         返回登录失败
     *     }
     *
     * }
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
//        String mess = null;
//        System.out.println("UserService---");
//        Jedis jedis = jedisPool.getResource();
//        String jedisUser = jedis.get("user-" + user.getUsername());
//        if(jedisUser != null){//缓存中有用户数据
//            System.out.println("Get UserData from Redis---");
//            mess = "Login Success!";
//            return ResultFactory.buildSuccessResult(mess, TokenUtil.toToken(user));
//        }else{//缓存中没有 查询数据库
//            String salt = userMapper.selSalt(user);
//            if(salt != null){//用户是存在的
//                user.setPassword(MD5Util.MD5Login(user.getPassword() + salt));
//                user = userMapper.selUser(user);
//                if(user != null){//查询到了数据
//                    System.out.println("Get UserData from MySQL---");
//                    mess = "login success!";
//                    String user2Json = JSONObject.toJSONString(user);
//                    jedis.set("user-" + user.getUsername(),user2Json);
//                    jedis.expire("user-" + user.getUsername(), 7 * 24 * 60 * 60);
//                }else {//密码错误
//                    mess = "error password";
//                    return ResultFactory.buildSuccessResult(mess,null);
//                }
//            }else{//用户不存在
//                mess = "user not found!";
//                return ResultFactory.buildSuccessResult(mess,null);
//            }
//        }
//        jedis.close();//关闭连接
//        return ResultFactory.buildSuccessResult(mess,TokenUtil.toToken(user));
        // 使用shiro
//        Jedis jedis = jedisPool.getResource();
//        String userToken = jedis.get("user-" + user.getUsername());
//        if(userToken != null){//redis中有用户数据
//            return  ResultFactory.buildSuccessResult("login success!",user.getUsername());
//        }
        System.out.println("login by shiro---");
        Subject subject = SecurityUtils.getSubject();//创建角色
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());//创建角色对应的token
        try{
            subject.login(usernamePasswordToken);//登录 调用LoginRealm中的方法
//            jedis.set("user-" + user.getUsername(), String.valueOf(usernamePasswordToken));
            return ResultFactory.buildSuccessResult("login success!", user.getUsername());
        }catch (AuthenticationException e){
            return ResultFactory.buildFailResult("wrong password or user not found!");
        }
    }
}
