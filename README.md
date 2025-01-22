# challenge-forumHub

Neste desafio de programação do curso **Praticando Spring Framework: Challenge Fórum Hub**, da formação **Java e Spring Framework G7 - ONE**, construímos um fórum de tópicos variados totalmente do zero utilizando **Spring Boot** e **PostgreSQL** (em um container Docker).

Para rodar o PostgreSQL em um container Docker, execute o seguinte comando no seu terminal:
```bash
docker run -p 5432:5432 --name forum-hub -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=forum-hub -d postgres
```


### Funcionalidades
- Cadastro de Usuário: Permite que um usuário crie uma conta no sistema, fornecendo informações como nome, email e senha
- Listagem de Usuários: Exibe uma lista com todos os usuários registrados no sistema.
- Cadastro de Curso: Permite que o usuário crie um novo curso, fornecendo dados como nome e categoria.
- Listagem de Cursos: Exibe uma lista com todos os cursos registrados no sistema.
- Cadastro de Tópico: Permite a criação de novos tópicos, associando-os a um curso e um autor. O tópico tem informações como título, mensagem e status.
- Listagem de Tópicos: Exibe uma lista paginada com todos os tópicos registrados no sistema.
- Consulta de Tópico por ID: Permite a consulta de informações detalhadas de um tópico específico, utilizando seu ID único.
- Atualização de Tópico: Permite que um usuário altere as informações de um tópico, como título e mensagem.
- Deleção de Tópico: Exclui um tópico do sistema com base no seu ID.
- Login de Usuário: Permite que um usuário faça login no sistema, utilizando suas credenciais (email e senha). Após a autenticação, o usuário recebe um token para realizar operações protegidas na API.


Insígnia do desafio |  
:-------------------------:|
![badge](https://cdn3.gnarususercontent.com.br/3841-Programa%C3%A7%C3%A3o/Badge-Spring.png) |
Insígnia de conclusão do desafio.|