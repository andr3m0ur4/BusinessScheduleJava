package classes;

public class Funcionario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String email, String senha, String funcao) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setFuncao(funcao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "ID: " + id + "Nome: " + nome + "E-mail: " + email + "Função: " + funcao;
    }
}
