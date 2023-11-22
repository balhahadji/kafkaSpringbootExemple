package tn.mycompany.kafkaSpringapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String email;
    private String department;
    private double salary;


}
