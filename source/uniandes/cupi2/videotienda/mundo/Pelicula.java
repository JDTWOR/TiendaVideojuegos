/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: Pelicula.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
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

import java.util.ArrayList;

/**
 * Esta clase representa una pel�cula que se encuentra en la videotienda y
 * de la cual puede haber copias disponibles o prestadas.
 */
public class Pelicula {

  // -----------------------------------------------------------------
  // Atributos
  // -----------------------------------------------------------------

  /**
   * T�tulo de la pel�cula
   */
  private String titulo;

  /**
   * Lista de copias disponibles
   */
  private ArrayList<Copia> disponibles;

  /**
   * Lista de copias prestadas
   */
  private ArrayList<Copia> prestadas;

  /**
   * N�mero de la siguiente copia a adicionar
   */
  private int codigoSiguienteCopia;

  // -----------------------------------------------------------------
  // Constructores
  // -----------------------------------------------------------------

  /**
   * Crea una pel�cula de la videotienda con el t�tulo dado. <br>
   * <b>post: </b> La pel�cula se crea sin copias disponibles ni prestadas.
   * 
   * @param unTitulo T�tulo de la pel�cula. unTitulo != null.
   */
  public Pelicula(String unTitulo) {
    titulo = unTitulo;
    codigoSiguienteCopia = codigoSiguienteCopia + 1;

  }

  // -----------------------------------------------------------------
  // M�todos
  // -----------------------------------------------------------------

  /**
   * Adiciona una nueva copia de la película.
   * <b>post: </b>La lista de películas disponibles tiene una nueva copia.
   * @return código de la copia creada. código >= 1
   */
  public int agregarCopia() {
    // Crear la nueva copia con el título de la película y el código siguiente
    Copia nuevaCopia = new Copia(titulo, codigoSiguienteCopia);
    
    if (disponibles == null) {
        disponibles = new ArrayList<Copia>();
    }
    
    disponibles.add(nuevaCopia);
    
    // Guardar el código actual para retornarlo
    int codigoActual = codigoSiguienteCopia;
    
    codigoSiguienteCopia++;
    
    return codigoActual;
  }


  /**
   * Retorna una copia de pel�cula para alquilar si hay disponibles.
   * <b>post: </b> la copia queda en la lista de prestadas.
   * @return Copia que ha sido alquilada o null si no hay disponibles.
   */
  public Copia alquilarCopia() {
    if (disponibles == null || disponibles.isEmpty()) {
        return null;
    }

    Copia copiaAlquilar = disponibles.get(0);

    disponibles.remove(0);

    if (prestadas == null) {
        prestadas = new ArrayList<Copia>();
    }

    prestadas.add(copiaAlquilar);

    return copiaAlquilar;
  }

  /**
   * Devuelve una copia de la pel�cula y la coloca como disponible. <br>
   * <b>post: </b> regresa la copia a la lista de disponibles, s�lo si est�
   * prestada.
   * 
   * @param codigoCopia C�digo de la copia que se quiere devolver.
   * @throws Exception Si la copia a devolver no est� prestada.
   */

  // TODO Definir la signatura del m�todo de acuerdo a la documentaci�n e
  // implementarlo.

  /**
   * Retorna el t�tulo de la pel�cula.
   * 
   * @return t�tulo de la pel�cula.
   */

  public void devolverCopia(int codigoCopia) throws Exception {
    if (prestadas == null || prestadas.isEmpty()) {
        throw new Exception("No hay copias prestadas de esta película");
    }

    Copia copiaADevolver = null;

    for (int i = 0; i < prestadas.size(); i++) {
        Copia copia = (Copia) prestadas.get(i);
        if (copia.darCodigo() == codigoCopia) {
            copiaADevolver = copia;
            prestadas.remove(i);
            break;
        }
    }

    if (copiaADevolver == null) {
        throw new Exception("La copia con el código " + codigoCopia + " no está prestada");
    }

    if (disponibles == null) {
        disponibles = new ArrayList<Copia>();
    }

    disponibles.add(copiaADevolver);
  }

  /**
   * Retorna el título de la película
   * @return título de la película
   */
  public String darTitulo() {
    return titulo;
  }

  /**
   * Retorna la cantidad total de copias que existen de la pel�cula en la
   * videotienda
   * 
   * @return entero con la cantidad de copias que existen en la tienda
   */
  // TODO Definir la signatura del m�todo de acuerdo a la documentaci�n e
  // implementarlo.
  public int darTotalCopias() {
    int total = 0;
    if (disponibles != null) {
        total += disponibles.size();
    }
    if (prestadas != null) {
        total += prestadas.size();
    }
    return total;
  }

  /**
   * Retorna el n�mero de copias disponibles
   * 
   * @return n�mero de copias disponibles
   */
  // TODO Definir la signatura del m�todo de acuerdo a la documentaci�n e
  // implementarlo.
  public int darCopiasDisponibles() {
    if (disponibles != null) {
        return disponibles.size();
    }
    return 0;
  }

}


