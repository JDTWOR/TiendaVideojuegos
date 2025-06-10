/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: VideoTienda.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
public class VideoTienda
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Tarifa de alquiler diario
     */
    private int tarifaDiaria;

    /**
     * Clientes
     */
    //TODO declare el atributo

    /**
     * Catálogo de películas
     */
    //TODO declare el atributo
    
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea una videotienda sin películas registradas.
     * @param unaTarifa Tarifa diaria de alquiler. tarifa > 0.
     */
    public VideoTienda( int unaTarifa )
    {
    	//TODO implementar inicializando los atributos
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Carga en memoria los datos del archivo de películas. <br>
     * <b>post: </b> Se almacenan los datos de las películas del archivo en el catálogo eliminando las películas anteriiores. <br>
     * @param archivo Nombre del archivo que contiene la información de las películas.
     * @throws Exception si hay datos inválidos en el archivo o no tiene el formato adecuado.
     */
    public void cargarPeliculas( String archivo ) throws Exception
    {
        String titulo, dato;
        int peliculas, copias;
        Pelicula pel;

        //Limpia los datos iniciales de películas
        catalogo.clear( );

        //Obtiene los datos
        try
        {
            Properties datos = new Properties( );
            FileInputStream input = new FileInputStream( archivo );
            datos.load( input );

            //Obtiene el número de películas
            peliculas = Integer.parseInt( datos.getProperty( "total.peliculas" ) );

            for( int i = 1; i <= peliculas; i++ )
            {
                dato = "pelicula" + i + ".nombre";
                //Carga una película
                titulo = datos.getProperty( dato );
                if( titulo == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                copias = Integer.parseInt( datos.getProperty( "pelicula" + i + ".copias" ) );
                pel = new Pelicula( titulo );
                for( int j = 1; j <= copias; j++ )
                {
                    pel.agregarCopia( );
                }

                catalogo.add( pel );
            }
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los datos almacenados de películas" );
        }
    }

    /**
     * Afilia un cliente a la videotienda. <br>
     * <b>post: </b> Se crea un nuevo cliente y se agrega a la lista de clientes de la videotienda.
     * @param cedula Cédula del cliente a afiliar. cedula != null.
     * @param nombre Nombre del cliente a afiliar. nombre != null.
     * @param direccion Dirección del cliente a afiliar. direccion != null.
     * @throws Exception Si la cédula del cliente ya está registrada en la videotienda.
     */
    public void afiliarCliente( String cedula, String nombre, String direccion ) throws Exception
    {
    	//TODO implementar
    }
    
    /**
     * Busca el cliente dada la cédula.
     * @param cedula Cédula del cliente. cedula != null.
     * @return el cliente correspondiente a la cédula, o null si no hay un cliente con la cédula dada.
     */
    public Cliente buscarCliente( String cedula )
    {
    	//TODO implementar
    }



    /**
     * Adiciona el monto dado al saldo disponible del cliente. <br>
     * <b>post: </b> el saldo del cliente identificado con la cédula se incrementó con el monto dado. <br>
     * @param cedula Cédula del cliente. cedula != null.
     * @param monto Cantidad de dinero a adicionar en la cuenta. monto > 0.
     * @throws Exception Si el cliente no existe.
     * @throws Exception Si la recarga de saldo es menor que 0.
     */
    public void cargarSaldoCliente( String cedula, int monto ) throws Exception
    {
    	//TODO implementar
    }

    /**
     * Alquila una película a un cliente. <br>
     * <b>post: </b> si hay copias disponibles, alquila una copia de la película, adicionándola a la lista de alquiladas del cliente y de la videotienda.
     * @param titulo Título de la película. titulo != null.
     * @param cedula Cédula del cliente. cedula != null.
     * @return número de copia alquilada.
     * @throws Exception Si la película no existe.
     * @throws Exception Si el cliente no existe.
     * @throws Exception Si no hay copias disponibles.
     * @throws Exception Si el saldo del cliente no es suficiente para el alquiler.
     */
    public int alquilarPelicula( String titulo, String cedula ) throws Exception
    {
    	//TODO implementar
    }

    /**
     * Devuelve a la videotienda una copia alquilada por el cliente identificado con la cédula dada. <br>
     * <b>post: </b> Si la copia está alquilada por el cliente, la copia se deja disponible, y el cliente ya no la tiene entre sus prestadas.
     * @param titulo Título de la película. titulo != null.
     * @param numeroCopia Número de copia a devolver.
     * @param cedula Cédula del cliente. cedula != null.
     * @throws Exception Si el cliente no existe.
     * @throws Exception Si el cliente no tiene la copia alquilada.
     */
    public void devolverCopia( String titulo, int numeroCopia, String cedula ) throws Exception
    {
    	//TODO implementar

    }





    /**
     * Retorna la lista de clientes de la videotienda
     * @return ArrayList la lista de clientes
     */
    //TODO Definir la signatura del método de acuerdo a la documentación e implementarlo.

    /**
     * Retorna el catálogo de películas de la videotienda
     * @return lista de películas existentes. lista != null.
     */
    //TODO Definir la signatura del método de acuerdo a la documentación e implementarlo.

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return Respuesta de la extensión 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2
     * @return Respuesta de la extensión 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
