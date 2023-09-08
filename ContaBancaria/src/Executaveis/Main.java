package Executaveis;

import Services.Cadastrar.ContaCorrenteService;
import Services.Cadastrar.ContaPoupancaService;
import Services.Cadastrar.PessoaFisicaService;
import Services.Operacoes.DepositarService;
import Services.Operacoes.SacarService;
import Services.Operacoes.TransferirService;

import java.util.Scanner;

public class Main {
    private static PessoaFisicaService pessoaService = new PessoaFisicaService();
    private static ContaPoupancaService contaPoupancaService = new ContaPoupancaService(pessoaService);
    private static ContaCorrenteService contaCorrenteService = new ContaCorrenteService(pessoaService);
    private static SacarService sacarService = new SacarService();
    private static DepositarService depositarService = new DepositarService();
    private static TransferirService transferirService = new TransferirService();
    static boolean teste = true;
    public static void main(String[] args) {

        // mantem o sistema rodando e pega as execoes
        try {
          while (teste){
              escolha();
          }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // menuzinho basico
    public static void menu() {
        System.out.println("Ola, seja bem vinde!!!!");
        System.out.println("1-Cadastrar Pessoa Fisica;");
        System.out.println("2-Cadastrar Conta Corrente;");
        System.out.println("3-Cadastrar Conta Poupanca;");
        System.out.println("4-Sacar;");
        System.out.println("5-Depositar;");
        System.out.println("6-Transferir para;");
        System.out.println("0-Sair;");
        System.out.println("Selecione uma opcao: ");
    }


    // metodo que interliga as classes
    public static boolean escolha() throws Exception {
        menu();
        Scanner leia = new Scanner(System.in);
        String a = leia.next();
        switch (a) {
            case "1":
                pessoaService.cadastrar();
                break;
            case "2":
                contaCorrenteService.cadastrar();
                break;
            case "3":
                contaPoupancaService.cadastrar();
                break;
            case "4":
                sacarService.sacar();
                break;
            case "5":
                depositarService.depositar();
                break;
            case "6":
                transferirService.transferir();
                break;
            case "7":

                break;
            case "0":
                teste = false;
                break;
        }
        return teste;
    }
}
