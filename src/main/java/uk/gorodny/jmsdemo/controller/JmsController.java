package uk.gorodny.jmsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gorodny.jmsdemo.model.User;

@RestController
@RequestMapping("/")
public class JmsController {

    @Value("${queue.name}")
    private String queueName;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/produce/{name}/{age}")
    public String produce(@PathVariable("name") String name, @PathVariable("age") int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        jmsTemplate.convertAndSend(queueName, user);
        return "done";
    }
}
