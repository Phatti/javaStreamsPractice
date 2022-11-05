import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
       /* //imperative approach

        // In imperative you will define everything for the logic you want to achieve .Example above where you want to filter all females for people list.


List<Person> females= new ArrayList<>();
for(Person person:people)
{
    if(person.getGender().equals(Gender.FEMALE))
    {
       females.add(person);
    }

}
        females.forEach(System.out::println);*/
//Declarative approach



        //any match
        //none match

        //min
        // Group

        //Filter
        List<Person> females=people.stream()
                .filter(person-> person.getGender().equals(Gender.FEMALE))
                        .collect(Collectors.toList());
//females.forEach(System.out::println);
//sort
        List<Person> sorted= people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
       // sorted.forEach(System.out::println);

        //All match
       Boolean peopleAllMatchless7= people.stream()
                .allMatch(person -> person.getAge()<121);
        System.out.println("peopleAllMatchless7 "+peopleAllMatchless7);
        //any match
        Boolean peopleanyMatchless7= people.stream()
                .anyMatch(person -> person.getAge()<5);
        System.out.println("peopleanyMatchless7 "+peopleanyMatchless7);

        //none match
        Boolean peopleNoneMatchName= people.stream()
                .noneMatch(person -> person.getName().equals("James anna"));
        System.out.println("peopleNoneMatchName "+peopleNoneMatchName);
//max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

//min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);


        // Group
        Stream<Person> peopleStream=people.stream();
       Map<Gender,List<Person>> groupByGender= peopleStream.collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender,people1)->{
System.out.println(gender);
people1.forEach(System.out::println);


        });

}




    //Declarative approach
    //Filter
    //sort
    //All match
    //any match
    //none match

    //min
    // Group

        private static List<Person> getPeople()
        {
            return List.of(
                    new Person("James Bond", 20, Gender.FEMALE),
                    new Person("Alice Bond", 7, Gender.MALE),
                    new Person("James anna", 5, Gender.FEMALE),
                    new Person("Preeti Bond", 100, Gender.MALE),
                    new Person("James bonet", 29, Gender.FEMALE),
                    new Person("James brown", 120, Gender.FEMALE),
                    new Person("James Bend", 19, Gender.MALE)
            );
        }
    }

