import java.time.LocalDate;

public class Person {

        public enum Sex {
            MALE, FEMALE
        }

        String name;
        LocalDate birthday;
        Integer age;
        Sex gender;
        String emailAddress;

        public Person(String name, Integer age, Sex gender, String emailaddress){
            this.name = name;
            this.age = age;
            this.birthday = LocalDate.MAX;
            this.gender = gender;
            this.emailAddress = emailaddress;

        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
        System.out.println(this.toString());
    }
}

