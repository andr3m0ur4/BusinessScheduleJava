package businessschedule.modelo.classes;

import java.util.Objects;
import lib.Excecoes;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String funcao;

    public Usuario() {
    }
    
    public Usuario(String nome) {
        setNome(nome);
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
        Excecoes.menorQueZero("Id", id);
        this.id = id;
    }

    public String getNome() {
        
        
        return nome;
    }

    public void setNome(String nome) {
        Excecoes.isNulo("Nome", nome);
        this.nome = nome;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Excecoes.isNulo("Email", email);
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        Excecoes.isNulo("Senha", senha);
        Excecoes.verificaTamanho("Senha", senha);
        
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        Excecoes.isNulo("Funçao", funcao);
        this.funcao = funcao;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
 

    @Override
    public String toString() {
        return "ID: " + id + " - Nome: " + nome + " - E-mail: " + email + " - Função: " + funcao;
    }
}
