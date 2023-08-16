## Mav Shop - Mercado Virtual :bulb:

**Responsáveis:** 

[Ana Flávia Bernardes](https://github.com/AnaBern034)

[Milena Alcântara](https://github.com/Milena-Alcantara)

[Vitória Ferreira](https://github.com/vitoria-ferreira05)
<hr>


**Objetivo:**

O Mav Shop é um mercado virtual que oferece aos clientes a facilidade de realizar compras mensais. Além disso, o Mav Shop disponibiliza cestas básicas pré-definidas que podem ser personalizadas, atendendo às necessidades específicas dos usuários.

**Classes Principais**

1. **Cliente:** Representa os clientes do Mav Shop.
    - Métodos: cadastrarCliente(), adicionarProdutoAoCarrinho(), removerProdutoDoCarrinho(), finalizarCompra().

2. **Produto:** Representa os produtos disponíveis no mercado.
    - Métodos: estoqueLimitado(), listaDeProdutos().

3. **Cesta:** Representa as cestas de compras, incluindo a cesta básica e a cesta plus.
    - Métodos: adicionarCesta(), editarCesta().

4. **Carrinho:** Gerencia os itens selecionados pelo cliente para compra.
    - Métodos: adicionarProduto(), removerProduto(), calcularTotal(), finalizarCarrinho().

5. **Pagamento:** Lida com os métodos de pagamento e finalização da compra.
    - Métodos: finalizarCompra(), pagamentoCartaoCredito(), pagamentoCartaoDebito(), pagamentoDinheiro().

**Funcionalidades e Métodos**

_Cliente:_
- Cadastro de cliente: O cliente pode se cadastrar no sistema fornecendo informações como email, senha, número de telefone e CEP.
- Opções de adicionar produtos: O cliente pode explorar a lista de produtos disponíveis e adicionar itens ao carrinho de compras.
- Status da compra: O cliente recebe mensagens de status da compra, mantendo-o informado sobre o progresso do pedido.

_Produto:_
- Estoque limitado: Os produtos têm um estoque máximo definido para cada item.
- Lista de produtos: Os produtos disponíveis são listados para que os clientes possam fazer suas escolhas.

_Pagamento:_
- Finalizar compra: O cliente pode escolher entre diferentes métodos de pagamento, incluindo dinheiro, cartão de crédito ou débito.

_Cesta:_
- Adicionar cesta: Os clientes podem escolher entre cestas básicas e cestas plus para adicionar ao carrinho.
- Editar cesta: Os clientes podem personalizar suas cestas, adicionando ou removendo itens conforme necessário.

_Carrinho:_
- Finalizar carrinho: Os clientes podem adicionar ou remover itens do carrinho e visualizar o total dos pedidos. O carrinho também fornece informações sobre o tempo estimado de entrega.

**Considerações Finais:**

O Mav Shop oferece aos clientes uma experiência de compra conveniente e personalizada, permitindo que eles escolham entre cestas pré-definidas ou personalizem suas compras de acordo com suas necessidades. Com uma variedade de métodos de pagamento e status de compra atualizados, os clientes podem desfrutar de uma experiência de compra eficiente e informada. 

<hr>
<div>
    
  <a href="https://ibb.co/HPSgqbn"><img src="https://i.ibb.co/fNg0Hy4/MavShop.jpg" alt="MavShop" border="0"></a>
    
</div>
    
