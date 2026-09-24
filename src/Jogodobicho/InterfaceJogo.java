package Jogodobicho;

import java.util.Scanner;
public class InterfaceJogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Apostas apostas = new Apostas();

        String menu = "1-Apostar;\n" +
                "2-Apostar Aleatoriamente;\n" +
                "3-Olhar a Aposta;\n" +
                "4-Olhar Bicho;\n" +
                "5-Ver Tabela;\n" +
                "6-Ver Resultado;\n" +
                "7-Sair";
        final int APOSTAR = 1;
        final int APOSTA_ALEATORIA = 2;
        final int VERAPOSTA = 3;
        final int OLHARBICHO = 4;
        final int VERTABELA = 5;
        final int VERRESULTADO = 6;
        final int SAIR = 7;

        int op;

        do {
            op = leInt(menu, sc);
            switch (op) {
                case APOSTAR:
                    fazerAposta(sc, apostas);
                    break;
                case APOSTA_ALEATORIA:
                    apostaAleatoria();
                    break;
                case VERAPOSTA:
                    verAposta(apostas);
                    break;
                case OLHARBICHO:
                    verBicho(sc, apostas);
                    break;
                case VERTABELA:
                    tabelaBosBicho();
                    break;
                case VERAPOSTA:
                    resultadoDoBicho();
                    break;
                case SAIR:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (op != SAIR);
        sc.close();
    }

    private static void fazerAposta(Scanner sc, Apostas apostas) {
        System.out.println("faça a aposta de 5 numeros entre 1 e 25, cada um separado por expaço");
        String entrada = sc.nextLine();
        apostas.setAposta(entrada);
    }

    private static void verAposta(Apostas apostas){
        String bichosApostados = apostas.getAposta();
        System.out.println(bichosApostados);

    }

    private static void verBicho(Scanner sc, Apostas apostas){
        System.out.println("Digite um numero");
        int numeroDoBicho = sc.nextInt();
        System.out.println(apostas.getBicho(numeroDoBicho));
        }

    private static int leInt(String msg, Scanner sc){
        System.out.println(msg);
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }
}