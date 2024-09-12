import java.util.ArrayList;

public class CadastroPartido {
    public static ArrayList<Partido> partidos = new ArrayList<>();

    public boolean cadastraPartido(Partido partido, String nome, int numero) {
        boolean existe = false;
        if (numero != -1) {
            for (int i = 0; i < partidos.size(); i++) {
                if (numero == partidos.get(i).getNumero()) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                partido = new Partido(nome, numero);
                partidos.add(partido);
                System.out.println("1:" + partido.getNumero() + "," + partido.getNome());
                return true;
            }

        }
        return false;
    }

    public Partido consultaPartido(String nome) {

        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getNome().equals(nome)) {
                return partidos.get(i);
            }
        }
        return null;
    }

    public Partido consultaPartido(int numero) {
        for (int i = 0; i < partidos.size(); i++) {
            if (partidos.get(i).getNumero() == numero) {
                return partidos.get(i);
            }
        }
        return null;
    }

    public static void adicionaCandidato() {
        for (int i = 0; i < partidos.size(); i++) {
            for (int j = 0; j < Candidatura.candidatos.size(); j++) {
                if (ACMEVoting.pegarDoisPrimeirosDigitos(Candidatura.candidatos.get(i).getNumero()).equals(ACMEVoting.pegarDoisPrimeirosDigitos(partidos.get(i).getNumero()))) {
                    CadastroPartido.partidos.get(i).numerodecandidatos++;
                }
            }
        }
    }
}
