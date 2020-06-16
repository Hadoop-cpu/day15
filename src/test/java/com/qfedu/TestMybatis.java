package com.qfedu;

import com.qfedu.dao.UserMapper;
import com.qfedu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestMybatis
 * @Author: 王赛
 * @Date: 2020/6/15
 * @Time: 13:37
 */
public class TestMybatis {

//查询全部
    @Test
    public void Test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAll = userMapper.findAll();
        System.out.println(userAll);

    }

    //根据Id查询全部
    @Test
    public void Test2() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(4);
        list.add(6);
        List<User> userList = userMapper.findAllById(list);
        System.out.println(userList);

    }

    //根据username查询全部
    @Test
    public void Test3() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findByUserName("root"));

    }

    //根据username修改姓名
    @Test
    public void Test4() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setStuId(6);
        user.setStuName("孙李");

        userMapper.updateUser(user);
        System.out.println(user);
        //sqlSession.commit();
    }

    //根据姓名模糊查询
    @Test
    public void Test5() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> byNameLink = userMapper.findUserByNameLink("王");
        System.out.println(byNameLink);
        //sqlSession.commit();
    }

    //添加用户
    @Test
    public void Test6() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//null,"王一",2018-02-19,"打篮球",15,1,null,"admin"

        User user = new User(null,"马吕",new Date(System.currentTimeMillis()),"打篮球",15,1,null,"admin");
       /* User user = new User();
        user.setStuId(null);
        user.setStuName("王一");
        user.setStuBir(new Date(System.currentTimeMillis()));
        user.setStuHobby("打篮球");
        user.setStuAge(15);
        user.setGradeId(1);
        user.setImgPath(null);
        user.setPwd("admin");*/

        System.out.println(user);
        System.out.println(userMapper.addUser(user));
        //sqlSession.commit();
    }
}
