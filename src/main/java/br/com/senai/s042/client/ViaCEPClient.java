package br.com.senai.s042.client;

import br.com.senai.s042.exception.CEPNotFoundExcept;
import br.com.senai.s042.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ViaCEPClient {
    public static Endereco getEndereco(String cep) throws IOException {
        String url = "https://viacep.com.br/ws/" + cep + "/json";

        try{
            String jsonResponse = Request.Get(url)
                    .connectTimeout(10000)
                    .socketTimeout(10000)
                    .execute()
                    .returnContent()
                    .asString();

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if(jsonObject.has("erro") && jsonObject.get("erro").getAsBoolean()){
                throw new CEPNotFoundExcept("Este CEP não existe na base de dados");
            }
            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, Endereco.class);
        } catch(IOException e){
            throw new IOException("Erro de I/O: " + e.getMessage(), e);
        }
    }
}
