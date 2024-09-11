public class Candidato {
    private String nome;
    private String munincipio;
    private int numero;
    private int votos;
    public String prefeitoouvereador;

    public Candidato(String nome, String municipio, int numero, int votos, String prefeitoouvereador) {
        this.nome = nome;
        this.munincipio = municipio;
        this.numero = numero;
        this.votos = votos;
        this.prefeitoouvereador = prefeitoouvereador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunincipio() {
        return munincipio;
    }

    public void setMunincipio(String munincipio) {
        this.munincipio = munincipio;
    }

    public int getNumero() {
        return numero;
    }

    public String getPrefeitoOuVereador() {
        return prefeitoouvereador;
    }

    public void setPrefeitoOuVereador(String prefeitoouvereador) {
        this.prefeitoouvereador = prefeitoouvereador;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

}
