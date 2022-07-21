import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Person person;

    @BeforeEach
    public void setup() {
        person = new Person("Paul", "McCartney", 2000,
                true, true, true);
    }

    @Test
    public void show_full_name() {
        String personFullName = person.fullname();
        String name = "Paul McCartney";

        Assertions.assertEquals(name, personFullName);
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        Assertions.assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        person.setBirthDate(2005);
        person.setAnotherCompanyOwner(false);
        person.setSalary(1200);
        person.setPensioner(false);
        person.setPublicServer(false);

        Assertions.assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        Assertions.assertFalse(person.isMEI());
    }
}
