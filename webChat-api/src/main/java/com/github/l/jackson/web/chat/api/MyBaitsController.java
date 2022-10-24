package com.github.l.jackson.web.chat.api;

import com.github.l.jackson.web.chat.listener.MyListener;
import com.github.l.jackson.web.chat.dao.UserDao;
import com.github.l.jackson.web.chat.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MyBaitsController {

    @Resource
    UserDao userDao;

    @GetMapping("/count")
    public String onlineNum(HttpSession session){

        return "有这么多人在线：" + MyListener.count + "人";
    }

    @GetMapping("/users/query")
    public List<User> queryAll(){
        return userDao.findAllUsers();
    }

    @GetMapping("/users/querystudent")
    public User queryStudent(String name){
        User user = new User();
        user.setName(name);
        return userDao.findStudent(user);

    }

    @GetMapping("/users/queryStudentThroughNumber")
    public User queryStudentThroughNum(String num){
        User user = new User();
        user.setStudentnumber(num);
        return userDao.findStudentThroughStudentNumber(user);
    }


    @GetMapping("/users/insert")
    public boolean insertUser(String name , String studentnumber){
        User user = new User();
        user.setName(name);
        user.setStudentnumber(studentnumber);
        return userDao.insertUser(user) > 0;
    }

    @GetMapping("/users/update")
    public boolean updUser(Integer id,String name,String studentnumber){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setStudentnumber(studentnumber);
        return userDao.updUser(user) > 0;
    }


    @GetMapping("/users/delete")
    public boolean insert(Integer id) {
        return userDao.deleteUser(id) > 0;
    }


}