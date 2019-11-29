import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    ArrayList<Person> personList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Person terra = new Person("Terra Bradford", 18, Person.Sex.FEMALE, "terra@esper.com");
        Person locke = new Person("Locke Cole", 21, Person.Sex.MALE, "locke@treasurehunter.org");
        Person sabin = new Person("Sabin Figaro", 23, Person.Sex.MALE, "sabin@figaro.com");
        Person edgar = new Person("Edgar Figaro", 24, Person.Sex.MALE, "edgar@figaro.com");
        personList.add(terra);
        personList.add(locke);
        personList.add(sabin);
        personList.add(edgar);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void localClassTest() {
        class getGender implements CheckPerson {
            @Override
            public boolean test(Person p) {
                return p.getGender().equals(Person.Sex.FEMALE);
            }
        }
        Main.printPersons(personList, new getGender());
        Assert.assertEquals("Person Name: Terra Bradford, Age: 18, Gender: FEMALE, Email Address: terra@esper.com\n", systemOutRule.getLog());
    }

    @Test
    public void lambdaTest(){
        Main.printPersons(personList, (Person p) -> p.getGender().equals(Person.Sex.FEMALE));
        Assert.assertEquals("Person Name: Terra Bradford, Age: 18, Gender: FEMALE, Email Address: terra@esper.com\n", systemOutRule.getLog());
    }

    @Test
    public void anonymousClass(){
        Main.printPersons(personList, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getAge() > 20;
            }
        }
        );
        Assert.assertEquals("Person Name: Locke Cole, Age: 21, Gender: MALE, Email Address: locke@treasurehunter.org\n" +
                "Person Name: Sabin Figaro, Age: 23, Gender: MALE, Email Address: sabin@figaro.com\n" +
                "Person Name: Edgar Figaro, Age: 24, Gender: MALE, Email Address: edgar@figaro.com\n", systemOutRule.getLog());
    }
}