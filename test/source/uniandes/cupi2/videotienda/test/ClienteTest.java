/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: ClienteTest.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
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
import uniandes.cupi2.videotienda.mundo.Cliente;
import uniandes.cupi2.videotienda.mundo.Copia;

/**
 * Clase para probar la clase Cliente
 */
public class ClienteTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * El cliente para el escenario 1
     */
    private Cliente cliente;

    /**
     * Nombre del cliente de prueba
     */
    private String nombre;

    /**
     * Cédula del cliente de prueba
     */
    private String cedula;

    /**
     * dirección del cliente de prueba
     */
    private String direccion;

    /**
     * Título de la película de prueba
     */
    private String titulo;

    /**
     * La copia 1 de prueba
     */
    private Copia copia1;

    /**
     * La copia 2 de prueba
     */
    private Copia copia2;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Prepara el escenario 1 con un cliente y una película con dos copias disponibles
     */
    private void setupEscenario1( )
    {
        nombre = "Pedro Pérez";
        cedula = "1234567";
        direccion = "cll 1 # 1a01";
        cliente = new Cliente( cedula, nombre, direccion );

        titulo = "Retroceder nunca, rendirse jamás XVII";
    }

    private void setupEscenario2( )
    {
        setupEscenario1( );

        copia1 = new Copia( titulo, 1 );
        copia2 = new Copia( titulo, 2 );

        cliente.alquilarCopia( copia1 );
    }

    /**
     * Prueba la creación básica de un cliente de la videotienda
     */
    public void testCreacionCliente( )
    {
        setupEscenario1( );

        assertEquals( cedula, cliente.darCedula( ) );
        assertEquals( nombre, cliente.darNombre( ) );
        assertEquals( direccion, cliente.darDireccion( ) );
        assertEquals( 0, cliente.darSaldo( ) );
        assertEquals( 0, cliente.darAlquiladas( ).size( ) );
        assertEquals( 0, cliente.darNumeroAlquiladas( ) );
    }

    /**
     * Prueba las operaciones de incrementar y decrementar el saldo
     */
    public void testSaldo( )
    {
        setupEscenario1( );

        //Valida el incremento del saldo
        int incremento = 50000;
        cliente.cargarSaldo( incremento );
        assertEquals( incremento, cliente.darSaldo( ) );
        cliente.cargarSaldo( incremento );
        cliente.cargarSaldo( 0 );
        assertEquals( incremento * 2, cliente.darSaldo( ) );

        //Valida el decremento del saldo
        int decremento = 10000;
        cliente.descargarSaldo( decremento );
        assertEquals( incremento * 2 - decremento, cliente.darSaldo( ) );
        cliente.descargarSaldo( decremento );
        cliente.descargarSaldo( 0 );
        assertEquals( incremento * 2 - decremento * 2, cliente.darSaldo( ) );
    }

    /**
     * Prueba el alquiler de copias del cliente
     */
    public void testAlquilarCopia( )
    {
        setupEscenario2( );

        assertEquals( 1, cliente.darAlquiladas( ).size( ) );
        assertEquals( 1, cliente.darNumeroAlquiladas( ) );
        cliente.alquilarCopia( copia2 );
        assertEquals( 2, cliente.darAlquiladas( ).size( ) );
        assertEquals( 2, cliente.darNumeroAlquiladas( ) );

        Copia c = ( Copia )cliente.darAlquiladas( ).get( 0 );
        assertTrue( c.esIgualA( copia1 ) );

        c = ( Copia )cliente.darAlquiladas( ).get( 1 );
        assertTrue( c.esIgualA( copia2 ) );
    }

    /**
     * Prueba la búsqueda de copias en la lista de alquiladas
     */
    public void testBuscarCopiaAlquilada( )
    {
        setupEscenario2( );

        //Busca una copia que está en las alquiladas
        Copia c = cliente.buscarPeliculaAlquilada( titulo, copia1.darCodigo( ) );
        assertEquals( titulo, c.darTituloPelicula( ) );

        //Busca una copia que no está en las alquiladas
        c = cliente.buscarPeliculaAlquilada( titulo, copia2.darCodigo( ) );
        assertNull( c );

    }

    /**
     * Prueba la devolución de una copia alquilada
     */
    public void testDevolverCopia( )
    {
        setupEscenario2( );

        //Devuelve una copia que si está alquilada
        try
        {
            cliente.devolverCopia( titulo, copia1.darCodigo( ) );
            assertEquals( 0, cliente.darNumeroAlquiladas( ) );
        }
        catch( Exception e )
        {
            fail( "Esta copia debería estar alquilada y así dejarse devolver" );
        }

        //Devuelve una copia que no está alquilada
        try
        {
            cliente.devolverCopia( titulo, copia2.darCodigo( ) );
            fail( "Esta copia no está alquilada y no se puede devolver" );
        }
        catch( Exception e2 )
        {
            assertTrue( "Esta copia no debería estar alquilada y por lo tanto se espera la excepción", true );
        }
    }
}
