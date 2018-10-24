package com.aron.blog.es;

import com.alibaba.fastjson.JSONObject;
import com.aron.blog.domain.entity.User;
import com.aron.blog.service.ElasticSearchService;
import com.aron.blog.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Y-Aron
 * @create: 2018-10-23 20:24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ESTest {

    @Autowired
    private ElasticSearchService elasticSearchService;


    @Test
    public void setSource() {
        Map<String, Object> map = new HashMap<>();
        map.put("content", "我是一只小蜜蜂~~1");
        String test = elasticSearchService.setSource("test", "articles", "10", map);
        System.out.println(test);
    }

    @Test
    public void match() {
        String json = null;
        JSONObject jsonObject = elasticSearchService.matchQuery("test", "articles", json);
        System.out.println(jsonObject);
    }

    @Test
    public void isIndex(){
        boolean aaa = elasticSearchService.isIndexExist("test");
        System.out.println(aaa);
    }

    @Test
    public void buildIndex(){
        boolean aaa = elasticSearchService.buildIndex("test2");
        System.out.println(aaa);
    }

    @Test
    public void deleteIndex(){
        boolean aaa = elasticSearchService.deleteIndex("test1");
        System.out.println(aaa);
    }

    @Test
    public void delSource(){
        boolean aaa = elasticSearchService.delSource("test", "articles", "10");
        System.out.println(aaa);
    }

    @Test
    public void updateSource(){
        Map<String, Object> map = new HashMap<>();
        map.put("title", "update title");
        User user = new User();
        user.setId(Utils.generateUUID());
        String json = "{\n" +
                "    \"title\": \"插入测试标题1331\"\n" +
                "  }";

        boolean b = elasticSearchService.updateSource("test", "articles", "1", json);
        System.out.println(b);
    }
}
