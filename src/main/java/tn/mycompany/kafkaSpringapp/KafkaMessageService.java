package tn.mycompany.kafkaSpringapp;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tn.mycompany.kafkaSpringapp.entities.Employee;

@Service
public class KafkaMessageService {
    @KafkaListener(topics = "topic5", groupId = "group-1")
    public void onMessage(Employee  employee) throws Exception {
        System.out.println("***************");
      //  Employee employee = employeeMapper(consumerRecord.value());
      // System.out.println(" name=>" + employee.getName() + " email=> " + employee.getEmail() + "dept=> " + employee.getDepartment() +
       //         " salary" + employee.getSalary());
        System.out.println(employee.toString());

    }

    private Employee employeeMapper(String jsonEmployee) throws Exception {
        JsonMapper jsonMapper = new JsonMapper();
        Employee employee = jsonMapper.readValue(jsonEmployee, Employee.class);
        return employee;
    }
}
