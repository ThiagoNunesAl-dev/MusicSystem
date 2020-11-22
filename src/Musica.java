public class Musica {

    private Integer ID_MUSICA;
    private String NOME_MUSICA;
    private Float NOTA_MUSICA;

    // métodos get e set para id, nome, senha

    public String getNome() {
        return this.NOME_MUSICA;
    }

    public void setNome(String novo) {
        this.NOME_MUSICA = novo;
    }

    public Integer getId() {
        return ID_MUSICA;
    }

    public void setId(Integer ID) {
        this.ID_MUSICA = ID;
    }

    public Float getNota() {
        return NOTA_MUSICA;
    }

    public void setNota(Float NOTA) {
        this.NOTA_MUSICA = NOTA;
    }
}
