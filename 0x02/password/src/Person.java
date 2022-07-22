import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String nome;
    private String senha;

    public Person(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Person() {

    }

    @Test
    public boolean checkUser() {
        Pattern pattern = Pattern.compile("([A-Z]| [a-z])[a-z]*");
        return pattern.matcher(this.nome).matches() && (this.nome.length()<=8);
    }

    @Test
    public boolean checkPassword() {
        Pattern patternMajor = Pattern.compile("([A-Z]*)");
        Pattern patternNumber = Pattern.compile("([0-9]*)");
        Pattern patternEspecial = Pattern.compile("([0-9][A-Z][a-z]*)");

        return patternMajor.matcher(this.senha).matches() && patternNumber.matcher(this.senha).matches() &&
                !patternEspecial.matcher(this.senha).matches() && (this.senha.length()<=8);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
