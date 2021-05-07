import java.util.ArrayList;
import java.util.List;

public class alunoControl {





        private List<Aluno> lista = new ArrayList<>();

        public void adicionar (Aluno a) {
            lista.add(a);
        }

        public Aluno pesquisarPorAluno(String Nome) {
            for (Aluno a : lista) {
                if (a.getNome().contains(Nome)) {
                    return a;
                }
            }
            return null;
        }
    }

