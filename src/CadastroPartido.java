import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPartido {
    public Scanner entrada = new Scanner(System.in);
    public ArrayList<Partido> partidos;
    public boolean cadastraPartido(Partido partido) {

        return false;
    }

    public Partido consultaPartido(String nome){
        return null;
    }
    public Partido consultaPartido(int numero){
        return null;
    }

    public void cadastraPartido(boolean cadastraPartido){
        boolean existe = false;
        int numero;
        String nome;
        System.out.println("Digite o nome do Partido:");
        nome = entrada.nextLine();
        System.out.println("Digite o número do partido");
        numero = entrada.nextInt();
        for (int i = 0; i < partidos.size(); i++) {
            if(numero == partidos.get(i).getNumero()){
                existe = true;
            }
        }
        if (!existe) {
            Partido partido = new Partido(nome,numero);
            partidos.add(partido);
        }
        else{
            System.out.println("Partido com esse numero já existe");
        }
    }
}
