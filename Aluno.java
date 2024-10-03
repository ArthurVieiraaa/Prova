import java.util.ArrayList;

public class Aluno {
    int idAluno;
    String nomeAluno;
    String dataNascimento;
    String cpf;
    int idCurso;

    Curso curso;
    static ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno(int idAluno, String nomeAluno, String dataNascimento, String cpf, Curso curso) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;

        alunos.add(this);
    }

    public Aluno(int idAluno, String nomeAluno, String dataNascimento, String cpf, int idCurso) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.idCurso = idCurso;

        alunos.add(this);
    }

    static void verificaid(int idAluno) throws Exception {
        for (Aluno aluno : alunos) {
            if (aluno.idAluno == idAluno) {
                return;
            }
        }
        throw new Exception("Aluno não encontrado");
    }

    static Aluno buscaAluno(int idAluno) {
        for (Aluno aluno : alunos) {
            if (aluno.idAluno == idAluno) {
                return aluno;
            }
        }
        return null;
    }
}
