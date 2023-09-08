package EntityConta;

import EntityPessoa.PessoaFisica;

public class ContaCorrente extends AbstractConta {

    // construtor
    public ContaCorrente(PessoaFisica donoConta, int senha) {
        super(donoConta, senha);
    }


    // implementacao das funcoes que foram implementadas
    @Override
    public int addNumConta() {
        return (int) (Math.random() * 9000) + 1000;
    }


    // funcoes que sao dessa classe
    public boolean transferirCorrente(ContaCorrente contaDestino, Double valor){
        if(valor > 0 && getSaldo() > 0){
            this.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        }
        return false;

    }

    public boolean transferirPoupanca(ContaPoupanca contaDestino, Double valor){
        if(valor > 0 && getSaldo() > 0){
            this.sacar(valor);
            contaDestino.depositar(valor);
            return true;
        }
        return false;

    }
}
