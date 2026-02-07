package br.com.senai.s042;

import br.com.senai.s042.client.ViaCEPClient;
import br.com.senai.s042.model.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite o CEP: ");
        String cep = sc.next();
        sc.nextLine();

        Endereco endereco = ViaCEPClient.getEndereco(cep);
        System.out.println("O endereço solicitado é: ");
        System.out.println("Logradouro " + endereco.getLogradouro());
        System.out.println("Bairro " + endereco.getBairro());
        System.out.println("Cidade " + endereco.getLocalidade());
        System.out.println("Estado " + endereco.getUf());
        System.out.println("CEP " + endereco.getCep());

    }
}
