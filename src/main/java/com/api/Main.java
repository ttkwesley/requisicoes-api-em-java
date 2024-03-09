package com.api;

import com.api.postagens.BuscaPostagens;
import com.api.postagens.PostagensClient;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        // Instancia // Cria o localhost
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Configuração da rota /postagens
        server.createContext("/postagens", (exchange -> {
            PostagensClient postagensClient = new PostagensClient();
            String respostaFromApi = postagensClient.fetchPostagens();

            //
            exchange.sendResponseHeaders(200, respostaFromApi.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(respostaFromApi.getBytes());
            os.close();
        }));

        server.createContext("/busca/postagem", (exchange->{
            String path = exchange.getRequestURI().getPath();
            String[] pathParts = path.split("/");
            int id = Integer.parseInt(pathParts[pathParts.length - 1]);

            //faz a busca pelo id
            BuscaPostagens buscaPostagens = new BuscaPostagens();
            String respostaFromApi = buscaPostagens.buscaPostagemId(id);

            exchange.sendResponseHeaders(200, respostaFromApi.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(respostaFromApi.getBytes());
            os.close();
        }));

        //Starta o server
        server.start();
        System.out.println("Servidor iniciado na porta 8080...");

        }
    }