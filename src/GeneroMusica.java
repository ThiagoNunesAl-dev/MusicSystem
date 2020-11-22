public class GeneroMusica {

    private Integer ID_GENERO;
    private String NOME_GENERO;


    // métodos get e set para id, nome

    public String getNome() {
        return this.NOME_GENERO;
    }

    public void setNome(String novo) {
        this.NOME_GENERO = novo;
    }

    public Integer getId() {
        return ID_GENERO;
    }

    public void setId(Integer ID) {
        this.ID_GENERO = ID;
    }

}
