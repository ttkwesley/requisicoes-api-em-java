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
