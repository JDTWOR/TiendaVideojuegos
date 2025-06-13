package uniandes.cupi2.videotienda.mundo;

import java.util.ArrayList;

public class Cliente {

  private String cedula;

  private String nombre;

  private String direccion;

  private int saldo;

  private ArrayList<Copia> alquiladas;

  public Cliente(String laCedula, String elNombre, String laDireccion) {
    cedula = laCedula;
    nombre = elNombre;
    direccion = laDireccion;
    saldo = 0;
    alquiladas = new ArrayList<>();
  }

  public String darCedula() {
    return cedula;
  }

  public int darSaldo() {
    return saldo;
  }

  public String darNombre() {
    return nombre;
  }

  public String darDireccion() {
    return direccion;
  }

  public void alquilarCopia() {
    System.out.println("Toca hacer el metodo alquilarCopia");
  }

  public void cargarSaldo(int monto) {
    saldo += monto;
  }

  public void descargarSaldo(int monto) {
    saldo -= monto;
  }

  public int darNumeroAlquiladas() {
    return alquiladas.size();
  }

  public ArrayList<Copia> darAlquiladas() {
    return alquiladas;
  }

  public Copia buscarPeliculaAlquilada(String pelicula, int codigo) {
    for (Copia copia2 : alquiladas) {
      if ((pelicula && codigo) == copia2.darTitulo() && copia2.darCodigo() ) {
        return copia2
      }
    }
  }

  public void develoverCopia(String pelicula, int codigo) {
    System.out.println("Toca hacer el metodo develoverCopia");
  }
}
