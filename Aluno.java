import java.util.ArrayList;

public class Aluno {
    int idAluno;
    String NomeAluno;
    String DataNascimento;
    String cpf;
    int idCurso;

    Curso curso;
    static ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno(int idAluno, String NomeAluno, String DataNascimento, String cpf, int idCurso) {
        this.idAluno = idAluno;
        this.NomeAluno = NomeAluno;
        this.DataNascimento = DataNascimento;
        this.cpf = cpf;
        this.idCurso = idCurso;

        this.curso = Curso.buscaCurso(idCurso);

        alunos.add(this);
    }

    public Aluno(int idAluno, String NomeAluno, String DataNascimento, String cpf, Curso Curso) {
        this.idAluno = idAluno;
        this.NomeAluno = NomeAluno;
        this.DataNascimento = DataNascimento;
        this.cpf = cpf;
        this.curso = Curso;

        alunos.add(this);
    }

    static ArrayList<Curso> cursos = new ArrayList<>();
    
    static Curso verificaNome(String NomeCurso) throws Exception {
        for (Curso curso : cursos) {
            if (curso.NomeCurso.equals(NomeCurso)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    static Curso buscaCurso(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.idCurso == idCurso) {
                return curso;
            }
        }
        return null;
    }
}
