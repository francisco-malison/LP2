import java.util.Arrays;

public class Apostas {
    private int [] aposta;
    private boolean apostaRealizada = false;

    public void setAposta(String [] nuBicho){
        int [] numerosApostados;
        numerosApostados = new int[5];
        for(int i = 0; i < nuBicho.length; i++){
            int numero = Integer.parseInt(nuBicho[i]);

            if(numero < 1 || numero > 25){
                System.out.println("Numero Invalido apostado");
                break;
            }
            if(numerosApostados[0] == numero || numerosApostados[1] == numero || numerosApostados[2]== numero || numerosApostados[3] == numero || numerosApostados[4] == numero){
              System.out.println("Numeros repetidos na Sequência");
              break;
            }
            numerosApostados[i] = numero;

        }
        Arrays.sort(numerosApostados);
        this.aposta = numerosApostados;
        apostaRealizada = true;
        System.out.println("Aposta realizada com sucesso");
    }

    public String getAposta(){
        String resposta ="";
        if(apostaRealizada){
            for (int j : aposta) {
                resposta += getBicho(j) + " ";
            }
        }else {
            resposta = "Faça a aposta antes!";
        }
        return resposta.trim();
    }

    public String getBicho(int numeroDoBicho){
        String [] tabelaDosBichos = new String[]
                {"1-Avestruz", "2-Águia", "3-Burro", "4-Borboleta", "5-Cachorro",
                        "6-Cabra", "7-Carneiro", "8-Camelo", "9-Cobra", "10-Coelho",
                        "11-Cavalo", "12-Elefante", "13-Galo", "14-Gato", "15-Jacaré",
                        "16-Leão", "17-Macaco", "18-Porco", "19-Pavão", "20-Peru",
                        "21-Touro", "22-Tigre", "23-Urso", "24-Veado", "25-Vaca"
                };

        String bicho = tabelaDosBichos[numeroDoBicho-1];
        return bicho;
    }
}
