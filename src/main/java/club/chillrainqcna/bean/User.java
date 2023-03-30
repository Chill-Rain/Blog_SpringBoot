package club.chillrainqcna.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChillRain 2023 03 11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private int permission;
}
