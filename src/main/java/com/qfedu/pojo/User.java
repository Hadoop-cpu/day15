package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @ClassName: User
 * @Author: 王赛
 * @Date: 2020/6/15
 * @Time: 13:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer stuId;
    private String stuName;
    private Date stuBir;
    private String stuHobby;
    private int stuAge;
    private int gradeId;
    private String imgPath;
    private String pwd;


}
