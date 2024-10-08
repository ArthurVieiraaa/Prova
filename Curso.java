import java.util.ArrayList;

public class Curso {
    int idCurso;
    String nomeCurso;
    int cargaHoraria;
    int idProfessor;

    Professor professor;
    static ArrayList<Curso> cursos = new ArrayList<>();

    public Curso(int idCurso, String nomeCurso, int cargaHoraria, Professor professor) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;

        cursos.add(this);
    }

    public Curso(int idCurso, String nomeCurso, int cargaHoraria, int idProfessor) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.idProfessor = idProfessor;

        cursos.add(this);
    }

    static void verificaId(int idCurso) throws Exception {
        for (Curso curso : cursos) {
            if (curso.idCurso == idCurso) {
                return;
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

    static Curso buscaProfessor(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.idCurso == idCurso) {
                return curso;
            }
        }
        return null;
    }

    static int contarAlunosPorCurso(int idCurso) {
        int cont = 0;
        for (Aluno aluno : Aluno.alunos) {
            if (aluno.idCurso == idCurso) {
                cont++;
            }
        }
        return cont;
    }
}