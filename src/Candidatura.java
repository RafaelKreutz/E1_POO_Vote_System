import java.util.ArrayList;

public class Candidatura {
    public static ArrayList<Candidato> candidatos;

    public boolean cadastraCandidato(Candidato candidato, int numero, String nome, String munincipio, int votos, String prefeitoouvereador) {
        boolean existe = false;
        if (numero != -1) {
            for (int i = 0; i < candidatos.size(); i++) {
                if (numero == candidatos.get(i).getNumero()) {
                    existe = true;
                }
            }
            if (!existe) {
                candidato = new Candidato(nome, munincipio, numero, votos, prefeitoouvereador);
                candidatos.add(candidato);
                System.out.println("1:" + numero + "," + nome + "," + munincipio);
                return true;
            }

        }
        return false;
    }
}
