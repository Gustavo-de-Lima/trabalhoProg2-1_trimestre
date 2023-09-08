package Services.Cadastrar;

import EntityConta.ContaCorrente;
import EntityPessoa.PessoaFisica;

import java.util.ArrayList;
import java.util.Scanner;

public class ContaCorrenteService {
    private ArrayList<ContaCorrente> lista = new ArrayList<>();

    private PessoaFisicaService pessoaFisicaService;

    public ArrayList<ContaCorrente> getLista() {
        return lista;
    }


    // construtor pra pegar o atributo das pessoas
    public ContaCorrenteService(PessoaFisicaService pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }


    // Pega os dados e cadastra (Esse funciona)
    public void cadastrar() throws Exception {
        Scanner leia = new Scanner(System.in);
        System.out.println("Cadastrar Conta Corrente: ");
        System.out.println("Entre com seu cpf: ");
        String cpf = leia.next();
        PessoaFisica pessoaFisica = pessoaFisicaService.obterPorCpf(cpf);
        System.out.println("Crie uma senha para sua conta, de 4 digitos: (Apenas numeros) ");
        int senha = leia.nextInt();
        ContaCorrente contaCorrente = new ContaCorrente(pessoaFisica, senha);
        lista.add(contaCorrente);
        System.out.println("Conta criada!! Seu numero de conta eh: " + contaCorrente.getNumConta());
    }


    /*
    * Metodo que busca as contas,
    * mas n consegui fazer funcionar,
    * por favor me mostre onde errei
    * */
    public ContaCorrente obterPorNumConta(int numConta) throws Exception {
        ContaCorrente contaAchada = null;
        for (ContaCorrente contaCorrente : lista) {
            if (contaCorrente.getNumConta() == numConta) {
                contaAchada = contaCorrente;
            }
        }
        if (contaAchada != null){
            return contaAchada;
        }else {
            throw new Exception("Conta nao encontrada");
        }
    }

    // Retorna todas as contas
    public ArrayList<ContaCorrente> obterTodos() {
        return lista;
    }
}
