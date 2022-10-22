package boag.models;

import boag.enums.Gender;
import boag.enums.Religion;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person{
    private  String fullName;
    private int age;
    private  String state;
    private boolean hasPVC;
    private Religion religion;
    private Gender gender;

}
