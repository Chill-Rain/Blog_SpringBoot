package club.chillrainqcna.service;

import club.chillrainqcna.bean.Article;
import club.chillrainqcna.bean.result.Result;

public interface ArticleService {
    Result loadAllArticle();

    Result addArticle(Article article);
}
