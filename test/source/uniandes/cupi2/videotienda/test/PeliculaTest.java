/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PeliculaTest.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.videotienda.test;

import junit.framework.TestCase;
import uniandes.cupi2.videotienda.mundo.Copia;
import uniandes.cupi2.videotienda.mundo.Pelicula;

/**
 * Esta es la clase para probar la clase Película
 */
public class PeliculaTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * La película de prueba
     */
    private Pelicula pelicula;

    /**
     * Título de la película de prueba
     */
    private String titulo;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Prepara el escenario 1 con una película con 2 copias disponibles
     */
    private void setupEscenario1( )
    {
        titulo = "Retroceder nunca, rendirse jamás XVII";
        pelicula = new Pelicula( titulo );
    }

    /**
     * Prepara el escenario 2 con una película con 2 copias disponibles
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );
        pelicula.agregarCopia( );
        pelicula.agregarCopia( );
    }

    /**
     * Prepara el escenario 3 con una película con 1 copia disponible y 1 alquilada
     */
    private void setupEscenario3( )
    {
        setupEscenario2( );
        pelicula.alquilarCopia( );
    }

    /**
     * Prueba la creación básica de una película
     */
    public void testCreacion( )
    {
        setupEscenario1( );

        assertEquals( titulo, pelicula.darTitulo( ) );
        assertEquals( 0, pelicula.darTotalCopias( ) );
    }

    /**
     * Prueba la adición de copias a las películas
     */
    public void testAdicionarCopia( )
    {
        setupEscenario2( );

        assertEquals( 2, pelicula.darTotalCopias( ) );
    }

    /**
     * Valida
     */
    public void testAlquilarCopia( )
    {
        setupEscenario2( );

        Copia copia1 = pelicula.alquilarCopia( );
        assertEquals( titulo, copia1.darTituloPelicula( ) );
        assertEquals( 2, copia1.darCodigo( ) );
        assertEquals( 1, pelicula.darNumeroDisponibles( ) );

        Copia copia2 = pelicula.alquilarCopia( );
        assertEquals( titulo, copia2.darTituloPelicula( ) );
        assertEquals( 1, copia2.darCodigo( ) );
        assertEquals( 0, pelicula.darNumeroDisponibles( ) );

        assertFalse( copia1.esIgualA( copia2 ) );

        copia2 = pelicula.alquilarCopia( );
        assertNull( copia2 );
    }

    /**
     * Prueba la devolución de las copias alquiladas
     */
    public void testDevolverCopia( )
    {
        setupEscenario3( );

        assertEquals( 1, pelicula.darNumeroDisponibles( ) );
        assertEquals( 2, pelicula.darTotalCopias( ) );
        try
        {
            pelicula.devolverCopia( 2 );
            assertEquals( 2, pelicula.darNumeroDisponibles( ) );
            assertEquals( 2, pelicula.darTotalCopias( ) );
        }
        catch( Exception e3 )
        {
            fail( "La copia alquilada se espera que sea la de código 2" );
        }

        try
        {
            pelicula.devolverCopia( 1 );
            fail( "No se espera que la copia 1 esté alquilada" );
        }
        catch( Exception e )
        {
            assertTrue( "Esta excepción era esperada", true );
        }
    }
}
