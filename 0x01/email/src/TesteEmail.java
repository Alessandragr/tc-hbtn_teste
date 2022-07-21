import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteEmail {

    @Test
    public static void testar_email_com_arroba() {
        Assertions.assertTrue(Pessoa.emailValid("email_teste@dominio.com.br"));

    }

    @Test
    public static void testar_email_sem_arroba() {
        Assertions.assertFalse(Pessoa.emailValid("email_testedominio.com.br"));

    }

    @Test
    public static void testar_email_mais_50_caracteres() {
        String email = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
        Assertions.assertEquals(email, Pessoa.emailValid("email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br"));
    }
}
