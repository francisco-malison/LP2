import java.util.Scanner;
public class InterfaceJogo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Apostas apostas = new Apostas();

        String menu = "1-Apostar;\n"+
                      "2-Ver Aposta;\n"+
                      "3-Olhar Bicho pelo numero;\n"+
                      "4-Sair";
        final int APOSTAR = 1;
        final int VERAPOSTA = 2;
        final int OLHARBICHO = 3;
        final int SAIR = 4;

        int op;

        do {
            op = leInt(menu,sc);
            switch (op){
                case APOSTAR:
                    fazerAposta(sc, apostas);
                    break;
                case VERAPOSTA:
                    verAposta(apostas);
                    break;
                case OLHARBICHO:
                    verBicho(sc,apostas);
                    break;
                case SAIR:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }while(op != SAIR);
        sc.close();
    }

    private static void fazerAposta(Scanner sc, Apostas apostas){
        System.out.println("faça a aposta de 5 numeros entre 1 e 25, cada um separado por expaço");
        String entrada = sc.nextLine();
        String [] bichosApostados = entrada.split(" ");

        if(bichosApostados.length != 5){
            System.out.println("quantidade de numeros apostados invalidos!");
        }else{
            apostas.setAposta(bichosApostados);
        }
    }
    private static void verAposta(Apostas apostas){
        String [] bichosApostados = apostas.getAposta();
        System.out.println(bichosApostados);

    }
    private static void verBicho(Scanner sc, Apostas apostas){
        int numeroDoBicho = sc.nextInt();
        if(numeroDoBicho < 1 || numeroDoBicho > 25){
            System.out.println("Numero invalido");
        }else {
            String bicho = apostas.getBicho(numeroDoBicho);
            System.out.println(bicho);
        }
    }
    private static int leInt(String msg, Scanner scam){
        System.out.println(msg);
        int op = scam.nextInt();
        scam.nextLine();
        return op;
    }
}
