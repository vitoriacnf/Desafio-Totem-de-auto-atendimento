# Desafio-Totem-de-auto-atendimento
# README - Sistema de Pedidos para Lanchonete

O código é um exemplo de sistema de pedidos para uma lanchonete, onde os clientes podem escolher lanches e bebidas a partir de um menu. Os pedidos são armazenados em um carrinho, permitindo que os usuários adicionem, editem e removam itens antes de efetuar o pagamento.

## 1. Definição da Classe Produtos

A classe `Produtos` é uma data class que é utilizada para representar informações sobre os produtos. Ela possui três propriedades: `codigo`, `nome` e `preco`. As data classes no Kotlin são usadas principalmente para representar dados imutáveis e possuem funcionalidades extras, como a geração automática de métodos `equals()`, `hashCode()`, `toString()` e outros.

## 2. Criação da Lista de Lanches

A lista de lanches é criada utilizando a função `listOf()` do Kotlin. Essa função cria uma lista imutável contendo os elementos especificados. No exemplo, a lista de lanches contém dois produtos do tipo `Produtos`, sendo um X-burger com preço de 10.00 e um X-salada com preço de 12.00.

## 3. Criação da Lista de Bebidas

A lista de bebidas também é criada utilizando a função `listOf()`. Nesse caso, a lista contém dois produtos do tipo `Produtos`: um Refrigerante com preço de 8.00 e um Suco com preço de 6.00.

## 4. Função main

A função `main` é o ponto de entrada do programa. Ela inicia chamando a função `menuPrincipal`, que exibe as opções iniciais do usuário (lanche ou bebida). Em seguida, um loop `do-while` é executado para manter o sistema em execução até que o usuário decida finalizar o pedido.

Dentro do loop, o usuário escolhe entre lanches e bebidas, digitando um número correspondente à opção desejada. O programa utiliza uma estrutura `when` para tomar ações com base na escolha do usuário. Se o usuário escolher um lanche, ele seleciona o tipo de lanche e a quantidade desejada. O lanche é adicionado ao carrinho por meio da função `adicionarAoCarrinho`. O mesmo processo é realizado para bebidas.

Após cada pedido, o conteúdo atual do carrinho é exibido utilizando a função `exibirCarrinho`. Em seguida, o usuário tem opções para comprar mais itens, editar um item, remover um item ou finalizar o pedido. As funções `menuPrincipal`, `editarProdutos`, `removerProdutos` e `efetuarPagamento` são chamadas de acordo com a escolha do usuário.

## 5. Funções de Menu

O código contém três funções de menu: `menuPrincipal`, `menuLanche` e `menuBebida`. Elas são responsáveis por exibir as opções disponíveis para o usuário na tela.

## 6. Classe `Pagamento`

A classe `Pagamento` contém a função `efetuarPagamento`, que é responsável por processar o pagamento do pedido. A função exibe as opções de forma de pagamento disponíveis para o cliente.

## 7. Processo de Pagamento

O cliente pode escolher entre as seguintes formas de pagamento:

- Cartão de crédito (opção 1)
- Cartão de débito (opção 2)
- Vale refeição (opção 3)
- Dinheiro (opção 4)

A escolha do cliente é obtida a partir da entrada de dados do usuário, utilizando a função `readln().toInt()` para ler a opção escolhida como um número inteiro.

### Opções de Pagamento

**Cartão de Crédito/Débito/Vale Refeição (Opções 1, 2 e 3):** Se o cliente escolher qualquer uma dessas opções, o sistema exibirá a mensagem "Compra finalizada com sucesso!". Isso indica que o pagamento foi processado com sucesso e não há necessidade de calcular troco, pois a transação é feita eletronicamente.

**Pagamento em Dinheiro (Opção 4):** Se o cliente escolher a opção de pagamento em dinheiro, o sistema solicitará que o cliente informe o valor pago em dinheiro. O valor é lido utilizando a função `readln().toInt()`.

Em seguida, o sistema calculará o valor total do carrinho somando os preços de todos os itens presentes no carrinho. Em seguida, calculará o troco subtraindo o valor total da compra do valor pago em dinheiro.

- Se o troco for maior ou igual a zero (ou seja, o valor pago é igual ou maior que o total da compra), o sistema exibirá o valor do troco formatado com duas casas decimais e a mensagem "Compra finalizada com sucesso!". Isso indica que o pagamento em dinheiro foi processado com sucesso, e o cliente receberá o troco correspondente.

- Caso contrário, se o troco for negativo (ou seja, o valor pago é menor do que o total da compra), o sistema exibirá a mensagem "Valor insuficiente. Pagamento não realizado." Isso indica que o pagamento em dinheiro não foi suficiente para cobrir o valor total da compra, e a transação é cancelada.

## 8. Variável `carrinho`

A variável `carrinho` é uma lista mutável (`MutableList`) que armazena os produtos adicionados pelos clientes. Ela é inicializada como uma lista vazia por meio da função `mutableListOf<Produtos>()`.

## 9. Classe `Carrinho`

A classe `Carrinho` contém três funções principais:

- `adicionarAoCarrinho`: Responsável por adicionar um produto ao carrinho com base na quantidade especificada pelo cliente.
- `exibirCarrinho`: Exibe um resumo da compra, mostrando os produtos adicionados ao carrinho, a quantidade e o valor total.
- `editarProdutos`: Permite ao cliente editar a quantidade de um produto já adicionado ao carrinho.
- `removerProdutos`: Permite ao cliente remover um produto do carrinho com base no seu código.

## 10. Função `adicionarAoCarrinho`

A função `adicionarAoCarrinho` é responsável por adicionar um produto ao carrinho. Ela recebe três parâmetros: a lista de carrinho, o item a ser adicionado e a quantidade desejada.

A função calcula o valor total do item multiplicando seu preço pela quantidade e adiciona uma nova instância de `Produtos` com o código, nome e valor total ao carrinho.

## 11. Função `exibirCarrinho`

A função `exibirCarrinho` exibe um resumo dos produtos presentes no carrinho. Ela it

era sobre os produtos presentes na lista `carrinho` e mostra o nome do produto, sua quantidade e o valor total formatado com duas casas decimais.

## 12. Função `editarProdutos`

A função `editarProdutos` permite ao cliente editar a quantidade de um produto no carrinho. Ela solicita ao cliente que informe o código do produto que deseja editar e a nova quantidade desejada.

A função encontra o produto com o código especificado no carrinho utilizando a função `find`. Caso encontre o produto, ele é removido do carrinho e, em seguida, a função `adicionarAoCarrinho` é chamada para adicionar o produto com a nova quantidade ao carrinho.

## 13. Função `removerProdutos`

A função `removerProdutos` permite ao cliente remover um produto do carrinho. Ela solicita ao cliente que informe o código do produto que deseja remover.

A função encontra o produto com o código especificado no carrinho utilizando a função `find`. Caso encontre o produto, ele é removido do carrinho.
