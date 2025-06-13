package uniandes.cupi2.videotienda.mundo;

public class Copia {
  private String tituloPelicula;
  private int codigo;

  public Copia(String laPelicula, int elCodigo) {
    tituloPelicula = laPelicula;
    codigo = elCodigo;
  }

  public int darCodigo() {
    return codigo;
  }

  public String darTituloPelicula() {
    return tituloPelicula;
  }

  public boolean esIgualA(Copia otra) {
    if (this.codigo == otra.darCodigo()) {
      return true;
    }
    return false;
  }
}
