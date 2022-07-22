import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PersonTest {

    static Person person;

    @BeforeAll
    public static void setup() {
       person = new Person();
    }

    @ParameterizedTest
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String nome) {
        person.setNome(nome);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String nome) {
        person.setNome(nome);
    }

   @ParameterizedTest
   @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String senha) {
       person.setSenha(senha);
       Assertions.assertFalse(person.checkPassword());
   }

   @ParameterizedTest
   @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
   public void does_not_have_numbers(String senha) {
       person.setSenha(senha);

       Assertions.assertFalse(person.checkPassword());
   }

    @ParameterizedTest
    @ValueSource(strings = {"Abc@123", "N12$@hbt"})
    public void does_not_have_eight_chars(String senha) {
        person.setSenha(senha);

        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String senha) {
        person.setSenha(senha);
    }
}

