# 📍 Consulta de CEP com Spring Boot

Aplicação desenvolvida em **Java** que consome a API pública ViaCEP para retornar automaticamente os dados completos de um endereço a partir do CEP informado.

Este projeto demonstra consumo de API externa, tratamento de exceções e conversão de JSON para objeto Java.

---

## 🚀 Funcionalidades

✔ Consulta de endereço via CEP  
✔ Consumo de API externa via HTTP  
✔ Conversão de JSON para objeto Java  
✔ Tratamento de CEP inexistente  
✔ Tratamento de erro de comunicação (timeout e falhas de rede)  

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Apache HttpClient (`org.apache.http.client.fluent.Request`)
- Gson
- Maven
- API pública: ViaCEP

---

## 🧠 Como Funciona

A classe `ViaCEPClient`:

1. Monta dinamicamente a URL da API  
2. Realiza uma requisição HTTP GET  
3. Define timeout de conexão e socket (10 segundos)  
4. Verifica se o retorno contém `"erro": true`  
5. Lança exceção customizada (`CEPNotFoundExcept`) caso o CEP não exista  
6. Converte o JSON retornado para o objeto `Endereco`  

---

## 🔎 Exemplo de Uso

### Requisição:
GET /cep/01001000

### Consulta realizada:

https://viacep.com.br/ws/01001000/json


### Resposta:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

### ⚠️ Tratamento de Erros

📌 CEP inexistente
```json
{
throw new CEPNotFoundExcept("Este CEP não existe na base de dados");
}
```

📌 Erro de comunicação
```json
{
throw new IOException("Erro de I/O: ...");
}
```

### ▶️ Como Executar o Projeto


1️⃣ Clone o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git

2️⃣ Acesse a pasta do projeto:
cd seu-repositorio

3️⃣ Execute a aplicação:
mvn spring-boot:run

4️⃣ Acesse no navegador ou Postman:
http://localhost:8080/cep/{cep}

### 📚 Conceitos Aplicados

Consumo de API REST

Manipulação de JSON

Tratamento de exceções customizadas

Timeout de requisição HTTP

Conversão JSON → Objeto (DTO)

Arquitetura em camadas

---

Autor: Gabrielly F. Nascimento
