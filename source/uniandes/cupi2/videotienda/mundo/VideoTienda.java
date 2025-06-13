/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: VideoTienda.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.videotienda.mundo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Esta clase representa a la VideoTienda
 */
public class VideoTienda {

  // -----------------------------------------------------------------
  // Atributos
  // -----------------------------------------------------------------

  /**
   * Tarifa de alquiler diario
   */
  private int tarifaDiaria;

  /**
   * Clientes
   */

  private ArrayList<Cliente> clientes;

  /**
   * Catálogo de películas
   */

  private ArrayList<Pelicula> catalogo;
  // -----------------------------------------------------------------
  // Constructores
  // -----------------------------------------------------------------

  /**
   * Constructor de la VideoTienda
   */
  public VideoTienda(int unaTarifa) {
      tarifaDiaria = unaTarifa;
      clientes = new ArrayList<Cliente>();
      catalogo = new ArrayList<Pelicula>();
  }

  // -----------------------------------------------------------------
  // M�todos
  // -----------------------------------------------------------------

  /**
   * Carga en memoria los datos del archivo de pel�culas. <br>
   * <b>post: </b> Se almacenan los datos de las pel�culas del archivo en el
   * cat�logo eliminando las pel�culas anteriiores. <br>
   * 
   * @param archivo Nombre del archivo que contiene la informaci�n de las
   *                pel�culas.
   * @throws Exception si hay datos inv�lidos en el archivo o no tiene el formato
   *                   adecuado.
   */
  public void cargarPeliculas(String archivo) throws Exception {
      Properties datos = new Properties();
      FileInputStream input = new FileInputStream(archivo);
      datos.load(input);
      input.close();
      
      String dato = datos.getProperty("total.peliculas");
      int total = Integer.parseInt(dato);
      
      for (int i = 1; i <= total; i++) {
          String titulo = datos.getProperty("pelicula" + i + ".titulo");
          catalogo.add(new Pelicula(titulo));
      }
  }

  /**
   * Alquila una pel�cula a un cliente. <br>
   * <b>post: </b> si hay copias disponibles, alquila una copia de la pel�cula, adicion�ndola a la lista de alquiladas del cliente y de la videotienda.
   * @param titulo T�tulo de la pel�cula. titulo != null.
   * @param cedula C�dula del cliente. cedula != null.
   * @return n�mero de copia alquilada.
   * @throws Exception Si la pel�cula no existe.
   * @throws Exception Si el cliente no existe.
   * @throws Exception Si no hay copias disponibles.
   * @throws Exception Si el saldo del cliente no es suficiente para el alquiler.
   */
  public void alquilarPelicula( String titulo, String cedula ) throws Exception
  {
      Cliente cliente = buscarCliente(cedula);
      if (cliente == null) {
          throw new Exception("El cliente no existe");
      }

      Pelicula pelicula = buscarPelicula(titulo);
      if (pelicula == null) {
          throw new Exception("La película no existe");
      }

      Copia copia = pelicula.alquilarCopia();
      if (copia == null) {
          throw new Exception("No hay copias disponibles");
      }

      cliente.alquilarCopia(copia);
  }

  /**
   * Devuelve a la videotienda una copia alquilada por el cliente identificado con la c�dula dada. <br>
   * <b>post: </b> Si la copia est� alquilada por el cliente, la copia se deja disponible, y el cliente ya no la tiene entre sus prestadas.
   * @param titulo T�tulo de la pel�cula. titulo != null.
   * @param numeroCopia N�mero de copia a devolver.
   * @param cedula C�dula del cliente. cedula != null.
   * @throws Exception Si el cliente no existe.
   * @throws Exception Si el cliente no tiene la copia alquilada.
   */
  public void devolverCopia( String titulo, int numeroCopia, String cedula ) throws Exception
  {
      Cliente cliente = buscarCliente(cedula);
      if (cliente == null) {
          throw new Exception("El cliente no existe");
      }

      Pelicula pelicula = buscarPelicula(titulo);
      if (pelicula == null) {
          throw new Exception("La película no existe");
      }

      cliente.devolverCopia(titulo, numeroCopia);
      pelicula.devolverCopia(numeroCopia);
  }

  /**
   * Afilia un nuevo cliente a la videotienda
   * @param cedula Cédula del cliente. cedula != null
   * @param nombre Nombre del cliente. nombre != null
   * @param direccion Dirección del cliente. direccion != null
   * @throws Exception Si ya existe un cliente con la misma cédula
   */
  public void afiliarCliente(String cedula, String nombre, String direccion) throws Exception {
      if (buscarCliente(cedula) != null) {
          throw new Exception("Ya existe un cliente con la cédula " + cedula);
      }
      Cliente nuevoCliente = new Cliente(cedula, nombre, direccion);
      clientes.add(nuevoCliente);
  }

  /**
   * Carga saldo a la cuenta de un cliente
   * @param cedula Cédula del cliente. cedula != null
   * @param monto Monto a cargar. monto > 0
   * @throws Exception Si el cliente no existe
   */
  public void cargarSaldoCliente(String cedula, int monto) throws Exception {
      Cliente cliente = buscarCliente(cedula);
      if (cliente == null) {
          throw new Exception("El cliente con cédula " + cedula + " no existe");
      }
      cliente.cargarSaldo(monto);
  }

  /**
   * Busca una película en el catálogo por su título.
   * @param titulo Título de la película. titulo != null.
   * @return la película correspondiente al título, o null si no existe.
   */
  private Pelicula buscarPelicula(String titulo) {
      for (Pelicula p : catalogo) {
          if (p.darTitulo().equals(titulo)) {
              return p;
          }
      }
      return null;
  }

  /**
   * Retorna la lista de clientes de la videotienda
   * @return ArrayList la lista de clientes
   */
  public ArrayList<Cliente> darListaClientes() {
      return clientes;
  }

  /**
   * Retorna el catálogo de películas de la videotienda
   * @return lista de películas existentes. lista != null.
   */
  public ArrayList<Pelicula> darCatalogo() {
      return catalogo;
  }

  /**
   * Busca un cliente por su cédula
   * @param cedula Cédula del cliente a buscar. cedula != null
   * @return Cliente si lo encuentra, null si no existe
   */
  private Cliente buscarCliente(String cedula) {
      for (Cliente cliente : clientes) {
          if (cliente.darCedula().equals(cedula)) {
              return cliente;
          }
      }
      return null;
  }

  /**
   * Agrega una copia de una película al catálogo
   * @param titulo Título de la película. titulo != null
   * @throws Exception Si la película no existe en el catálogo
   */
  public void agregarCopiaPelicula(String titulo) throws Exception {
      Pelicula pelicula = buscarPelicula(titulo);
      if (pelicula == null) {
          throw new Exception("La película no existe en el catálogo");
      }
      pelicula.agregarCopia();
  }

  /**
   * Modifica la tarifa diaria de alquiler
   * @param nuevaTarifa Nueva tarifa a establecer. nuevaTarifa > 0
   */
  public void modificarTarifa(int nuevaTarifa) {
      if (nuevaTarifa > 0) {
          tarifaDiaria = nuevaTarifa;
      }
  }

  /**
   * Retorna la tarifa diaria de alquiler
   * @return tarifa diaria actual
   */
  public int darTarifaDiaria() {
      return tarifaDiaria;
  }

  //-----------------------------------------------------------------
  // Puntos de Extensi�n
  //-----------------------------------------------------------------

  /**
   * M�todo para la extensi�n 1
   * @return Respuesta de la extensi�n 1
   */
  public String metodo1( )
  {
      return "Respuesta 1";

  }

  /**
   * M�todo para la extensi�n 2
   * @return Respuesta de la extensi�n 2
   */
  public String metodo2( )
  {
      return "Respuesta 2";

  }

}
