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
    private final String nomeArquivoEntrada = "input.txt";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "output.txt";  // Nome do arquivo de saida de dados
    private CadastroPartido cadastroPartido = new CadastroPartido();
    private Candidatura candidatura = new Candidatura();
    private Partido partido = new Partido(null,0);

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
        mostrarVotosPrefeito();
        mostrarPartidoComMaisCandidatos();
        mostrarVereadorEPrefeitoMaisVotados();
    }

    public void inicializarPartido() {
        boolean parar = true;
        while (parar) {
            int numero = entrada.nextInt();
            entrada.nextLine();
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
        //CadastroPartido.adicionaCandidato();
        //Candidatura.candidatos.get(i).setVotos(Candidatura.candidatos.get(i).getVotos() + votos);
        boolean parar = true;
        String prefeitoouvereador = null;
        while (parar) {
            int numero = entrada.nextInt();
            entrada.nextLine();
            if (numero == -1) {
                parar = false;
            }
            else {
                //for (int i = 0; i < CadastroPartido.partidos.size(); i++) {
                 //   if(numero == CadastroPartido.partidos.get(i).getNumero()){
                  //      int temp = partido.getNumerodecandidatos();
                  //     temp = temp + 1;
                     //   partido.setNumerodecandidatos(temp);
                   // }
               // }
                if (numero > 99 ) {
                    prefeitoouvereador = "vereador";
                }
                else {
                    prefeitoouvereador = "prefeito";
                }
                String nome = entrada.nextLine();
                String munincipio = entrada.nextLine();
                candidatura.cadastraCandidato(null,  numero,nome,munincipio,0, prefeitoouvereador);
                for (int i = 0; i < CadastroPartido.partidos.size(); i++) {
                    if(ACMEVoting.pegarDoisPrimeirosDigitos(numero).equals(ACMEVoting.pegarDoisPrimeirosDigitos(CadastroPartido.partidos.get(i).getNumero()))){
                        CadastroPartido.partidos.get(i).numerodecandidatos++;
                    }
                }

            }
        }

    }
    public void adicionarVotos() {
        boolean parar = true;
        while (parar) {
            int numero = entrada.nextInt();
            entrada.nextLine();
            if(numero != -1) {
                String munincipio = entrada.nextLine();
                int votos = entrada.nextInt();
                entrada.nextLine();
                boolean candidatoencontrado = false;
                for (int i = 0; i < Candidatura.candidatos.size(); i++) {
                    if (Candidatura.candidatos.get(i).getNumero() == numero) {
                        Candidatura.candidatos.get(i).setVotos(Candidatura.candidatos.get(i).getVotos() + votos);
                        System.out.println("3:" + Candidatura.candidatos.get(i).getNumero() + "," + Candidatura.candidatos.get(i).getMunincipio() + "," + Candidatura.candidatos.get(i).getVotos());
                        candidatoencontrado = true;
                    }
                }
                if (!candidatoencontrado) {
                    System.out.println("3:Nenhum partido encontrado.");
                }
            }
            else{
                parar = false;
            }

        }
    }

    public void buscarPartido() {
            int numero = entrada.nextInt();
            entrada.nextLine();
            Partido partido = cadastroPartido.consultaPartido(numero);
            if (partido != null) {
                System.out.println("4:" + partido.getNumero() + "," + partido.getNome());
            } else {
                System.out.println("4:Nenhum partido encontrado.");
            }
    }
    public void buscarCandidato() {
        int numero = entrada.nextInt();
        entrada.nextLine();
        String munincipio = entrada.nextLine();
        boolean candidatoencontrado = false;
        for (int i = 0; i < Candidatura.candidatos.size(); i++) {
            if (Candidatura.candidatos.get(i).getNumero() == numero) {
                candidatoencontrado = true;
                System.out.println("5:" + Candidatura.candidatos.get(i).getNumero() + "," + Candidatura.candidatos.get(i).getNome() + "," + Candidatura.candidatos.get(i).getMunincipio() + "," + Candidatura.candidatos.get(i).getVotos() );
            }
        }
        if (!candidatoencontrado) {
            System.out.println("5:Nenhum candidato encontrado.");
        }
    }
    public void mostrarVotosPrefeito() {
        String nome = entrada.nextLine();
        boolean prefeitosencontrados = false;

        for (int i = 0; i < CadastroPartido.partidos.size(); i++) {
            //Candidatura.candidatos.get(i).getPrefeitoOuVereador().equalsIgnoreCase("prefeito") &&
            if(nome.equalsIgnoreCase(CadastroPartido.partidos.get(i).getNome())) {
                prefeitosencontrados = true;
                //Partido partido = cadastroPartido.consultaPartido(Candidatura.candidatos.get(i).getNumero());
                Candidato candidato = candidatura.consultaCandidato(CadastroPartido.partidos.get(i).getNumero());
                System.out.println("6:" + CadastroPartido.partidos.get(i).getNome() + "," + candidato.getNumero() + "," + candidato.getNome() + "," + candidato.getMunincipio() + "," + candidato.getVotos() );
            }
        }
        if (!prefeitosencontrados) {
            System.out.println("6:Nenhum partido encontrado.");
        }

    }

    public void mostrarPartidoComMaisCandidatos() {
        Partido maiorpartido = null;
        int maior = Integer.MIN_VALUE;
        int candidatospartido = 0;




        for (int i = 0; i < CadastroPartido.partidos.size(); i++) {
            for (int j = 0; j < CadastroPartido.partidos.size(); j++) {
                if (CadastroPartido.partidos.get(i).numerodecandidatos >= CadastroPartido.partidos.get(j).numerodecandidatos) {
                    maiorpartido = CadastroPartido.partidos.get(i);
                }
            }

        }
        if (maior == 0) {
            System.out.println("7:Nenhum partido com candidatos.");
        }
        else{
            System.out.println("7:" + maiorpartido.getNumero() + "," + maiorpartido.getNome() + "," + maiorpartido.numerodecandidatos);
        }
    }
    public void mostrarVereadorEPrefeitoMaisVotados() {
        if (Candidatura.candidatos.isEmpty()) {
            System.out.println("8:Nenhum candidato encontrado.");
        } else {
            Candidato prefeitoComMaisVotos = null;
            Candidato vereadorComMaisVotos = null;

            for (int i = 0; i < Candidatura.candidatos.size(); i++) {
                Candidato candidatoAtual = Candidatura.candidatos.get(i);

                if (candidatoAtual.prefeitoouvereador.equalsIgnoreCase("prefeito")) {
                    if (prefeitoComMaisVotos == null || candidatoAtual.getVotos() > prefeitoComMaisVotos.getVotos()) {
                        prefeitoComMaisVotos = candidatoAtual;
                    }
                } else if (candidatoAtual.prefeitoouvereador.equalsIgnoreCase("vereador")) {
                    if (vereadorComMaisVotos == null || candidatoAtual.getVotos() > vereadorComMaisVotos.getVotos()) {
                        vereadorComMaisVotos = candidatoAtual;
                    }
                }
            }
            if (prefeitoComMaisVotos != null) {
                System.out.println("8:" + prefeitoComMaisVotos.getNumero() + "," + prefeitoComMaisVotos.getNome() + "," + prefeitoComMaisVotos.getMunincipio() + "," + prefeitoComMaisVotos.getVotos());
            } else {
                System.out.println("Nenhum candidato a prefeito encontrado.");
            }

            if (vereadorComMaisVotos != null) {
                System.out.println("8:" + vereadorComMaisVotos.getNumero() + "," + vereadorComMaisVotos.getNome() + "," + vereadorComMaisVotos.getMunincipio() + "," + vereadorComMaisVotos.getVotos());
            } else {
                System.out.println("Nenhum candidato a vereador encontrado.");
            }
        }
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
    public static String pegarDoisPrimeirosDigitos(int numero) {
        String numeroString = String.valueOf(numero); // Converte o número em uma string
        if (numeroString.length() >= 2) {
            return numeroString.substring(0, 2); // Retorna os dois primeiros caracteres
        } else {
            return numeroString; // Se o número tiver menos de 2 dígitos, retorna o número inteiro
        }
    }
}


