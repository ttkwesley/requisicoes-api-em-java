package com.api.postagens;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import java.io.IOException;

// Aqui é o controller de postagens
public class PostagensClient {
    public String fetchPostagens() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Cria um cliente HTTP
        HttpClient httpClient = new HttpClient();

        // Cria uma requisição GET
        GetMethod request = new GetMethod(url);

        try {
            // Executa a requisição
            int statusCode = httpClient.executeMethod(request);

            // Verifica se a requisição foi bem-sucedida (código de status 200)
            if (statusCode == HttpStatus.SC_OK) {
                // Lê a resposta
                String responseBody = request.getResponseBodyAsString();

                // Retorna o corpo da resposta
                return responseBody;
            } else {
                System.err.println("Falha na requisição: " + request.getStatusLine());
                // Em caso de falha, retorna uma string vazia ou null, dependendo do seu caso de uso
                return "";
            }
        } catch (IOException e) {
            // Trata exceções de I/O
            throw new RuntimeException(e);
        } finally {
            // Libera os recursos
            request.releaseConnection();
        }
    }
}

