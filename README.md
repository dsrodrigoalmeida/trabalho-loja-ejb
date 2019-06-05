O sistema da Loja Alê usa a api Qualquer Coisa.

O sistema foi desenvolvido usando Java 8 (OpenJdk 8) com a linguagem de programação Spring Boot e fazendo persistencia no Banco de 
Dados MariaDB.

É necessario instalar o Maria DB e fazer a criação de um banco de dados chamado QualquerCoisa.

O login e a senha criada pra acessar o MariaDB é root e root respectivamente.

Feito esses  procedimentos, é so executar o arquivo QualquerCoisaApplication

Essa aplicação irá popular o banco de dados com 10 usuarios e 10 produtos ao ser executado

A lista de usuarios e produtos respectivamente:

                                   id     nome    qtd valor
		Estoque produto = new Estoque(null, "queijo", 10, 15.0);
		Estoque produto2 = new Estoque(null, "chocolate", 3, 5.0);
		Estoque produto3 = new Estoque(null, "café", 5, 3.0);
		Estoque produto4 = new Estoque(null, "pepsi", 10, 3.9);
		Estoque produto5 = new Estoque(null, "chá", 6, 2.5);
		Estoque produto6 = new Estoque(null, "biscoito", 8, 1.5);
		Estoque produto7 = new Estoque(null, "lembas", 15, 12.0);
		Estoque produto8 = new Estoque(null, "hidromel", 30, 15.0);
		Estoque produto9 = new Estoque(null, "vinho", 28, 25.0);
		Estoque produto10 = new Estoque(null, "agua", 50, 2.3);
		
		                               id   nome de usuario nome verdadeiro
		Cliente cliente = new Cliente(null,"princesazelda","zelda");
		Cliente cliente2 = new Cliente(null,"link","link");
		Cliente cliente3 = new Cliente(null,"ganon","calamity ganon");
		Cliente cliente4 = new Cliente(null,"legolas","legolas verdefolha");
		Cliente cliente5 = new Cliente(null,"aragorn","aragorn passolargo");
		Cliente cliente6 = new Cliente(null,"gimli","gimli filho de glóin ");
		Cliente cliente7 = new Cliente(null,"gandalf","gandalf o cinzento ");
		Cliente cliente8 = new Cliente(null,"bilbo","bilbo bolseiro ");
		Cliente cliente9 = new Cliente(null,"teste","123 ");
		Cliente cliente10 = new Cliente(null,"rodrigo","rodrigo almeida ");
		
    
    Para efetuar login no sistema com um dos usuarios é so utilizar o 2 campo de cliente. Exemplo: Para efetuar login utilizando
    o Cliente rodrigo almeida é so escrever o nome rodrigo que corresponde ao nome de  usuario. 
    
    Para acessar o sistema é so digitar o endereço localhost:8080/qualquercoisa/
    
    Na pagina de login pode também ser feito cadastro de novos clientes, listar e processar pedidos de reposição, cadastrar produtos
    no estoque, listar produtos do estoque e atualizar produtos do estoque.
    
    Ao efetuar o login, pode fazer busca de produtos para adicionar ao carrinho, finalizar compra, cancelar pedidos, remover produtos
    do carrinho, abrir carrinho de compras, listar pedidos. 
