package Services.Operacoes;

import EntityConta.ContaCorrente;
import EntityConta.ContaPoupanca;
import EntityPessoa.PessoaFisica;
import Services.Cadastrar.ContaCorrenteService;
import Services.Cadastrar.ContaPoupancaService;
import Services.Cadastrar.PessoaFisicaService;

import java.util.Scanner;

public class SacarService {
    PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
    ContaPoupancaService contaPoupancaService = new ContaPoupancaService(pessoaFisicaService);
    ContaCorrenteService contaCorrenteService = new ContaCorrenteService(pessoaFisicaService);

    // interliga os outros metodos
    public void sacar() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o tipo da sua conta: (Corrente ou poupanca)");
        String tipo = leia.next();
        if (tipo.equalsIgnoreCase("poupanca")) {
            sacarPoupanca();
        } else if (tipo.equalsIgnoreCase("corrente")) {
            sacarCorrente();
        } else {
            throw new Exception("Opcao invalida; Operacao cancelada");
        }
    }

    // usado pra sacar em contas correntes apenas, nao sei se funciona
    private void sacarCorrente() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o numero da sua conta: ");
        int numConta = leia.nextInt();

        if (contaCorrenteService.obterPorNumConta(numConta) == null) {
            throw new Exception("numero da conta invalido; Operacao cancelada");
        }
        ContaCorrente contaCorrente = contaCorrenteService.obterPorNumConta(numConta);
        PessoaFisica pessoa = contaCorrente.getDonoConta();
        System.out.println("Entre com o seu cpf: ");
        String cpf = leia.next();
        if(!pessoa.getCpf().equalsIgnoreCase(cpf)){
            throw new Exception("Cpf invalido");
        }

        System.out.println("Entre com o valor a ser sacado: ");
        Double valorSacar = leia.nextDouble();
        System.out.println("Entre com a senha da conta: ");
        int senha = leia.nextInt();
        if (contaCorrente.validarSenha(senha) == false) {
            throw new Exception("Senha invalida; Operacao cancelada");
        } else if (contaCorrente.sacar(valorSacar) == false) {
            throw new Exception("Valor invalido; Operacao cancelada");
        } else {
            contaCorrente.sacar(valorSacar);
            System.out.println("Operacao realizada com sucesso!!!!");
        }
    }

    // usado pra sacar em contas poupancas apenas, nao sei se funciona
    private void sacarPoupanca() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o numero da sua conta: ");
        int numConta = leia.nextInt();

        if (contaPoupancaService.obterPorNumConta(numConta) == null) {
            throw new Exception("Numero da conta invalido; Operacao cancelada");
        }
        ContaPoupanca contaPoupanca = contaPoupancaService.obterPorNumConta(numConta);
        PessoaFisica pessoa = contaPoupanca.getDonoConta();
        System.out.println("Entre com o seu cpf: ");
        String cpf = leia.next();
        if(!pessoa.getCpf().equalsIgnoreCase(cpf)){
            throw new Exception("Cpf invalido");
        }
        System.out.println("Entre com o valor a ser sacado: ");
        Double valorSacar = leia.nextDouble();
        System.out.println("Entre com a senha da conta: ");
        int senha = leia.nextInt();

        if (contaPoupanca.validarSenha(senha) == false) {
            throw new Exception("Senha invalida; Operacao cancelada");
        } else if (contaPoupanca.sacar(valorSacar) == false) {
            throw new Exception("Valor invalido; Operacao cancelada");
        } else {
            contaPoupanca.sacar(valorSacar);
            System.out.println("Operacao realizada com sucesso!!!!");
        }
    }
}
