import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //FILTER
        List<Person>peaple=getPeople();
       List<Person>female= peaple.stream().filter(person -> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
      //  female.forEach(System.out::println);
        //sort
        List<Person>sorted=peaple.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed()).collect(Collectors.toList());
        //System.out.println(sorted);

        //allmatch
        boolean allmatch=peaple.stream().allMatch(person -> person.getAge()>10);
      //  System.out.println(allmatch);
        //anymatch
        boolean anymatch= peaple.stream().anyMatch(person -> person.getAge()>20);
        //System.out.println(anymatch);
        //nonematch
        boolean nonematch = peaple.stream().noneMatch(person -> person.getAge()<20);
        //System.out.println(nonematch);
        //max
        Optional<Person> max=peaple.stream().max(Comparator.comparing(Person::getAge));
       // System.out.println(max);
        //min
        //peaple.stream().min(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);
        //group
        Map<Gender,List<Person>>GroupByGender=peaple.stream().collect(Collectors.groupingBy(Person::getGender));
        //System.out.println(GroupByGender);

    }
        private static List<Person> getPeople() {
            return List.of(
                    new Person("osama", 26, Gender.MALE),
                    new Person("Asma", 26, Gender.FEMALE),
                    new Person("heba", 20, Gender.FEMALE),
                    new Person("tariq", 24, Gender.MALE),
                    new Person("Khaled", 15, Gender.MALE),
                    new Person("noha", 24, Gender.FEMALE),
                    new Person("marwa", 30, Gender.FEMALE)
            );
        }
    }
