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
  private ArrayList disponibles;

  /**
   * Lista de copias prestadas
   */
  private ArrayList prestadas;

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
   * Adiciona una nueva copia de la pel�cula. <br>
   * <b>post: </b>La lista de pel�culas disponibles tiene una nueva copia.
   * 
   * @return c�digo de la copia creada. c�digo >= 1;
   */
  public int agregarCopia() {
<<<<<<< HEAD
    // TODO implementar. Recuerde retornar lo indicado en la documentaci�n.

=======
    // TODO implementar. Recuerde retornar lo indicado en la documentaci�n.
>>>>>>> f8859d8 (Se declararon las funciones darCatalogo y darClientes)
  }

  /**
   * Retorna una copia de pel�cula para alquilar si hay disponibles. <br>
   * <b>post: </b> la copia queda en la lista de prestadas.
   * 
   * @return Copia que ha sido alquilada o null si no hay disponibles.
   */
  public Copia alquilarCopia() {
    // TODO implementar. Recuerde retornar lo indicado en la documentaci�n.
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

  /**
   * Retorna el n�mero de copias disponibles
   * 
   * @return n�mero de copias disponibles
   */
  // TODO Definir la signatura del m�todo de acuerdo a la documentaci�n e
  // implementarlo.


