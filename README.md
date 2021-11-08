# Equipe BrainPower Academia IBM Gama Blue-Accademy

# REST API (bluebank)
> Esta API faz chamadas para um sistema de contas bancárias de determinadas agências, para o banco bluebank, que recebe o retorno das requisições HTTP em formato json.


### Modelo de Entidade Relacional
<img src="https://github.com/genesiopmn/brainpower/blob/master/API%20Rest_V2.png" alt="Modelo de Entidade Relacional">


### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Modelagem do Banco de Dados
- [x] Crud Cliente (BP-001)
- [x] Tratamento de Exceção Centralizada
- [x] Crud Conta (feature/crud-account)
- [x] Geração Script SQL
- [x] Backlog do Projeto
- [x] Criar um tratamento centralizado e genérico da classe Exception na classe ExceptionHandler
- [x] Providenciar o tratamento de Exceção para a Exception Data Integration
- [x] Testar Desabilitados
- [x] Tratar verificação da conta centralizado
- [x] Alterar os tipos de dados em todos os lugares para BigDecimal
- [x] Criação do Diagrama Classes
- [x] Geração de Testes Automatizados
- [x] Relatório Account - Client - historyTransaction
- [x] Função Post (Cadastrar Conta)
- [ ] Reunião Entrega Final

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
<!---Estes são apenas requisitos de exemplo. Adicionar, duplicar ou remover conforme necessário--->
* Você instalou a versão mais recente de `<linguagem / dependência / requeridos>`
* Você tem uma máquina `<Windows / Linux / Mac>`. Indique qual sistema operacional é compatível / não compatível.
* Você leu `<guia / link / documentação_relacionada_ao_projeto>`.

## 🚀 Instalando <brainpower>

Para instalar o <brainpower>, siga estas etapas:
## ☕ Usando <brainpower>
Windows:
```
Para usar <brainpower>, siga estas etapas:
<git clone https://github.com/genesiopmn/brainpower.git>
```
## 🚀 Endpoints
  
Na nossa aplicação são 15 endopoints para a utilização.
  
  <b>Account</b>
  - Metódo Get: http://localhost:8080/account -> Traz todas as contas cadastrados na aplicação;
  - Método Get: http://localhost:8080/account/2 -> Traz uma conta com id passado como parametro;
  - Método Get: http://localhost:8080/account/identificationDocument/1234567898 -> Traz todas as contas cadastrados com um número de identificação;
  - Método Delete: http://localhost:8080/account/1 -> Deleta a conta com id um;
  - Método Post: http://localhost:8080/account/ -> Cadastra uma nova conta;
Dados para cadastro: 
  {
    "accountNumber":"123456",
    "agencyNumber":"79",
    "agencyTelephone":"11993527709",
    "accountBalance":"500",
    "client":"1"
 }
  - Método Put: http://localhost:8080/account/disabled/2 -> Desativa a conta com id 2;
  - Método Put: http://localhost:8080/account/reactive/2 -> Reativa a conta com id 2;
  
  <b>Client</b>
  - Método Get: http://localhost:8080/client -> Traz todos os clientes cadastrados na base de dados;
  - Método Get: http://localhost:8080/client/1 -> Traz o cliente com id 1;
  - Método Delete: http://localhost:8080/client/1 -> Deleta o cliente com id um;
  - Método Post: http://localhost:8080/account/ -> Cadastra um novo cliente;
  Dados para o cadastro:
  {
    "name":"123456",
    "identificationDocument":"79",
    "email":"11993527709",
    "telephone":"500",
    "listFulladdress" : [
            {
                "id": 1,
                "address": "Rua Caetano Basso",
                "number": 252,
                "complement": "",
                "district": "SP",
                "city": "São Paulo",
                "zipCode": "03584-130",
                "state": "São Paulo",
                "country": "Brasil"
            }
        ]
  }
  - Método Put: http://localhost:8080/client/1 -> Atualiza o endereço com id 1; 
  {
    "address": "Rua Barbosa",
    "number": 252,
    "complement": "",
    "district": "SP",
    "city": "São Paulo",
    "zipCode": "03584-130",
    "state": "São Paulo",
    "country": "Brasil"
  }
  
  <b>TransactionHistory</b>
  
  - Método Post: http://localhost:8080/transaction -> Transfere valor entre contas
  {
    "idOriginAccount": "2",
    "idDestinationAccount": "4",
    "value": "1",
    "historic": "TESTE"
  }
  - Método Get: http://localhost:8080/transaction/account/14831-0 -> Busca todas as transferencias da conta 14831-0;
  - Método Get: http://localhost:8080/transaction/client/1234567899 - > Busca todas as transferencias do cliente com o número de identificação 1234567899 
    

<!--- Adicione comandos de execução e exemplos que você acha que os usuários acharão úteis. Fornece uma referência de opções para pontos de bônus! --->

## 📫 Contribuindo para <brainpower>
<!---Se o seu README for longo ou se você tiver algum processo ou etapas específicas que deseja que os contribuidores sigam, considere a criação de um arquivo CONTRIBUTING.md separado--->
Para contribuir com <brainpower>, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_do_projeto> / <local>`
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://trello-members.s3.amazonaws.com/58a0b39d528bd66fd8deaa8f/f34bc0899a13bb4be201ef338e5f4247/original.png" width="100px;" alt=""/><br>
        <sub>
          <b>Natalia Maldaner</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://trello-members.s3.amazonaws.com/5e15d6f6903f2771272dd3e7/d84d242ed987cacde40d15abdd12855b/original.png" width="100px;" alt=""/><br>
        <sub>
          <b>Genésio Pereira</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://github.com/genesiopmn/brainpower/blob/master/MarcusVinicius.jpg" width="100px;" alt=""/><br>
        <sub>
          <b>Marcus Vinícius</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## Linguagens 

* [MySQL](https://mysql.com/)
    
* [Java Spring boot](https://java.com)
<!--- [Spring boot](https://spring.io) --->
* [JUNIT](https://junit.org)

## 📝 Licença

<!--- Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes --->

[⬆ Voltar ao topo](#genesiopmn/brainpower)<br>
