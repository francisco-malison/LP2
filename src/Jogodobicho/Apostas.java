package Jogodobicho;

import java.util.Arrays;
import java.util.Random;

public class Apostas {
    private int [] aposta;
    private boolean apostaRealizada = false;
    public final String [] tabelaDosBichos = new String[]
            {"1-Avestruz", "2-Águia", "3-Burro", "4-Borboleta", "5-Cachorro",
                    "6-Cabra", "7-Carneiro", "8-Camelo", "9-Cobra", "10-Coelho",
                    "11-Cavalo", "12-Elefante", "13-Galo", "14-Gato", "15-Jacaré",
                    "16-Leão", "17-Macaco", "18-Porco", "19-Pavão", "20-Peru",
                    "21-Touro", "22-Tigre", "23-Urso", "24-Veado", "25-Vaca"
            };

    public void setAposta(String nomes) {
        String[] nuBicho = nomes.split(" ");

        if (nuBicho.length == 5) {
            int[] numerosApostados;
            numerosApostados = new int[5];
            for (int i = 0; i < nuBicho.length; i++) {
                int numero = Integer.parseInt(nuBicho[i]);

                if (numero < 1 || numero > 25) {
                    System.out.println("Numero Invalido apostado");
                    apostaRealizada = false;
                    break;
                }
                if (numerosApostados[0] == numero || numerosApostados[1] == numero || numerosApostados[2] == numero || numerosApostados[3] == numero || numerosApostados[4] == numero) {
                    System.out.println("Numeros repetidos na Sequência");
                    apostaRealizada = false;
                    break;
                }
                numerosApostados[i] = numero;
                apostaRealizada = true;

            }

            if (apostaRealizada) {
                Arrays.sort(numerosApostados);
                aposta = numerosApostados;
                System.out.println("Aposta realizada com sucesso");
            }

        }else {
            System.out.println("quantidade de numeros apostados invalidos!");
        }
    }
    public void fazerApostasAleatoria(){
        Random random = new Random();
        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(25) + 1;
        }
        Arrays.sort(numeros);
        aposta = numeros;
        apostaRealizada = true;
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
        if (numeroDoBicho < 1 || numeroDoBicho > 25){
            return "Número invalido inserido";
        }
        String bicho = tabelaDosBichos[numeroDoBicho-1];
        return bicho;
    }
    //public String [] verTabela(){
    //    return tabelaDosBichos;
    //}

    public String verResultado(){
        Random random = new Random();
        if (apostaRealizada){
            apostaRealizada = false;
            int numero = 1 + random.nextInt(25);
            if (aposta[0] == numero || aposta[1] == numero || aposta[2] == numero || aposta[3] == numero || aposta[4] == numero){
                return "Deu "+ getBicho(numero) + ", Vôce Ganhou!!!";
            }
            return "Deu " + getBicho(numero) + ", Vôce perdeu";
        }else{
            return "faça uma aposta";
        }
    }
}
