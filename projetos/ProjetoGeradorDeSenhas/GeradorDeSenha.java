import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorDeSenha{
    private  static final String CARACTERES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+-=[]|,./?><";
    public static String gerarSenha(int comprimento){
        SecureRandom geradorDeNumero = new  SecureRandom();
        StringBuilder senha = new StringBuilder(comprimento);

        for (int i = 0; i < comprimento; i++){
            int indice = geradorDeNumero.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(indice));
        }
        return senha.toString();
    }

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);


        System.out.println("Qual o tamanho desejado?");
        int comprimentoSenha = ler.nextInt();

        String senha = gerarSenha(comprimentoSenha);
        System.out.println("Senha gerada: " + senha);
    }
}