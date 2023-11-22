package tn.mycompany.kafkaSpringapp;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.mycompany.kafkaSpringapp.entities.Employee;

@RestController
public class MyRestController {
    /*private KafkaTemplate<String, String> kafkaTemplate;

    public MyRestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/send/{message}/{topic}")
    public String send(@PathVariable String message, @PathVariable String topic) {
        kafkaTemplate.send(topic, "key+"+message.length(),message);
        return "Message sent";
    }*/
private KafkaTemplate<String,Employee> kafkaTemplate;

    public MyRestController(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @GetMapping("/send/{name}/{topic}")
    public String send(@PathVariable String name, @PathVariable String topic) {
        kafkaTemplate.send(topic, new Employee(name,name+"@gmail.com","dept1",5000));
        return "Json sent";
    }
}
