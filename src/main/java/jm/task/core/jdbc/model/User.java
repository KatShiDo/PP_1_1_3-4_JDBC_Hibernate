package jm.task.core.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Scanner;

@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String lastName;

    private Byte age;

    @Override
    public String toString() {
        return "User " + id + ": (" + name + ", " + lastName + ", " + age + ")";
    }
}
