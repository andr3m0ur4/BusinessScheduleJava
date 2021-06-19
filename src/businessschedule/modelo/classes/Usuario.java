package businessschedule.modelo.classes;

import lib.Execoes;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String funcao;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha, String funcao) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setFuncao(funcao);
    }
    
    public Usuario(int id, String nome, String email, String funcao) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setFuncao(funcao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Execoes.menorQueZero("Id", id);
        this.id = id;
    }

    public String getNome() {
        
        
        return nome;
    }

    public void setNome(String nome) {
        Execoes.isNulo("Nome", nome);
        this.nome = nome;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Execoes.isNulo("Email", email);
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        Execoes.isNulo("Senha", senha);
        Execoes.verificaTamanho("Senha", senha);
        
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        Execoes.isNulo("Funçao", funcao);
        this.funcao = funcao;
    }
    
 

    @Override
    public String toString() {
        return "ID: " + id + " - Nome: " + nome + " - E-mail: " + email + " - Função: " + funcao;
    }
}
