public class Usuario {

    private Integer ID_USUARIO;
    private String NOME_USUARIO;
    private String SENHA_USUARIO;

    // métodos get e set para id, nome, senha

    public String getNome() {
        return this.NOME_USUARIO;
    }
    public void setNome(String novo) {
        this.NOME_USUARIO = novo;
    }

    public String getSenha() {
        return this.SENHA_USUARIO;
    }
    public void setSenha(String novo) {
        this.SENHA_USUARIO = novo;
    }
    public Integer getId() {
        return this.ID_USUARIO;
    }
    public void setId(Integer ID) {
        this.ID_USUARIO = ID;
    }

}
