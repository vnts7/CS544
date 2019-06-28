package edu.mum.main;


import java.util.List;

import edu.mum.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        UserService us = (UserService) applicationContext.getBean("userServiceImpl");
//        UserService us = new UserServiceImpl();
        User u = new User();
        u.setFirstName("Handsome");
        u.setLastName("Mohamed");
        u.setEmail("hmm@gmail.com");
        us.save(u);//new User("hmm@gmail.com", "Handsome", "Mohamed"));

        System.out.println("User Name:" + us.findByEmail("hmm@gmail.com").getName());
    }

}