import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("*** Sistema de Cadastro de Professores, Cursos e Alunos ***");
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do{
            System.out.println("\nMenu:");
            System.out.println("[1] - Cadastrar Professor");
            System.out.println("[2] - Cadastrar Curso");
            System.out.println("[3] - Cadastrar Aluno");
            System.out.println("[4] - Listar Professores");
            System.out.println("[5] - Listar Cursos");
            System.out.println("[6] - Listar Alunos");
            System.out.println("[7] - Encerrar Programa");
            System.out.println("\nDigite uma opção:");
            opcao = scanner.nextInt();

            String nomeProfessor, departamento, nomeCurso, dataNascimento, cpf, nomeAluno;
            int idProfessor = 0, idCurso = 0, cargaHoraria, idAluno;

            switch (opcao) {
                case 1:
                try {
                    System.out.println("\nCadastrar Professor:");
                    System.out.println("Digite o ID do Professor:");
                    idProfessor = scanner.nextInt();
                    System.out.println("Digite o Nome do Professor:");
                    nomeProfessor = scanner.next();
                    System.out.println("Digite o Departamento do Professor:");
                    departamento = scanner.next();
                    new Professor(idProfessor, nomeProfessor, departamento, idCurso);
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar professor");
                }
                    break;
                case 2:
                try{
                    System.out.println("\nCadastrar Curso:");
                    System.out.println("Digite o ID do Curso:");
                    idCurso = scanner.nextInt();
                    System.out.println("Digite o Nome do Curso:");
                    nomeCurso = scanner.next();
                    System.out.println("Digite a Carga Horária do Curso:");
                    cargaHoraria = scanner.nextInt();
                    System.out.println("Digite o ID do Professor do Curso:");
                    idProfessor = scanner.nextInt();
                    Professor.verificaId(idProfessor);
                    Professor.buscaProfessor(idProfessor);
                    new Curso(idCurso, nomeCurso, cargaHoraria, idProfessor);
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar curso");
                }
                    break;
                case 3:
                try{
                    System.out.println("\nCadastrar Aluno:");
                    System.out.println("Digite o ID do Aluno:");
                    idAluno = scanner.nextInt();
                    System.out.println("Digite o Nome do Aluno:");
                    nomeAluno = scanner.next();
                    System.out.println("Digite a Data de Nascimento do Aluno:");
                    dataNascimento = scanner.next();
                    System.out.println("Digite o CPF do Aluno:");
                    cpf = scanner.next();
                    System.out.println("Digite o ID do Curso do Aluno:");
                    idCurso = scanner.nextInt();
                    Curso.verificaId(idCurso);
                    Curso.buscaCurso(idCurso);
                    new Aluno(idAluno, nomeAluno, dataNascimento, cpf, idCurso);
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar aluno");
                }
                    break;
                case 4:
                    System.out.println("\nListar Professores:");
                    if (Professor.professores.isEmpty()) {
                        System.out.println("\nNenhum Professor cadastrado.");
                        return;
                    }
                    for (Professor professor : Professor.professores) {
                        System.out.println("- ID: " + professor.idProfessor + " - Nome: " + professor.nomeProfessor + " - Departamento: " + professor.departamento);
                        System.out.println("- Cursos: " + Professor.cursoProfessores(professor.idProfessor) + " - Alunos: " + Curso.contarAlunosPorCurso(professor.idProfessor));
                    }
                    break;
                case 5:
                    System.out.println("\nListar Cursos:");
                    if (Curso.cursos.isEmpty()) {
                        System.out.println("\nNenhum Curso cadastrado.");
                        return;
                    }
                    for (Curso curso : Curso.cursos) {
                        System.out.println("- ID: " + curso.idCurso + " - Nome: " + curso.nomeCurso + " - Carga Horária: " + curso.cargaHoraria);
                        System.out.println("- Professor: " + Professor.buscaProfessor(curso.idProfessor).nomeProfessor + " - Alunos: " + Curso.contarAlunosPorCurso(curso.idCurso));
                    }
                    break;
                case 6:
                    System.out.println("\nListar Alunos:");
                    if (Aluno.alunos.isEmpty()) {
                        System.out.println("\nNenhum Alunos cadastrado.");
                        return;
                    }
                    for (Aluno aluno : Aluno.alunos) {
                        System.out.println("- ID: " + aluno.idAluno + " - Nome: " + aluno.nomeAluno + " - Data de Nascimento: " + aluno.dataNascimento + " - CPF: " + aluno.cpf);
                        System.out.println("- Curso: " + Curso.buscaCurso(aluno.idCurso).nomeCurso);
                    }
                    break;
                case 7:
                    System.out.println("\nEncerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (opcao != 7);
    }
}