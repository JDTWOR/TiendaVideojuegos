/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: CopiaTest.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
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

/**
 * Clase para probar la clase Copia
 */
public class CopiaTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * La copia 1 de prueba
     */
    private Copia copia1;

    /**
     * La copia 2 de prueba
     */
    private Copia copia2;

    /**
     * La película 1 de prueba
     */
    private String tituloPelicula1;

    /**
     * La película 2 de prueba
     */
    private String tituloPelicula2;
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Prepara el escenario de prueba
     */
    private void setupEscenario1( )
    {
        tituloPelicula1 = "Retroceder nunca, rendirse jamás XVII";
        copia1 = new Copia( tituloPelicula1, 1 );
        tituloPelicula2 = "El Gran Pez";
        copia2 = new Copia( tituloPelicula2, 2 );
    }
    /**
     * Verificar el método darConsecutivo
     */
    public void testDarCodigo( )
    {
        setupEscenario1( );

        assertEquals( "El consecutivo está equivocado", 1, copia1.darCodigo( ) );
        assertEquals( "El consecutivo está equivocado", 2, copia2.darCodigo( ) );
    }

    /**
     * Valida el método que retorna el título de la película de una copia
     */
    public void testDarTituloPelicula( )
    {
        setupEscenario1( );

        String t = copia1.darTituloPelicula( );
        assertEquals( "El título de la película 1 es incorrecto", tituloPelicula1, t );
        String t2 = copia2.darTituloPelicula( );
        assertEquals( "El título de la película 2 es incorrecto", tituloPelicula2, t2 );
    }

    /**
     * Valida el método de comparación entre copias
     */
    public void testEsIgualA( )
    {
        setupEscenario1( );

        assertFalse( copia1.esIgualA( copia2 ) );
        Copia otra = new Copia( copia1.darTituloPelicula( ), copia1.darCodigo( ) );
        assertTrue( copia1.esIgualA( otra ) );
    }
}
