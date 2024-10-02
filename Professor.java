import java.util.ArrayList;

public class Professor {
    int idProfessor;
    String NomeProfessor;
    String Departamento;
    int idCurso;

    Curso curso;
    static ArrayList<Professor> professores = new ArrayList<>();

    public Professor(int idProfessor, String NomeProfessor, String Departamento, int idCurso) {
        this.idProfessor = idProfessor;
        this.NomeProfessor = NomeProfessor;
        this.Departamento = Departamento;

        this.curso = Curso.buscaCurso(idCurso);
        professores.add(this);
    }

    static void verificaId(int idProfessor) throws Exception {
        for (Professor professor : professores) {
            if (professor.idProfessor == idProfessor) {
                return;
            }
        }
        throw new Exception("Professor não encontrada");
    }

    static Professor buscaProfessor(int idProfessor) {
        for (Professor professor : professores) {
            if (professor.idProfessor == idProfessor) {
                return professor;
            }
        }
        return null;
    }
}