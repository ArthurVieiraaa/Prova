import java.util.ArrayList;

public class Curso {
    int idCurso;
    String NomeCurso;
    int CargaHoraria;
    int idProfessor;

    Professor professor;
    static ArrayList<Curso> cursos = new ArrayList<>();

    public Curso(int idCurso, String NomeCurso, int CargaHoraria, int idProfessor) {
        this.idCurso = idCurso;
        this.NomeCurso = NomeCurso;
        this.CargaHoraria = CargaHoraria;
        this.idProfessor = idProfessor;

        this.professor = Professor.buscaProfessor(idProfessor);

        cursos.add(this);
    }

    public Curso(int idCurso, String NomeCurso, int CargaHoraria, Professor professor) {
        this.idCurso = idCurso;
        this.NomeCurso = NomeCurso;
        this.CargaHoraria = CargaHoraria;
        this.professor = professor;

        cursos.add(this);
    }

    static void verificaId(int idCurso) throws Exception {
        for (Curso curso : cursos) {
            if (curso.idCurso == idCurso) {
                return;
            }
        }
        throw new Exception("Curso não encontrada");
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