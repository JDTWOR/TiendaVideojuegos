/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelAlquiladasCliente.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
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

import uniandes.cupi2.videotienda.mundo.Copia;

/**
 * Panel para presentar las pel�culas alquiladas de un cliente
 */
public class PanelAlquiladasCliente extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando devolver alquilada
     */
    private static final String DEVOLVER = "devolver";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private DialogoConsultaCliente dialogo;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    private JList<String> listaAlquiladas;
    private JButton botonDevolver;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel para la lista de pel�culas alquiladas del cliente
     * @param elDialogo Dialogo d�nde se presenta el panel. elDialogo != null.
     */
    public PanelAlquiladasCliente( DialogoConsultaCliente elDialogo )
    {
        dialogo = elDialogo;

        setBorder( BorderFactory.createTitledBorder( "Pel�culas Alquiladas" ) );
        setLayout( new BorderLayout( ) );

        listaAlquiladas = new JList<String>( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaAlquiladas );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );

        botonDevolver = new JButton( );
        botonDevolver.setText( "Devolver" );
        botonDevolver.setActionCommand( DEVOLVER );
        botonDevolver.addActionListener( this );

        JPanel panel = new JPanel( );
        panel.add( botonDevolver );
        add( panel, BorderLayout.SOUTH );

    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Actualiza el listado de clientes
     * @param alquiladas Listado de clientes. clientes != null.
     */
    public void actualizarAlquiladas( ArrayList<Copia> alquiladas )
    {
        String[] lista = new String[alquiladas.size( )];
        Copia c;

        for( int i = 0; i < alquiladas.size( ); i++ )
        {
            c = alquiladas.get( i );
            lista[ i ] = c.darTituloPelicula( ) + " (" + c.darCodigo( ) + ")";
        }

        listaAlquiladas.removeAll( );
        listaAlquiladas.setListData( lista );
    }

    /**
     * Retorna el �ndice de la copia de pel�cula seleccionada
     * @return �ndice pel�cula seleccionada.
     */
    public int darCopiaSeleccionada( )
    {
        return listaAlquiladas.getSelectedIndex( );
    }

    /**
     * Responde a los eventos de los botones del panel
     * @param evento Evento generado por un bot�n. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        int copiaS = darCopiaSeleccionada( );

        if( comando.equals( DEVOLVER ) )
        {
            if( copiaS == -1 )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar una copia de pel�cula", "Devolver Pel�cula", JOptionPane.ERROR_MESSAGE );
                return;
            }

            String pelicula = ( String )listaAlquiladas.getSelectedValue( );
            pelicula = pelicula.substring( 0, pelicula.indexOf( "(" ) ).trim( );

            String sCopia = ( String )listaAlquiladas.getSelectedValue( );
            sCopia = sCopia.substring( sCopia.indexOf( "(" ) + 1, sCopia.indexOf( ")" ) );

            int copia = Integer.parseInt( sCopia );
            dialogo.devolver( pelicula, copia );
        }
    }
}
