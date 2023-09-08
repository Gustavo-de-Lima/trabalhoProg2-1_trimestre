package Services.Operacoes;

import Services.Cadastrar.ContaCorrenteService;
import Services.Cadastrar.ContaPoupancaService;
import Services.Cadastrar.PessoaFisicaService;

import java.util.Scanner;

public class ConsultarService {

    /*
    * Em construcao ainda,
    * Nao consegui terminar
    * */
    private static PessoaFisicaService pessoaFisicaService = new PessoaFisicaService();
    private static ContaCorrenteService contaCorrenteService = new ContaCorrenteService(pessoaFisicaService);
    private static ContaPoupancaService contaPoupancaService = new ContaPoupancaService(pessoaFisicaService);


    //
    public void consultar() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Entre com o tipo da conta a consultar: (corrente ou poupanca)");
        String tipoConta = leia.next();
        if (tipoConta.equalsIgnoreCase("corrente")) {
            consultarCorrente();
        } else if (tipoConta.equalsIgnoreCase("poupanca")) {
            consultarPoupanca();
        } else {
            throw new Exception("Tipo invalido");
        }
    }

    private void consultarPoupanca() {
        Scanner leia = new Scanner(System.in);
        System.out.println("1- Listar todas as contas;");
        System.out.println("2- Conusultar por numero de conta;");
        System.out.println("Entre com uma opcao: ");
        int opcao = leia.nextInt();
        switch (opcao){
            case 1:
                contaPoupancaService.obterTodos();
                break;
            case 2:

                break;
        }
    }

    private void consultarCorrente() {

    }
}
