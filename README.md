<h3>Teste de requisiçoes para uma api externa</h3>
<p>A aplicação faz requisiçoes para 2 end points da api JsonPlaceHolder <br>
<a href="https://jsonplaceholder.typicode.com">Sobre o JsonPlaceHolder</a>

<h3>EndPoints</h3>
<p>http://localhost:8080/postagens</p>
<p>Retorna uma lista de postagens</p>

```
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
  },
  {
    "userId": 1,
    "id": 2,
    "title": "qui est esse",
    "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
  },
  { ....
```
<h3>EndPoints</h3>
<p>http://localhost:8080/buscar/postagem/{id}</p>
<p>Retorna a postagem pertencente ao <b>ID</b> passado por parametro</p>

```
{
  "userId": 1,
  "id": 4,
  "title": "eum et est occaecati",
  "body": "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"
}
```
