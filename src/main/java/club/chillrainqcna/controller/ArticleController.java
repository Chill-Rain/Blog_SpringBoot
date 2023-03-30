package club.chillrainqcna.controller;

import club.chillrainqcna.bean.Article;
import club.chillrainqcna.bean.result.Result;
import club.chillrainqcna.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChillRain 2023 03 18
 */
@Controller
@RequestMapping("/article")//文章CPU 将与文章相关的操作转发目标Service
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/all")
    @ResponseBody
    @CrossOrigin
    /**
     * 加载全部的文章
     */
    public Result loadAllArticle(){
        return articleService.loadAllArticle();
    }
    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin
    /**
     * 文章写入
     */
    public Result addArticle(@RequestBody Article article){
        System.out.println("Controller---");
        System.out.println("data: " + article);
        return articleService.addArticle(article);
    }

}
