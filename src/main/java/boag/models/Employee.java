package boag.models;


import boag.enums.Gender;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {

    String name;
    int age;
    BigDecimal salary;
    Gender gender;
}
