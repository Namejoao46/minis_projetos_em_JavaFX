import java.util.ArrayList;
//Random faz o aleatorio
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        ArrayList<String> palavrasSecretas = new ArrayList<>();
        palavrasSecretas.add("cobra");
        palavrasSecretas.add("elefante");
        palavrasSecretas.add("girafa");

        //Random = aleatorio
        Random random = new Random();
        int tamanhoDoArray = palavrasSecretas.size(); // verifica o tamanho do Array
        int indicePalavra = random.nextInt(tamanhoDoArray); //Escolhe aleatoriamente a palavra e passa seu indice (0,1 ou 2)
        String palavraSecreta = palavrasSecretas.get(indicePalavra); //Passa a palavra encontrada

        //Array char para cada letra da palavra
        ArrayList<Character> letrasDescobertas = new ArrayList<>();

        //percorre o Array letrasDescobertas e aonde tiver letra coloca um '_'
        for (int i = 0; i <palavraSecreta.length(); i++){
            letrasDescobertas.add('_');
        }

        int tentativas = 6;
        boolean palavraFoiDescoberta = false;


        //Aqui inicia o programa
        // Enquanto a palavraFoiDescoberta não for descoberta
        // ou ainda houver tentativas para descobrir o programa continuará
        while (!palavraFoiDescoberta && tentativas > 0){
            System.out.println("Palavra: " + letrasDescobertas); //Mostra as letras descobertas e se nao tiver mostra o _
            System.out.println("Chute uma letra: ");
            char chute = ler.next().charAt(0);

            boolean acertou = false;

            for(int i = 0; i < palavraSecreta.length(); i++){// passa por cada letra para saber se esta certo o chute
                if(palavraSecreta.charAt(i) == chute){//Verifica se a letra no indice condiz com o chute
                    letrasDescobertas.set(i, chute);// Se for igual, eu coloco na lista de descobertas, na posicao certa
                    acertou = true;
                }
            }

            if(!acertou){
                tentativas--;
                System.out.println("Letra incorreta! Você tem mais " + tentativas + " tentativas.");
            }

            //Verifica se a palavra foi completamente descoberta
            palavraFoiDescoberta = !letrasDescobertas.contains('_');
        }

        if (palavraFoiDescoberta){
            System.out.println("Parabéns, você acertou! A palavra era: " + palavraSecreta);
        } else {
            System.out.println("Você perdeu! a palavra era: " + palavraSecreta);
        }

        ler.close();
    }
}