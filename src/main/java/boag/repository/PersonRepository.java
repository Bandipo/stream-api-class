package boag.repository;

import boag.enums.Gender;
import boag.enums.Religion;
import boag.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

  private static  List<Person> persons = new ArrayList<>();

   static {
       persons.add(new Person("Timothy Adewale", 18, "Lagos", true , Religion.CHRISTIANITY, Gender.MALE));
       persons.add(new Person("Joshua Peter", 18, "Lagos", true, Religion.CHRISTIANITY, Gender.MALE));
       persons.add(new Person("Kehinde Chineke", 20, "Lagos", false, Religion.CHRISTIANITY, Gender.MALE));
       persons.add(new Person("Omenebele Anenanu", 25, "Enugu", true, Religion.CHRISTIANITY, Gender.FEMALE));
       persons.add(new Person("Saidat Umar", 25, "Sokoto", true, Religion.CHRISTIANITY, Gender.FEMALE));
       persons.add(new Person("Janet Peter", 23, "Benue", true, Religion.CHRISTIANITY, Gender.FEMALE));
       persons.add(new Person("Tobenna Chineke", 27 , "Anambra" , true, Religion.CHRISTIANITY, Gender.MALE));
       persons.add(new Person("Chukwuemeka Ekwueme", 30, "Enugu", false, Religion.CHRISTIANITY, Gender.MALE));
       persons.add(new Person("Darlington Collins", 33, "Ebonyi", true, Religion.CHRISTIANITY, Gender.MALE));
       persons.add(new Person("Kabir Raheem", 35, "Kaduna", true, Religion.ISLAM, Gender.MALE));
       persons.add(new Person("Abdulahi Sumanu", 40, "kastina", true, Religion.ISLAM, Gender.MALE));
       persons.add(new Person("Kabir Raheem", 35, "Kaduna", true, Religion.ISLAM, Gender.MALE));
       persons.add(new Person("Abdulahi Sumanu", 40, "kastina", true, Religion.ISLAM, Gender.MALE));
       persons.add(new Person("AbdulKareem Abdulahi", 13, "kano", true, Religion.ISLAM, Gender.MALE));
       persons.add(new Person("Bashir Danjuma", 17, "kano", true, Religion.ISLAM, Gender.MALE));
       persons.add(new Person("Hassan Hussain", 13, "kano", true, Religion.ISLAM, Gender.MALE));


   }


   public static List<Person>  getPersons(){
       return persons;
   }

}
