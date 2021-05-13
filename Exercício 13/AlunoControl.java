import javafx.beans.property.*;


import java.util.ArrayList;
import java.util.List;

public class AlunoControl {
    private List<Aluno> lista = new ArrayList<>();

    private StringProperty nome = new SimpleStringProperty("");
    public StringProperty nomeProperty() {
        return nome;
    }

    private StringProperty ra = new SimpleStringProperty("");
    public StringProperty raProperty() {
        return ra;
    }

    private StringProperty nascimento = new SimpleStringProperty("");
    public StringProperty nascimentoProperty() {
        return nascimento;
    }

    private LongProperty id = new SimpleLongProperty(0);
    public LongProperty idProperty() {
        return id;
    }

    public Aluno getEntity() {
        Aluno aluno = new Aluno();
        aluno.setNome(nome.get());
        aluno.setRa(ra.get());
        aluno.setId(id.get());
        aluno.setNascimento(nascimento.get());
        return aluno;
    }
    private void setEntity(Aluno aluno) {
        if (aluno != null) {
            nome.set(aluno.getNome());
            id.set(aluno.getId());
            ra.set(aluno.getRa());
            nascimento.set(aluno.getNascimento());
        }
    }

    public void adicionar() {
        lista.add(getEntity());
    }

    public void pesquisarPorNome() {
        for (Aluno aluno : lista) {
            if (aluno.getNome().contains(nome.get())) {
                setEntity(aluno);
            }
        }
    }
}