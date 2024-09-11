public class Partido {
    private int numero;
    private String nome;

    public Partido(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public void adicionaCandidato(){
        Candidato c = new Candidato();
    }
    public int getNumero() {
        return numero;
    }
}
