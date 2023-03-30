package club.chillrainqcna.mapper;

import club.chillrainqcna.bean.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    List<Article> loadAllArticle();

    void addArticle(Article article);
}
