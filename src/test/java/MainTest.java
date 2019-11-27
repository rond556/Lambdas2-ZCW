package java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest implements CheckPerson{

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Person> personList = new ArrayList<>();
        Person terra = new Person("terra", 18, Person.Sex.FEMALE, "terra@esper.com");
        Person locke = new Person("locke", 21, Person.Sex.MALE, "locke@treasurehunter.org");
        Person sabin = new Person("sabin", 23, Person.Sex.MALE, "sabin@figaro.com");
        Person edgar = new Person("edgar", 24, Person.Sex.MALE, "edgar@figaro.com");
        personList.add(terra);
        personList.add(locke);
        personList.add(sabin);
        personList.add(edgar);



        class overTwenty implements CheckPerson{
            @Override
            public boolean test(Person p) {
                return p.getAge() > 20;
            }
        }
        printPersons(personList, new overTwenty());



        printPersons(personList, new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getAge() > 20;
                    }
                }
        );

        printPersons(personList,(Person p) -> p.getAge() == 20);
    }



    @Override
    public boolean test(Person p) {
        return p.gender.equals(Person.Sex.FEMALE);
    }
}
