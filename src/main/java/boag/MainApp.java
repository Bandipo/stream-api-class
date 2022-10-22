package boag;

import boag.enums.Gender;
import boag.enums.Religion;
import boag.models.NumberService;
import boag.models.Person;
import boag.repository.PersonRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {

    public static void main(String[] args) {

        // Creating Stream: using Stream.of, from arrays using Arrays.stream, IntStream, etc

//        String[] names = {"Name1", "Name2", "Name"};
//
//        Stream.of("String1", "String2", "String3")
//                .forEach(str -> System.out.println(str));
//
//        Arrays.stream(names)
//                .forEach(str-> System.out.println(str));
//
//        IntStream.of(1,2,3,4,5)
//                .forEach(num -> System.out.println(num));



        //print all persons in the person repository using FOREACH

        PersonRepository.getPersons()
                .stream()
                .forEach(MainApp::printData);




        // filtering Operation:

          // filtering by amount using limit: just give me 8 persons
        System.out.println();
        System.out.println("filtering by amount");
        PersonRepository.getPersons()
                .stream()
                .limit(8)
                .forEach(MainApp::printData);


          // filtering by uniqueness using distinct: remove repeated record
        System.out.println();
        System.out.println("filtering by uniqueness");

        PersonRepository.getPersons()
                .stream()
                .distinct()
                .forEach(person -> System.out.println(person));

          // filtering by content using filter:
        System.out.println();
        System.out.println("filtering by content");

        // We want to get all the Female who have PVC


        PersonRepository.getPersons()
                .stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()) && person.isHasPVC())
                .limit(1)
                .forEach(System.out::println);


        // We want to get all persons who are  christians and have PVCs
        System.out.println();
        System.out.println("All Christians with PVC");

        PersonRepository.getPersons()
                .stream()
                .filter(MainApp::checkIfPersonIsChristianAndHasPVC)
                .forEach(MainApp::printData);





        // Transforming Operation using Map, FlatMap

                 // a simple Map operation to multiply each element by 2
        System.out.println();
        System.out.println("Simple Map Operation to multply each element by 2");

        NumberService numberService = new NumberService();

        Arrays.asList(1,2,3,4,4,5,5,6,7,8,9,10)
                .stream()
                .distinct()
                .map(numberService::multiplyBy2)
                .forEach(MainApp::printData);



                 // we want to get the initials of every person in a list

        System.out.println();
        System.out.println("we want to get the initials of every person in a list ");

        PersonRepository.getPersons()
                .stream()
                .distinct()
                .map(MainApp::convertPersonNameToInitials)
                .forEach(MainApp::printData);

        // Matching Operations using ANYMATCH, ALLMATCH, NONEMATCH

                // write a method to check if any person exist from a state ANYMATCH

        System.out.println("Does any Person in Nasarawa: "+ checkIfPersonsExistInState("Nasarawa"));


                // write a method to check if no person exist that does not have a pvc
        System.out.println("check if no person has pvc in a state: "+ checkIfNoPersonExistAndHasNoPVC("Kwara"));

                // write a method to check if every christian has a pvc

        boolean doAllChristianHavePVC = PersonRepository.getPersons()
                .stream()
                .filter(person -> Religion.CHRISTIANITY.equals(person.getReligion()))
                .allMatch(person ->   person.isHasPVC());

        System.out.println("Do all Christian have pvc: "+ doAllChristianHavePVC);


        //Finding Operations using findFirst and findAny



                //find the first female christian that has pvc in the list

       Person firstFemaleWithPVC = PersonRepository.getPersons()
                .stream()
                .filter(person -> Religion.CHRISTIANITY.equals(person.getReligion())
                        && Gender.FEMALE.equals(person.getGender()) && person.isHasPVC())
                .findFirst()
               .orElseThrow(() -> new RuntimeException("Person no dey o"));

        System.out.println(firstFemaleWithPVC);



    }

    private static <T extends Object> void printData(T t){
        System.out.println(t);
    }

    private static boolean checkIfPersonIsChristianAndHasPVC(Person person){
      return Religion.CHRISTIANITY.equals(person.getReligion()) && person.isHasPVC();
    }

    private static String convertPersonNameToInitials(Person person){
        String[] names = person.getFullName().split(" ");
        return String.format("%s%s",names[0].charAt(0), names[1].charAt(0));
    }

    private static boolean checkIfPersonsExistInState(String state) {
        return PersonRepository.getPersons()
                .stream()
                .anyMatch(person -> state.equals(person.getState()));
    }


    private static  boolean checkIfNoPersonExistAndHasNoPVC(String state){
        return PersonRepository.getPersons()
                .stream()
                .noneMatch(person -> state.equals(person.getState())  && person.isHasPVC() == false);

    }






}
