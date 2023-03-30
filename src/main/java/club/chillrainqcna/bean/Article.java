package club.chillrainqcna.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChillRain 2023 03 18
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
    private int id;
    private String title;
    private String date;
}
