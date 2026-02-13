# 📍 Consulta de CEP em Java

Aplicação desenvolvida em Java que consome a API pública ViaCEP para retornar automaticamente os dados completos de um endereço a partir do CEP informado.

O projeto demonstra consumo de API externa, tratamento de exceções personalizadas e conversão de JSON para objeto Java.

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
- Maven
- Apache HttpClient (`org.apache.http.client.fluent.Request`)
- Gson
- API pública: ViaCEP

---

## 🧠 Como Funciona

A classe `ViaCEPClient`:

- Monta dinamicamente a URL da API  
- Realiza uma requisição HTTP GET  
- Define timeout de conexão e socket (10 segundos)  
- Verifica se o retorno contém `"erro": true`  
- Lança exceção customizada (`CEPNotFoundExcept`) caso o CEP não exista  
- Converte o JSON retornado para o objeto `Endereco`  

---

## 🔎 Exemplo de Uso

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

## ⚠️ Tratamento de Erros

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

## ▶️ Como Executar o Projeto

1️⃣ Clone o repositório:
```json
{
git clone https://github.com/seu-usuario/seu-repositorio.git
}
```

2️⃣ Acesse a pasta do projeto:
```json
{
cd seu-repositorio
}
```

3️⃣ Compile o projeto:
```json
{
mvn clean install
}
```

4️⃣ Execute a classe principal pela sua IDE
ou via terminal (caso tenha classe com main):
```json
{
java NomeDaClassePrincipal
}
```

## 📚 Conceitos Aplicados

Consumo de API REST

Manipulação de JSON

Tratamento de exceções customizadas

Timeout de requisição HTTP

Conversão JSON → Objeto (DTO)

---

👩‍💻 Autora Gabrielly F. Nascimento


