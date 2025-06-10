package uniandes.cupi2.videotienda.mundo;

import java.util.ArrayList;

public class Cliente {

  private String cedula;

  private String nombre;

  private String direccion;

  private int saldo;

  public Cliente(String laCedula, String elNombre, String laDireccion) {
    cedula = laCedula;
    nombre = elNombre;
    direccion = laDireccion;
    saldo = 0;
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
    return 1;
  }

  // ArrayList darAlquiladas()
  //
  public Copia buscarPeliculaAlquilada(String pelicula, int codigo) {
    return copia;
  }

  public void develoverCopia(String pelicula, int codigo) {
    System.out.println("Toca hacer el metodo develoverCopia");
  }
}
