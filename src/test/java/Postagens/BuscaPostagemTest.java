package Postagens;

import com.api.postagens.Postagens;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BuscaPostagemTest {

  /* {
  *  "userId": 1,
  *   "id": 3,
  *  "title": "ea molestias quasi exercitationem repellat qui ipsa sit aut",
  *  "body": "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
     }, */

    @Test
    public void testBuscaPostagemId(){
        String id = "2";
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/" + id);
        assertEquals(200, response.getStatusCode());

        int userId = response.jsonPath().getInt("userId");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");

        //Trasnforma o resultado em um objeto postagens
        Gson gson = new Gson();
        Postagens postagem = gson.fromJson(response.body().asString(), Postagens.class);


        System.out.println("userId: " + userId);
        System.out.println("Id: " + id);
        System.out.println("titulo: " + title);
        System.out.println("mensagem: " + body);
    }
}


/*  TESTE DA COBLI 
package Cobli;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuscaVeiculosTest {

    @Test
    public void testBuscaVeiculos() {
        String baseUrl = "https://api.cobli.co/public/v1";
        String endpoint = "/paths";
        String startDate = "2022-08-13T14:46:03.991";
        String endDate = "2022-08-22T14:46:03.991";
        int limit = 2000;
        int page = 1;
        String deviceIds = "18923678716,176317826,2938472837,123987192,12310924";
        String groups = "Grupo1, grupo_2, Grupo 3";
        String licensePlates = "ABC1234, ABC1D23";
        String timezone = "America/Sao_Paulo";
        String apiKey = "SuaApiKeyAqui"; // Substitua "SuaApiKeyAqui" pela sua chave de API

        Response response = RestAssured.given()
                .header("x-api-key", apiKey)
                .queryParam("startDate", startDate)
                .queryParam("endDate", endDate)
                .queryParam("limit", limit)
                .queryParam("page", page)
                .queryParam("deviceIds", deviceIds)
                .queryParam("groups", groups)
                .queryParam("licensePlates", licensePlates)
                .queryParam("timezone", timezone)
                .get(baseUrl + endpoint);

        assertEquals(200, response.getStatusCode());

        // Exemplo de como você pode acessar os atributos da resposta
        // Lembre-se de adaptar conforme a estrutura da resposta da API Cobli
        // Aqui, estamos apenas imprimindo os atributos para demonstração
        String responseBody = response.getBody().asString();
        System.out.println("Resposta da API: " + responseBody);

        // Você pode mapear o JSON para uma classe Java usando o Gson, assim como você fez no teste anterior
        // Exemplo:
        Gson gson = new Gson();
        // SuaClasseVeiculo veiculo = gson.fromJson(responseBody, SuaClasseVeiculo.class);
        // Faça o mapeamento da classe de acordo com a estrutura da resposta da API Cobli
    }
}


*/
