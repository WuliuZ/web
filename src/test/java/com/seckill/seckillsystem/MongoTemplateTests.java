package com.seckill.seckillsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.seckill.seckillsystem.Pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * 包名称：com.hjxmongodb.mongdb
 * @version 创作时间:2023年11月9日上午10:09:09
 *
 */

@SpringBootTest
public class MongoTemplateTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    static final String collectionName = "user";

    @Test
    void collectionExists() {
        System.out.println("创建集合，即数据库");

        // 判断是否已经存在该集合名称
        boolean collectionNameExists = mongoTemplate.collectionExists(collectionName);
        if (!collectionNameExists) {
            MongoCollection<org.bson.Document> document = mongoTemplate.createCollection(collectionName);
            System.out.println(document.toString());
        } else {
            System.out.println(collectionName + " is exists.");
        }

    }

    @Test
    void create() {
        System.out.println("批量增加数据...");
        Random random = new Random();
        Collection<User> userList = new ArrayList<User>();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setAge(random.nextInt(22, 50));
            user.setGender(random.nextInt(0, 2) + "");
            user.setName("hjx" + random.nextInt(10000));
            user.setEmail("hjx" + random.nextInt(10000) + "wm@163.com");
            userList.add(user);
        }

        System.out.println("批量插入：" + userList.size() + "条数据。");
        List<User> t = (List<User>) mongoTemplate.insert(userList, collectionName);
        System.out.println("保存成功 ： " + t.size());

    }

    @Test
    void findUser() {
        System.out.println("根据条件查找用户信息...");
        Query query = new Query();
        Criteria criteria = Criteria.where("age").gte(30); // 年龄等于30
        Criteria nameCriteria = Criteria.where("name").regex("99"); // 名称中包括99

        Criteria andCriteria = new Criteria();
        andCriteria.andOperator(criteria, nameCriteria);

        query.addCriteria(andCriteria);

        query.limit(400);
        List<User> userList = mongoTemplate.find(query, User.class, collectionName);
        System.out.println(userList.size());
        userList.forEach(item -> System.out.println(item));

    }

    @Test
    void findAll() {
        System.out.println("分页按条件查询数据....");

        Query query = new Query();

        Criteria criteria = Criteria.where("age").gte(30); // 年龄大于等于30
        Criteria nameCriteria = Criteria.where("name").regex("99"); // 名称中包含有99

        Criteria andCriteria = new Criteria();
        andCriteria.andOperator(criteria, nameCriteria);

        query.addCriteria(andCriteria);

        for (int i = 0; i < 10; i++) {

            Pageable pageable = PageRequest.of(i, 10);//每页查询10条数据
            query.with(pageable);

            List<User> pages = mongoTemplate.find(query, User.class, collectionName);

            System.out.println(pages.size());
            System.out.println(pages);
            System.out.println("------------------------");
        }

    }

    @Test
    void findallUser() {
        System.out.println("查询所有数据，循环输出....");

        List<User> user = mongoTemplate.findAll(User.class, collectionName);

        // 第一种循环打印数据的方式：
        user.forEach(item -> System.out.println(item));

        // 第二种循环打印数据的方式：
        user.forEach(System.out::println);
    }


    @Test
    void update() {
        System.out.println("更新用户信息...");
        Criteria updateCriteria = Criteria.where("age").is(22);

        Update updateItem = new Update();
        updateItem.set("age", 32);

        UpdateResult result = mongoTemplate.updateMulti(new Query(updateCriteria), updateItem, User.class,
                collectionName);

        System.out.println(result.toString());

    }

    @Test
    void delete() {
        System.out.println("删除用户信息...");
        Criteria updateCriteria = Criteria.where("age").is(35);

        DeleteResult result = mongoTemplate.remove(new Query(updateCriteria), User.class, collectionName);

        System.out.println(result);
    }

    //	@Test
    void deleteAll() {
        System.out.println("删除所有用户信息...");

        //方式1：删除所有数据
//		DeleteResult result = mongoTemplate.remove(new Query(), collectionName);
//		System.out.println(result);

        //方式2：删除所有数据,删除集合就可以了。
        mongoTemplate.dropCollection(collectionName);



    }

}