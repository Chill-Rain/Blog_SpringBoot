package club.chillrainqcna.bean.result;

/**
 * @author ChillRain 2023 03 17
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应码
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private int code;
    private String mess;
    private Object data;
}
