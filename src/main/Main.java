import java.util.ArrayList;
import java.util.List;

public class Main implements CheckPerson {

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        Person terra = new Person("Terra Bradford", 18, Person.Sex.FEMALE, "terra@esper.com");
        Person locke = new Person("Locke Cole", 21, Person.Sex.MALE, "locke@treasurehunter.org");
        Person sabin = new Person("Sabin Figaro", 23, Person.Sex.MALE, "sabin@figaro.com");
        Person edgar = new Person("Edgar Figaro", 24, Person.Sex.MALE, "edgar@figaro.com");
        personList.add(terra);
        personList.add(locke);
        personList.add(sabin);
        personList.add(edgar);


        class getGender implements CheckPerson {
            @Override
            public boolean test(Person p) {
                return p.getGender().equals(Person.Sex.FEMALE);
            }
        }
        printPersons(personList, new getGender());


        printPersons(personList, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                        return p.getAge() > 20;
                    }
            }
        );

        printPersons(personList, (Person p) -> p.getGender().equals(Person.Sex.FEMALE));
    }



    @Override
    public boolean test(Person p) {
        return false;
    }
}