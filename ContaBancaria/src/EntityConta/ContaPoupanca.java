package EntityConta;

import EntityPessoa.PessoaFisica;

public class ContaPoupanca extends AbstractConta {

    // construtor
    public ContaPoupanca(PessoaFisica donoConta, int senha) {
        super(donoConta, senha);
    }


    // implementacao das funcoes que foram implementadas
    @Override
    public int addNumConta() {
        return (int) (Math.random() * 9000) + 1000;
    }


    // funcoes que sao dessa classe
    // realmente, tambem poderiam ser implementadas na classe AbstractConta, mas pensei so depois.

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
