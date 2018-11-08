package com.book;

import com.book.config.RedisDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: 一点点
 * @Date: 2018/11/4 20:07
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @LocalServerPort
    private Integer port;
    private URL base;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RedisDao redisDao;
    @Before
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:"+port+"/index");
    }
    @Test
    public void index(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(base.toString(),String.class);
       Assert.assertTrue(response.getBody().contentEquals("this is index"));
    }
    @Test
    public void testRedis(){
     redisDao.setKey("name","zhangjie");
     redisDao.setKey("age","23");
        logger.info("this result is :"+redisDao.getKey("name")+",age:"+redisDao.getKey("age"));
    }

}
