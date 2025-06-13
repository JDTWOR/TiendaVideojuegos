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
    if (cedula == null || cedula.isEmpty()) {
      throw new IllegalArgumentException("La cédula no puede ser nula o vacía");
    }
    if (!cedula.matches("\\d+")) {
      throw new IllegalArgumentException("La cédula debe contener solo dígitos");
    }
    if (cedula.length() < 5 || cedula.length() > 10) {
      throw new IllegalArgumentException("La cédula debe tener entre 5 y 10 dígitos");
    }
    if (cedula.charAt(0) == '0') {
      throw new IllegalArgumentException("La cédula no puede comenzar con cero");
    }
    return cedula;

  }

  public int darSaldo() {
    if (saldo < 0) {
      throw new IllegalArgumentException("El saldo no puede ser negativo");
    }
    return saldo;
  }

  public String darNombre() {
    if (nombre == null || nombre.isEmpty()) {
      throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
    }
    if (!nombre.matches("[a-zA-Z ]+")) {
      throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
    }
    return nombre;
  }

  public String darDireccion() {
    if (direccion == null || direccion.isEmpty()) {
      throw new IllegalArgumentException("La dirección no puede ser nula o vacía");
    }
    if (!direccion.matches("[a-zA-Z0-9 ,.-]+")) {
      throw new IllegalArgumentException("La dirección solo puede contener letras, números, espacios, comas, puntos y guiones");
    }
    if (direccion.length() < 5 || direccion.length() > 100) {
      throw new IllegalArgumentException("La dirección debe tener entre 5 y 100 caracteres");
    }
    return direccion;
  }

  /**
   * Alquila una copia de película al cliente
   * @param copia Copia de la película a alquilar
   */
  public void alquilarCopia(Copia copia) {
      if (copia != null) {
          if (alquiladas == null) {
              alquiladas = new ArrayList<Copia>();
          }
          
          alquiladas.add(copia);
      }
  }

  public void cargarSaldo(int monto) {
    saldo += monto;
  }

  public void descargarSaldo(int monto) {
    if (monto < 0) {
      throw new IllegalArgumentException("El monto a descontar no puede ser negativo");
    }
    if (saldo < monto) {
      throw new IllegalArgumentException("Saldo insuficiente para descontar el monto");
    }
    saldo -= monto;
  }

  public int darNumeroAlquiladas() {
    return alquiladas.size();
  }

  public ArrayList<Copia> darAlquiladas() {
    return alquiladas;
  }

  /**
   * Busca una copia alquilada de una película específica
   * @param pelicula Película a buscar. pelicula != null
   * @param codigoCopia Código de la copia a buscar. codigoCopia > 0
   * @return La copia si se encuentra, null si no está alquilada por el cliente
   */
  public Copia buscarPeliculaAlquilada(Pelicula pelicula, int codigoCopia) {
      if (alquiladas == null) {
          return null;
      }
      for (Copia copia : alquiladas) {
          if (copia.darTitulo().equals(pelicula.darTitulo()) && 
              copia.darCodigo() == codigoCopia) {
              return copia;
          }
      }
      
      // Si no encuentra la copia
      return null;
  }

  /**
   * Devuelve una copia alquilada por el cliente
   * @param pelicula Título de la película a devolver. pelicula != null
   * @param codigo Código de la copia a devolver. codigo > 0
   * @return La copia que se devuelve
    * @throws Exception Si la copia no está alquilada por el cliente
   */
  public void devolverCopia(String pelicula, int codigo) throws Exception {
      boolean encontrada = false;
      Copia copiaDevolver = null;
      
      for (Copia copia : alquiladas) {
          if (copia.darTitulo().equals(pelicula) && copia.darCodigo() == codigo) {
              copiaDevolver = copia;
              encontrada = true;
              break;
          }
      }
      
      if (!encontrada) {
          throw new Exception("La copia no está alquilada por el cliente");
      }
      
      alquiladas.remove(copiaDevolver);
  }
}
