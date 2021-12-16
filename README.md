# Modelo de Domínio Anêmico | Anemic Domain Model | ADM
    > Um classe com campos privados e getters e setters é um modelo anêmico
    > Um modelo de domínio anêmico é freqüentemente usado e recomendado como objeto DTO ( Data Transfer Object )
    > O modelo é apenas um "contêiner" de dados
    > Todo lógica de manipulção de dados é feita em outra classe
      > *Service | *Helper | *Processor | etc.
      > A lógicado negócio é distribuída entre vários serviços
    > Exemplo:
      > O usuário na criação não está ativo. Somente após a confirmação do e-mail sua conta é ativada. (UserActivationService)
      > Por padrão, o usuário não está bloqueado. Em caso de violação das regras, o usuário pode ser bloqueado pelo administrador, (UserBlockerService)
      > O endereço de e-mail do usuário deve ser do Gmail . domínio com , (UserRegistrationService)
      > O nome do usuário deve ter menos de 100 caracteres. (UserRegistrationService)
    > Desvantagens:
      > Viola o princípio da Engenharia: 
        > "Tell, Don't Ask"
        > "Don't Repeat Your Self"
      > O modelo não é testável, 
        > Não há garantia que outra classe possa alterar o valor contido
        > Não há garantia que outra classe possa quebra os requisitos

# Modelo de Domínio Rico | Rich Domain Model
  > Fornece métodos de negócios, expondo o comportamento do modelo e não apenas seu estado
  > Um Rich Domain Model não nos permite criar objetos inválidos
  > O estado de um objeto é sempre consistente e a consistência é garantida pelo próprio objeto, não por condições verificadas no código que opera em objetos 
  > Classe Email:
    > Podemos mover as validações de domínio de email para o objeto Email
      > Impede de criar um endereço de e-mail incorreto
      > Impede de modificar o e-mail após sua criação.
  > Classe Username:
    > Podemos mover as validações de nome do usuário para o objeto Username
      > Impede de criar um nome de usuários incorretos
      > Impede de modificar o nome de usuários após sua criação.