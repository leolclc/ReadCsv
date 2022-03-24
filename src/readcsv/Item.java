package readcsv;

/**
 *
 * @author leandro.cardoso
 */
public class Item {

  

    
    private String Jogo;
    private String Categoria;
    private double Nota;
    
     public Item(String jogo, String categoria, double nota) {
        this.Jogo = jogo;
        this.Categoria = categoria;
        this.Nota = nota;
    }
    public void setJogo(String jogo) {
        this.Jogo = jogo;
    }
     public void setNota(double nota) {
        this.Nota = nota;
    }
    public void setCategoria(String categoria) {
        this.Categoria = categoria;
    }
    public String getJogo() {
        return this.Jogo;
    }
 

    public Double getNota() {
        return this.Nota;
    }

   
    public String getCategoria() {
        return this.Categoria;
    }

   
    
}
