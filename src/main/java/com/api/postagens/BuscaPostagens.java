package com.api.postagens;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class BuscaPostagens {
    public String buscaPostagemId(int id){
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;

        //Cria o cliente Http
        HttpClient httpClient = new HttpClient();

        //Requisição get
        GetMethod request = new GetMethod(url);

        try {
            int statusCode = httpClient.executeMethod(request);
            if (statusCode == HttpStatus.SC_OK ){
                return request.getResponseBodyAsString();
            }else{
                return "Falha na requisição" + request.getStatusLine();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            request.releaseConnection();
        }
        }
    }

