## Estudos v02
# Padrão de Design de Estratégia: Dominando a Flexibilidade Comportamental

Você já enfrentou um problema em que precisou alternar algoritmos com base na mudança dinâmica de requisitos?

Exemplo: 
Esqueça o padrão de estratégia por um momento. Imagine que você está desenvolvendo um software para um aplicativo de e-commerce e tem uma aula chamada Checkout. Essa classe faz o checkout, mas antes disso, ela precisa processar o pagamento.

Agora, os clientes podem usar diferentes métodos de pagamento, como cartões de crédito, cartões de débito, pagamentos UPI e carteiras.

Você deve escrever código para isso primeiro e, em seguida, veremos se podemos melhorá-lo ainda mais.\
## Pattern.java está a implementação

alguns problemas com o código:
>>Você precisa atualizar a classe Checkout para introduzir uma nova forma de pagamento.\
Isso viola o Princípio de Responsabilidade Única - o processo de checkout é responsável pelo checkout e processamento do pagamento.\
Existem muitos, se não, dependendo dos métodos de pagamento.

>
### Em suma, é preciso muito trabalho para manter.

Imagine que você tenha uma classe Checkout e a forma de pagamento seja plug-and-play para a classe Checkout. Isso significa que você define o método de pagamento antes da finalização da compra e suas respectivas classes lidam com todos os processos de pagamento.

Você deseja introduzir um novo método de pagamento. Adicione uma nova classe de pagamento e conecte-a à classe Checkout.

Se você quiser excluir qualquer forma de pagamento, deverá excluir sua classe. Isso não afetará nenhum outro código.

>como posso escrever uma nova classe que seja compatível com a classe Checkout?

criar uma interface chamada PaymentStrategy, e todos os tipos de pagamento são responsáveis por implementar essa interface e implementarão sua lógica de processamento de pagamento.

A classe Checkout não se preocupa com como processar o pagamento e que tipo de pagamento é.

Ele simplesmente chama o método processPayment da interface PaymentStrategy, que chama um método da classe cujo objeto está sendo referenciado. (polimorfismo)

As chamadas de classe de checkout processam o pagamento e executam o checkout.

 >> Um padrão de design de estratégia é um padrão de design comportamental que permite que o comportamento de um algoritmo seja selecionado em tempo de execução. Em vez de implementar um único algoritmo diretamente, o código recebe instruções de tempo de execução sobre qual algoritmos usar.

## Pattern2.java está a segunda implementação

**Padrão de Projeto Estratégia** com os seguintes elementos:

* **Contexto:** Esta classe mantém uma referência a um objeto de estratégia e é usada pelo cliente para escolher o algoritmo desejado.
* **Estratégia:** Isso define uma interface comum para todos os algoritmos suportados. Cada algoritmo deve implementar esta interface.
* **Estratégias Concretas:** Essas são classes que implementam a interface de estratégia com algoritmos específicos.

**Como funciona:**

1. A classe `Checkout` (Contexto) possui uma referência a um objeto `PaymentStrategy`.
2. A classe `Checkout` pode escolher dinamicamente qual estratégia de pagamento concreta usar (CreditCardPayment, DebitCardPayment, UPI Payment ou WalletPayment) em tempo de execução.
3. O método `pay` da estratégia selecionada é invocado, permitindo que o método de pagamento apropriado seja usado.

## Vantagens do Padrão de Estratégia:

* **Flexibilidade:** Permite que algoritmos sejam trocados facilmente em tempo de execução.
* **Princípio Aberto/Fechado:** Você pode adicionar novos métodos de pagamento sem modificar o código existente.
* **Complexidade Reduzida:** Mantém a classe `Checkout` principal focada no processo de checkout, não nos detalhes específicos de pagamento. 

## Inconvenientes:

- **Complexidade:** Para casos de uso simples, a implementação do padrão de estratégia pode precisar ser mais compatível com o aplicativo, introduzindo camadas de abstração desnecessárias.
- **Número de objetos:** Cada estratégia exigirá uma classe adicional. Para um grande número de estratégias, isso pode levar a uma proliferação de classes, aumentando a complexidade da base de código.
- **Clientes devem estar cientes das estratégias:** O código do cliente deve conhecer as diferentes estratégias a serem escolhidas e usadas, o que pode ser considerado um vazamento de detalhes de abstração.
