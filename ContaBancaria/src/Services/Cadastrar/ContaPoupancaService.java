package Services.Cadastrar;

import EntityConta.ContaPoupanca;
import EntityPessoa.PessoaFisica;
import Services.Cadastrar.PessoaFisicaService;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ContaPoupancaService {

    private ArrayList<ContaPoupanca> lista = new ArrayList<>();
    private PessoaFisicaService pessoaFisicaService;

    // construtor pra pegar o atributo das pessoas
    public ContaPoupancaService(PessoaFisicaService pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }
    // Pega os dados e cadastra (Esse funciona)
    public void cadastrar() throws Exception {

        Scanner leia = new Scanner(System.in);
        Random gerador = new Random();
        System.out.println("Cadastrar Conta Poupanca: ");
        System.out.println("Entre com seu cpf: ");
        String cpf = leia.next();
        PessoaFisica pessoaFisica = pessoaFisicaService.obterPorCpf(cpf);
        System.out.println("Crie uma senha para sua conta, de 4 digitos: (Apenas numeros) ");
        int senha = leia.nextInt();
        ContaPoupanca contaPoupanca = new ContaPoupanca(pessoaFisica, senha);
        lista.add(contaPoupanca);
        System.out.println("Conta criada!! Seu numero de conta eh: " + contaPoupanca.getNumConta());
    }
    /*
     * Metodo que busca as contas,
     * mas n consegui fazer funcionar,
     * por favor me mostre onde errei
     * */
    public ContaPoupanca obterPorNumConta(int numConta) throws Exception {
        ContaPoupanca contaAchada = null;
        for (ContaPoupanca contaPoupanca : lista) {
            if (contaPoupanca.getNumConta() == numConta) {
                contaAchada = contaPoupanca;
            }
        }
        if (contaAchada != null){
            return contaAchada;
        }else{
            throw new Exception("Conta nao encontrada");
        }

    }

    // Retorna todas as contas
    public ArrayList<ContaPoupanca> obterTodos() {
        return lista;
    }

}
