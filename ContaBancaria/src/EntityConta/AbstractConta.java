package EntityConta;

import EntityPessoa.PessoaFisica;

public abstract class AbstractConta {
    //atributos
    private PessoaFisica donoConta;
    private String codAgencia = "123";
    private int senha;
    private Double saldo;
    private int numConta;

    // getters

    public int getSenha() {
        return senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public PessoaFisica getDonoConta() {
        return donoConta;
    }

    // construtor
    public AbstractConta(PessoaFisica donoConta, int senha) {
        super();
        this.numConta = addNumConta();
        this.donoConta = donoConta;
        this.senha = senha;
        this.saldo = 0.0;
    }


    //funcoes que sao basicas, nao podem ser alteradas
    public boolean sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    ;

    public boolean depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }


    public boolean validarSenha(int senha) {
        return this.getSenha() == senha;
    }

    // funcoes que tem que ser implementadas
    public abstract int addNumConta();
}
