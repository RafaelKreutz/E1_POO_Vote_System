import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMEVoting {
    private Scanner entrada = new Scanner(System.in);  // Atributo para entrada padrao (teclado)
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "entrada.txt";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "saida.txt";  // Nome do arquivo de saida de dados
    private CadastroPartido cadastroPartido = new CadastroPartido();
    private Candidatura candidatura = new Candidatura();

    public ACMEVoting() {
        redirecionaEntrada();    // Redireciona Entrada para arquivos
        redirecionaSaida();    // Redireciona Saida para arquivos
    }

    public void executar() {
        inicializarPartido();
        inicializarCandidato();
        adicionarVotos();
        buscarPartido();
        buscarCandidato();
    }

    public void inicializarPartido() {
        boolean parar = true;
        while (parar) {
            int numero = entrada.nextInt();
            if (numero == -1) {
                parar = false;
            }
            else {
                String nome = entrada.nextLine();
                cadastroPartido.cadastraPartido(null, nome, numero);
            }
        }
    }
    public void inicializarCandidato() {
        boolean parar = true;
        String prefeitoouvereador = null;
        while (parar) {
            int numero = entrada.nextInt();
            if (numero == -1) {
                parar = false;
            }
            else {
                if (numero > 99 ) {
                    prefeitoouvereador = "vereador";
                }
                else {
                    prefeitoouvereador = "prefeito";
                }
                String nome = entrada.nextLine();
                String munincipio = entrada.nextLine();
                candidatura.cadastraCandidato(null, numero,nome,munincipio,0, prefeitoouvereador);

            }
        }

    }
    public void adicionarVotos() {
        boolean parar = true;
        while (parar) {
            int numero = entrada.nextInt();
            if(numero != -1) {
                String munincipio = entrada.nextLine();
                int votos = entrada.nextInt();
                boolean candidatoencontrado = false;
                for (int i = 0; i < Candidatura.candidatos.size(); i++) {
                    if (Candidatura.candidatos.get(i).getNumero() == numero) {
                        Candidatura.candidatos.get(i).setVotos(Candidatura.candidatos.get(i).getVotos() + votos);
                        System.out.println("4:" + Candidatura.candidatos.get(i).getNumero() + "," + Candidatura.candidatos.get(i).getMunincipio() + "," + Candidatura.candidatos.get(i).getVotos());
                        candidatoencontrado = true;
                    }
                }
                if (!candidatoencontrado) {
                    System.out.println("4:Nenhum partido encontrado.");
                }
            }
            parar = false;
        }
    }

    public void buscarPartido() {
            int numero = entrada.nextInt();
            Partido partido = cadastroPartido.consultaPartido(numero);
            if (partido != null) {
                System.out.println("4:" + partido.getNumero() + "," + partido.getNome());
            } else {
                System.out.println("4:Nenhum partido encontrado.");
            }
    }
    public void buscarCandidato() {
        int numero = entrada.nextInt();
        String munincipio = entrada.nextLine();
        boolean candidatoencontrado = false;
        for (int i = 0; i < Candidatura.candidatos.size(); i++) {
            if (Candidatura.candidatos.get(i).getNumero() == numero) {
                candidatoencontrado = true;
                System.out.println(Candidatura.candidatos.get(i).getNumero() + "," + Candidatura.candidatos.get(i).getNome() + "," + Candidatura.candidatos.get(i).getMunincipio() + "," + Candidatura.candidatos.get(i).getVotos() );
            }
        }
        if (!candidatoencontrado) {
            System.out.println("5:Nenhum candidato encontrado.");
        }
    }
    public void mostrarVotosPrefeito() {
        String nome = entrada.nextLine();
        boolean prefeitosencontrados = false;

        for (int i = 0; i < Candidatura.candidatos.size(); i++) {
            if(Candidatura.candidatos.get(i).getPrefeitoOuVereador().equalsIgnoreCase("prefeito") && nome.equalsIgnoreCase(Candidatura.candidatos.get(i).getNome())) {
                prefeitosencontrados = true;
                Partido partido = cadastroPartido.consultaPartido(Candidatura.candidatos.get(i).getNumero());
                System.out.println(partido.getNome() + "," + Candidatura.candidatos.get(i).getNumero() + "," + Candidatura.candidatos.get(i).getNome() + "," + Candidatura.candidatos.get(i).getMunincipio() + "," + Candidatura.candidatos.get(i).getVotos() );
            }
        }
        if (!prefeitosencontrados) {
            System.out.println("6:Nenhum partido encontrado.");
        }

    }
    public void mostrarPartidoComMaisCandidatos() {

    }





    // Redireciona Entrada de dados para arquivos em vez de teclado
    // Chame este metodo para redirecionar a leitura de dados para arquivos
    private void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Redireciona Saida de dados para arquivos em vez da tela (terminal)
    // Chame este metodo para redirecionar a escrita de dados para arquivos
    private void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
    }

    // Restaura Entrada padrao para o teclado
    // Chame este metodo para retornar a leitura de dados para o teclado
    private void restauraEntrada() {
        entrada = new Scanner(System.in);
    }

    // Restaura Saida padrao para a tela (terminal)
    // Chame este metodo para retornar a escrita de dados para a tela
    private void restauraSaida() {
        System.setOut(saidaPadrao);
    }

}

}
