import java.util.LinkedList;

public class Partido {
    private int numero;
    private String nome;
    public int numerodecandidatos;

    public Partido(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setNumerodecandidatos(int numerodecandidatos) {
        this.numerodecandidatos = numerodecandidatos;
    }
    public int getNumerodecandidatos() {
        return numerodecandidatos;
    }
    /*public void adicionaCandidato(Candidato candidato, Partido partido) {
        if(candidato.getNumero() == partido.getNumero()){
            partido.setNumerodecandidatos(getNumerodecandidatos() + getNumerodecandidatos() + 1);
        }
    }*/
}