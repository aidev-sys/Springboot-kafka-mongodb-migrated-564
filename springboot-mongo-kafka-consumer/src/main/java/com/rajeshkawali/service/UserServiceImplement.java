package com.rajeshkawali.service;

import com.rajeshkawali.entity.User;
import com.rajeshkawali.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @RabbitListener(queuesToDeclare = @Queue(name = "myTopic"))
    public void consumeUser(User user) {
        System.out.println("Consumed User JSON Message: " + user);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> user = userRepository.findAll();
        return user;
    }
}