import java.net.URL;                        //Representa endereço web
import java.net.URLEncoder;                 //Codifica strings para uso via HTTP
import java.net.http.HttpClient;            //Envia e recebe dados via HTTP
import java.net.http.HttpRequest;           //Representa uma solicitação HTTP
import java.net.http.HttpResponse;          //Repesenta uma resposta HTTP
import java.net.URI;
import java.nio.charset.StandardCharsets;   //Define padrões de codificação de caracters
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

import java.util.Scanner;

public class InformacoesClimaticas {

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o nome da cidade");
        String cidade = ler.nextLine();

        try{
            String dadosClimaticos = getDadosClimaticos(cidade);//retorna json

            // Codigo 1006 segnifica loc nao encontrada
            if (dadosClimaticos.contains("\"code\":1006")){
                System.out.println("Localização não encontrada. Por favor, tente novamente.");
            } else {
                imprimirDadosClimaticos(dadosClimaticos);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getDadosClimaticos(String cidade) throws Exception {

        //leio o arquivo com a chave; obs; o trim retira espacos que talvez tenha sem necessidade
        String apiKey = Files.readString( Paths.get("api-key.txt")).trim();

        String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);

        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;
        HttpRequest request = HttpRequest.newBuilder() //comeca a construcao de uma nova solicitacao http
                .uri(URI.create(apiUrl)) // este metodo define o uri da solicitacao http. exemplo; chamo joao
                .build(); // finaliza a construcao da solicitacao http. ex; aonde mora joao

        // criar obj envia solicitacoes http e receber respostas http, para acessar o site Weatherapi
        HttpClient client = HttpClient.newHttpClient();

        //Agora vamos envia requisicoes http e receber, ou seja se comunicar com o site
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body(); //retorna uma string com os dados obtidos da api
    }

    //metodo para imprimir os dados de forma organizada
    public static void imprimirDadosClimaticos(String dados){
        //System.out.println("Dados originais (JSON) obtidos no site metereologicos" + dados);

        JSONObject dadosJson = new JSONObject(dados);
        JSONObject informacoesMetereologicas = dadosJson.getJSONObject("current");

        //Extrair os dados da loc
        String cidade = dadosJson.getJSONObject("location").getString("name");
        String pais = dadosJson.getJSONObject("location").getString("country");

        //extrai dados adcionais
        String condicaoTempo = informacoesMetereologicas.getJSONObject("condition").getString("text");
        int umidade = informacoesMetereologicas.getInt("humidity");
        float velocidadeVento = informacoesMetereologicas.getFloat("wind_kph");
        float pressaoAtmosferica = informacoesMetereologicas.getFloat("pressure_mb");
        float sensacaoTermica = informacoesMetereologicas.getFloat("feelslike_c");
        float temperaturaAtual = informacoesMetereologicas.getFloat("temp_c");

        //extra a data e hora da string retornada
        String dataHora = informacoesMetereologicas.getString("last_updated");

        System.out.println("Informações Meteorológicas para " + cidade + ", " + pais);
        System.out.println("Data e hora: " + dataHora);
        System.out.println("Temperatura Atual: " + temperaturaAtual + "°C");
        System.out.println("Sensação Térmica: " + sensacaoTermica + "°C");
        System.out.println("Condição do Tempo: " + condicaoTempo);
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Velocidade do vento: " + velocidadeVento + " km/h");
        System.out.println("Pressão Atmosférica: " + pressaoAtmosferica + " mb");
    }
}