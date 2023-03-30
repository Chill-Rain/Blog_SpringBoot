package club.chillrainqcna.controller;

import club.chillrainqcna.bean.result.Result;
import club.chillrainqcna.bean.result.ResultFactory;
import club.chillrainqcna.util.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author ChillRain 2023 03 19
 */
@Controller
@RequestMapping("/token")
public class CheckTokenController {
    @PostMapping("/getUsername")
    @CrossOrigin
    @ResponseBody
    private Result getUsername(@RequestBody String token) throws IOException {
        System.out.println("checkToken----");
        System.out.println(token);
        String username = TokenUtil.parseToken(token);
        return ResultFactory.buildSuccessResult("done",username);
    }
}
