package club.chillrainqcna.bean.result;

/**
 * @author ChillRain 2023 03 18
 */
public class ResultFactory {
    public static Result buildSuccessResult(String mess,Object data){
        return buildResult(ResultCode.SUCCESS.code, mess, data);
    }
    public static Result buildFailResult(String mess){
        return buildResult(ResultCode.FAIL.code, mess, null);
    }
    public static Result buildResult(int resultcode, String mess, Object data){
        return new Result(resultcode, mess, data);
    }
}
