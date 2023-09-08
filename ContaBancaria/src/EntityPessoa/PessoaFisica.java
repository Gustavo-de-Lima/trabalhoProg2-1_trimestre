package EntityPessoa;

public class PessoaFisica {
    // atributos
    private String nome;
    private String cpf;

    // getters

    public String getCpf() {
        return cpf;
    }

    // construtor
    public PessoaFisica(String nome, String cpf) {
        super();
        this.nome = nome;
        this.cpf = cpf;
    }

}
