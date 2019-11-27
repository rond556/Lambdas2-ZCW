import java.time.LocalDate;

public class Person {

        public enum Sex {
            MALE, FEMALE
        }

        String name;
        Integer age;
        Sex gender;
        String emailAddress;

        public Person(String name, Integer age, Sex gender, String emailaddress){
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.emailAddress = emailaddress;

        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
        System.out.println(String.format("Person Name: %s, Age: %d, Gender: %s, Email Address: %s\n",
                name, age, gender, emailAddress));
    }
}

