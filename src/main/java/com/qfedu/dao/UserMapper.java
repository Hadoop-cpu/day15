package com.qfedu.dao;

import com.qfedu.pojo.User;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Author: 王赛
 * @Date: 2020/6/15
 * @Time: 13:26
 */
public interface UserMapper {
    //查询全部
    public List<User> findAll();
    //根据Id查询全部
    public List<User> findAllById(List<Integer> list);
    //根据userName查询
    public User findByUserName(String stuName);
    //根据姓名模糊查询
    List<User> findUserByNameLink(String stuName);
    //通过Id修改姓名
    public void updateUser(User user);
    //添加用户
    public int addUser(User user);


}
