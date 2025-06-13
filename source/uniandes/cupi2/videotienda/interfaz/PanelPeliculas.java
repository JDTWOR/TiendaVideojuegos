/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelPeliculas.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.cupi2.videotienda.mundo.Pelicula;

/**
 * Panel para el manejo de las pel�culas
 */
public class PanelPeliculas extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando buscar pel�cula
     */
    private static final String BUSCAR = "buscar";

    /**
     * Comando agregar copia de pel�cula
     */
    private static final String AGREGAR_COPIA = "agregar_copia";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazVideotienda ventanaPrincipal;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    private JList<String> listaPeliculas;
    private JButton botonBuscar;
    private JButton botonCopia;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel para el manejo de las pel�culas
     * @param ventana Ventana principal de la aplicaci�n. ventana != null.
     */
    public PanelPeliculas( InterfazVideotienda ventana )
    {
        ventanaPrincipal = ventana;

        setBorder( BorderFactory.createTitledBorder( "Cat�logo de Pel�culas" ) );
        setLayout( new BorderLayout( ) );

        listaPeliculas = new JList<String>( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaPeliculas );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );

        botonBuscar = new JButton( );
        botonBuscar.setText( "Ver" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );

        botonCopia = new JButton( );
        botonCopia.setText( "Agregar Copia" );
        botonCopia.setActionCommand( AGREGAR_COPIA );
        botonCopia.addActionListener( this );

        JPanel panel = new JPanel( );
        panel.add( botonBuscar );
        panel.add( botonCopia );
        add( panel, BorderLayout.SOUTH );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Actualiza el listado de pel�culas
     * @param peliculas Listado de las pel�culas. peliculas != null.
     */
    public void actualizarPeliculas( ArrayList<Pelicula> peliculas )
    {
        String[] lista = new String[peliculas.size( )];

        for( int i = 0; i < peliculas.size( ); i++ )
            lista[ i ] = peliculas.get( i ).darTitulo( );

        listaPeliculas.removeAll( );
        listaPeliculas.setListData( lista );
    }

    /**
     * Retorna el t�tulo de la pel�cula seleccionada en la lista
     * @return t�tulo de la pel�cula seleccionada. Si no hay ninguna seleccionada retorna null.
     */
    public String darPeliculaSeleccionada( )
    {
        int p = listaPeliculas.getSelectedIndex( );
        if( p < 0 )
            return null;
        return ( String )listaPeliculas.getSelectedValue( );
    }

    /**
     * Responde a los eventos de los botones del panel
     * @param evento Evento generado por un bot�n. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        String titulo = darPeliculaSeleccionada( );
        if( comando.equals( BUSCAR ) )
        {
            if( titulo == null )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar una pel�cula", "Mostrar Pel�cula", JOptionPane.ERROR_MESSAGE );
                return;
            }
            ventanaPrincipal.mostrarPelicula( titulo );
        }
        else if( comando.equals( AGREGAR_COPIA ) )
        {
            if( titulo == null )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar una pel�cula", "Agregar Copia Pel�cula", JOptionPane.ERROR_MESSAGE );
                return;
            }
            ventanaPrincipal.agregarCopia( titulo );
        }
    }
}
