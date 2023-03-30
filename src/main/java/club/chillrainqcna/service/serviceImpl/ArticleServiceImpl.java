package club.chillrainqcna.service.serviceImpl;

import club.chillrainqcna.bean.Article;
import club.chillrainqcna.bean.result.Result;
import club.chillrainqcna.bean.result.ResultFactory;
import club.chillrainqcna.mapper.ArticleMapper;
import club.chillrainqcna.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChillRain 2023 03 18
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result loadAllArticle() {
        System.out.println("get Article from MySQL---");
;
//        System.out.println(article);
        return ResultFactory.buildSuccessResult("Load Article Success!",articleMapper.loadAllArticle());
    }

    @Override
    public Result addArticle(Article article) {
        articleMapper.addArticle(article);
        System.out.println(article);
        return ResultFactory.buildSuccessResult("Create Article Success!", null);
    }
}
