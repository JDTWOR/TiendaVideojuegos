/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: DialogoPelicula.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.videotienda.interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import uniandes.cupi2.videotienda.mundo.Pelicula;

/**
 * Di�logo para mostrar los datos de una pel�cula
 */
public class DialogoPelicula extends JDialog
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * Pel�cula a mostrar en el panel
     */
    private Pelicula pelicula;

    /**
     * Panel de datos de la pel�cula
     */
    private PanelDatosPelicula panelDatos;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
    /**
     * Crea el di�logo para mostrar la informaci�n de la pel�cula dada
     * @param laPelicula Pel�cula a mostrar. laPelicula != null.
     */
    public DialogoPelicula( Pelicula laPelicula )
    {
        pelicula = laPelicula;
        panelDatos = new PanelDatosPelicula( this );
        setLayout( new BorderLayout( ) );
        add( panelDatos, BorderLayout.CENTER );
        pack( );
        setTitle( "Informaci�n de la Pel�cula" );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Retorna el t�tulo de la pel�cula
     * @return t�tulo de pel�cula
     */
    public String darTitulo( )
    {
        return pelicula.darTitulo( );
    }

    /**
     * Retorna el n�mero de copias disponibles de la pel�cula
     * @return n�mero de copias disponibles
     */
    public int darNumeroDisponibles( )
    {
        return pelicula.darCopiasDisponibles( );
    }

    /**
     * Retorna el n�mero de copias prestadas de la pel�cula
     * @return n�mero de copias prestadas
     */
    public int darNumeroPrestadas( )
    {
        return pelicula.darTotalCopias( ) - pelicula.darCopiasDisponibles( );
    }

    /**
     * Sale del di�logo
     */
    public void aceptar( )
    {
        dispose( );
    }
}
