public class Usuario {

    private Integer ID;
    private String NOME;
    private String SENHA;

    // métodos get e set para id, nome, senha

    public String getNome() {
        return this.NOME;
    }
    public void setNome(String novo) {
        this.NOME = novo;
    }
    public String getSenha() {
        return this.SENHA;
    }
    public void setSenha(String novo) {
        this.SENHA = novo;
    }
    public Integer getId() {
        return ID;
    }
    public void setId(Integer ID) {
        this.ID = ID;
    }

}
