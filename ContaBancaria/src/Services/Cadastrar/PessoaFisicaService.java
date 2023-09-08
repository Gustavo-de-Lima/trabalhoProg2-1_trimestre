package Services.Cadastrar;

import EntityPessoa.PessoaFisica;

import java.util.ArrayList;
import java.util.Scanner;

public class PessoaFisicaService {
    private ArrayList<PessoaFisica> lista = new ArrayList<PessoaFisica>();

    public ArrayList<PessoaFisica> getLista() {
        return lista;
    }

    public void cadastrar() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite seu cpf: ");
        String cpf = leia.next();
        System.out.println("Digite seu nome: ");
        String nome = leia.next();

        lista.add(new PessoaFisica(nome, cpf));
        System.out.println("Pessoa cadastrada com sucesso!!");
        System.out.println();
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return lista;
    }

    public PessoaFisica obterPorCpf(String cpf) throws Exception {
        for (PessoaFisica pessoa : lista) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }

        }
        throw new Exception("Pessoa nao encontrada!!");
    }
}
