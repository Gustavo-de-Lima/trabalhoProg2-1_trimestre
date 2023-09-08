package Services.Operacoes;

import EntityConta.ContaCorrente;
import EntityConta.ContaPoupanca;
import EntityPessoa.PessoaFisica;
import Services.Cadastrar.ContaCorrenteService;
import Services.Cadastrar.ContaPoupancaService;
import Services.Cadastrar.PessoaFisicaService;

import java.util.Scanner;



public class TransferirService {
    PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
    ContaPoupancaService contaPoupancaService = new ContaPoupancaService(pessoaFisicaService);
    ContaCorrenteService contaCorrenteService = new ContaCorrenteService(pessoaFisicaService);

    // Metodo que interliga os outros
    public void transferir() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o tipo da conta-destino: (Corrente ou poupanca)");
        String contaDestino = leia.next();
        System.out.println("Entre com o tipo da conta-origem: (Corrente ou poupanca)");
        String contaOrigem = leia.next();

        if (contaOrigem.equalsIgnoreCase("corrente") && contaDestino.equalsIgnoreCase("corrente")) {
            correnteCorrente();
        } else if (contaOrigem.equalsIgnoreCase("corrente") && contaDestino.equalsIgnoreCase("poupanca")) {
            correntePoupanca();
        } else if (contaOrigem.equalsIgnoreCase("poupanca") && contaDestino.equalsIgnoreCase("poupanca")) {
            poupancaPoupanca();
        } else if(contaOrigem.equalsIgnoreCase("poupanca") && contaDestino.equalsIgnoreCase("corrente")){
            poupancaCorrente();
        } else {
            throw new Exception("Numero invalido; Operacao cancelada");
        }
    }

    /*
     * Provalvelmente seria mais facil se eu fizesse um unico,
     * em vez de fazer quatro separados para as quatro possibilidades de transferir,
     * mas enfim ne */
    private void poupancaPoupanca() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o numero da conta-origem: ");
        int numContaOrigem = leia.nextInt();
        System.out.println("Entre com o numero da conta-destino: ");
        int numContaDestino = leia.nextInt();

        if (contaPoupancaService.obterPorNumConta(numContaOrigem) == null && contaPoupancaService.obterPorNumConta(numContaDestino) == null) {
            throw new Exception("Numero da conta invalido; Operacao cancelada");
        }

        ContaPoupanca contaOrigem = contaPoupancaService.obterPorNumConta(numContaOrigem);
        ContaPoupanca contaDestino = contaPoupancaService.obterPorNumConta(numContaDestino);
        PessoaFisica pessoa = contaOrigem.getDonoConta();
        System.out.println("Entre com o seu cpf: ");
        String cpf = leia.next();
        if (!pessoa.getCpf().equalsIgnoreCase(cpf)) {
            throw new Exception("Cpf invalido");
        }

        System.out.println("Entre com o valor a ser transferido");
        Double valorTransferir = leia.nextDouble();
        System.out.println("Entre com a senha da sua conta: ");
        int senha = leia.nextInt();
        if (contaOrigem.validarSenha(senha) == false) {
            throw new Exception("Senha invalida; Operacao cancelada");
        } else if (contaOrigem.transferirPoupanca(contaDestino, valorTransferir) == false) {
            throw new Exception("Valor invalido; Operacao cancelada");
        } else {
            contaOrigem.transferirPoupanca(contaDestino, valorTransferir);
            System.out.println("Operacao realizada com sucesso!!!!");
        }

    }

    private void correntePoupanca() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o numero da conta-origem: ");
        int numContaOrigem = leia.nextInt();
        System.out.println("Entre com o numero da conta-destino: ");
        int numContaDestino = leia.nextInt();

        if (contaCorrenteService.obterPorNumConta(numContaOrigem) == null && contaPoupancaService.obterPorNumConta(numContaDestino) == null) {
            throw new Exception("Numero da conta invalido; Operacao cancelada");
        }

        ContaCorrente contaOrigem = contaCorrenteService.obterPorNumConta(numContaOrigem);
        ContaPoupanca contaDestino = contaPoupancaService.obterPorNumConta(numContaDestino);
        PessoaFisica pessoa = contaOrigem.getDonoConta();
        System.out.println("Entre com o seu cpf: ");
        String cpf = leia.next();
        if (!pessoa.getCpf().equalsIgnoreCase(cpf)) {
            throw new Exception("Cpf invalido");
        }

        System.out.println("Entre com o valor a ser transferido");
        Double valorTransferir = leia.nextDouble();
        System.out.println("Entre com a senha da sua conta: ");
        int senha = leia.nextInt();
        if (contaOrigem.validarSenha(senha) == false) {
            throw new Exception("Senha invalida; Operacao cancelada");
        } else if (contaOrigem.transferirPoupanca(contaDestino, valorTransferir) == false) {
            throw new Exception("Valor invalido; Operacao cancelada");
        } else {
            contaOrigem.transferirPoupanca(contaDestino, valorTransferir);
            System.out.println("Operacao realizada com sucesso!!!!");
        }
    }

    private void correnteCorrente() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o numero da conta-origem: ");
        int numContaOrigem = leia.nextInt();
        System.out.println("Entre com o numero da conta-destino: ");
        int numContaDestino = leia.nextInt();

        if (contaCorrenteService.obterPorNumConta(numContaOrigem) == null && contaCorrenteService.obterPorNumConta(numContaDestino) == null) {
            throw new Exception("Numero da conta invalido; Operacao cancelada");
        }

        ContaCorrente contaOrigem = contaCorrenteService.obterPorNumConta(numContaOrigem);
        ContaCorrente contaDestino = contaCorrenteService.obterPorNumConta(numContaDestino);
        PessoaFisica pessoa = contaOrigem.getDonoConta();
        System.out.println("Entre com o seu cpf: ");
        String cpf = leia.next();
        if (!pessoa.getCpf().equalsIgnoreCase(cpf)) {
            throw new Exception("Cpf invalido");
        }

        System.out.println("Entre com o valor a ser transferido");
        Double valorTransferir = leia.nextDouble();
        System.out.println("Entre com a senha da sua conta: ");
        int senha = leia.nextInt();
        if (contaOrigem.validarSenha(senha) == false) {
            throw new Exception("Senha invalida; Operacao cancelada");
        } else if (contaOrigem.transferirCorrente(contaDestino, valorTransferir) == false) {
            throw new Exception("Valor invalido; Operacao cancelada");
        } else {
            contaOrigem.transferirCorrente(contaDestino, valorTransferir);
            System.out.println("Operacao realizada com sucesso!!!!");
        }
    }

    private void poupancaCorrente() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o numero da conta-origem: ");
        int numContaOrigem = leia.nextInt();
        System.out.println("Entre com o numero da conta-destino: ");
        int numContaDestino = leia.nextInt();

        if (contaPoupancaService.obterPorNumConta(numContaOrigem) == null && contaCorrenteService.obterPorNumConta(numContaDestino) == null) {
            throw new Exception("Numero da conta invalido; Operacao cancelada");
        }

        ContaPoupanca contaOrigem = contaPoupancaService.obterPorNumConta(numContaOrigem);
        ContaCorrente contaDestino = contaCorrenteService.obterPorNumConta(numContaDestino);
        PessoaFisica pessoa = contaOrigem.getDonoConta();
        System.out.println("Entre com o seu cpf: ");
        String cpf = leia.next();
        if (!pessoa.getCpf().equalsIgnoreCase(cpf)) {
            throw new Exception("Cpf invalido");
        }

        System.out.println("Entre com o valor a ser transferido");
        Double valorTransferir = leia.nextDouble();
        System.out.println("Entre com a senha da sua conta: ");
        int senha = leia.nextInt();
        if (contaOrigem.validarSenha(senha) == false) {
            throw new Exception("Senha invalida; Operacao cancelada");
        } else if (contaOrigem.transferirCorrente(contaDestino, valorTransferir) == false) {
            throw new Exception("Valor invalido; Operacao cancelada");
        } else {
            contaOrigem.transferirCorrente(contaDestino, valorTransferir);
            System.out.println("Operacao realizada com sucesso!!!!");
        }
    }
}
