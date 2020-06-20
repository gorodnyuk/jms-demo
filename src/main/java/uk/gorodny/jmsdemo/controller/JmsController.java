package uk.gorodny.jmsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gorodny.jmsdemo.model.User;

@RestController
@RequestMapping("/")
public class JmsController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/produce")
    public String produce() {
        User user = new User();
        user.setName("Mike");
        user.setAge(30);
        jmsTemplate.convertAndSend("queue2", user);
        return "done";
    }
}
