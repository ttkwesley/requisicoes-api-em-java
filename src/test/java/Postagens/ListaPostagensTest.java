package Postagens;

import com.api.postagens.Postagens;
import io.restassured.RestAssured;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import io.restassured.response.Response;

public class ListaPostagensTest {

    /* {
    *   "userId": 1,
    *   "id": 1,
    *   "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    *   "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    *    }, */

    @Test
    public void testListaPostagem(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        // Verifica se a resposta foi bem-sucedida (código de status 200)
        assertEquals(200, response.getStatusCode());

        // Converte a resposta em uma lista de postagens
        Postagens[] postagens = response.getBody().as(Postagens[].class);

        System.out.println("Lista de Postagens:");
        for (Postagens postagem : postagens) {
            System.out.println("UserId: " + postagem.getUserId());
            System.out.println("Id: " + postagem.getId());
            System.out.println("Título: " + postagem.getTitle());
            System.out.println("Corpo: " + postagem.getBody());
            System.out.println(); // Adiciona uma linha em branco para separar as postagens
        }

        //tamanho do arrays
        int tamanho = postagens.length;

        // Verifica se a lista de postagens não está vazia
        assertNotEquals(0, postagens.length);

        System.out.println(tamanho);
    }
}
