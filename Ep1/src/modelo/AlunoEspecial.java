package modelo;

public class AlunoEspecial extends Aluno {
	private static final long serialVersionUID = 1L;

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
        this.setEspecial(true); // usa setter
    }

    @Override
    public void matricularEmTurma(Turma turma) {
        if (getTurmasMatriculadas().size() >= 2) {
            System.out.println("Aluno especial só pode cursar no máximo 2 disciplinas.");
        } else {
            getTurmasMatriculadas().add(turma);
            System.out.println("Aluno especial matriculado na turma.");
        }
    }
}
