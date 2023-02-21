import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PruebasCalculadora<T> {
    
    PostFixCalculator<T> calculadora = new PostFixCalculator<>();
    Calculator calculos = new Calculator();
    Infixcalculator<T> calculadorain = new Infixcalculator<>();
    

    @Test
    public void sumaTest(){
        int resultado = calculadora.suma(2, 4);
        assertEquals(6,resultado);
    }

    @Test
    public void restaTest(){
        int resultado = calculadora.resta(2, 4);
        assertEquals(-2, resultado);
    }

    @Test 
    public void multiplicacionTest(){
        int resultado = calculadora.multiplicacion(2, 4);
        assertEquals(8, resultado);
    }

    @Test
    public void divisionTest(){
        int resultado = calculadora.division(4, 2);
        assertEquals(2, resultado);
    }

    @Test
    public void calculadorapost(){

        String listaString[] = {"1" ,"9", "*"};
        int numero = calculos.CalculatoPost(1, listaString);
        assertEquals(9, numero);
    }
    @Test
    public void calculadorainfix(){

        String listaString[] = {"(","1","+","2",")","*","2"};
        int numero = calculos.Calculatotinfix(1, listaString);
        assertEquals(6, numero);
    }

    @Test
    public void calculadorain(){
        String[] lista = new String[1];
        lista[0] = "T";
        calculadora.push((T) "String");
        assertEquals(0, calculadora.count());
    }
}