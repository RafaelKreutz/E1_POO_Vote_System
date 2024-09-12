import java.util.ArrayList;

public class Candidatura {
    public static ArrayList<Candidato> candidatos = new ArrayList<>();

    public boolean cadastraCandidato(Candidato candidato, int numero, String nome, String munincipio, int votos, String prefeitoouvereador) {
        boolean existe = false;
        if (numero != -1) {
            for (int i = 0; i < candidatos.size(); i++) {
                if (numero == candidatos.get(i).getNumero()) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                candidato = new Candidato(nome, munincipio, numero, votos, prefeitoouvereador);
                candidatos.add(candidato);
                System.out.println("2:" + numero + "," + nome + "," + munincipio);

                return true;
            }

        }
        return false;
    }

    public Candidato consultaCandidato(int numero) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() == numero) {
                return candidatos.get(i);
            }
        }
        return null;
    }
}
