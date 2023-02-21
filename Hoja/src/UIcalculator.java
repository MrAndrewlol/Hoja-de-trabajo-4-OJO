import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * @author Andre Jo
 */

public class UIcalculator {
  
  /** 
   * @param args
   */
  public static <T> void main(String[] args) {
    Scanner in = new Scanner(System.in);
  
    Infixcalculator<String> infixcalculadora = new Infixcalculator<String>();
    PostFixCalculator<T> calculadora = new PostFixCalculator<>();
    Calculator incalculadora;  
    int a;
    int b;
    T resultado;
    int elswitch;
    String fpath;
    String data = "";
    String[] listaStrings;
    int opcionnumero;

    
    System.out.println("Bienvenido a la calculadora Postfix e Infix Calculator");
    System.out.println("1. Infix \n2. Postfix");
    System.out.println("Que Opcion desea realizar?");
    elswitch = in.nextInt();
    in.nextLine();
    System.out.println("\nAntes de eso desea usar \n1.Stack Vector \n2.Lista  \n3.Arraylist");
    opcionnumero = in.nextInt();
    in.nextLine();


    switch(elswitch){
        case 1:{ //Postfix a infix
            //Patron singleton
            incalculadora = Calculator.getInstance();
            System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
            fpath = in.nextLine();
            try {
                File myObj = new File(fpath);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                   data = myReader.nextLine();
                  System.out.println(data);
                  //Comienzo de la separación
                  listaStrings = data.split(" ");
                  incalculadora.setMiListaInterna(infixcalculadora);
                  incalculadora.Calculatotinfix(opcionnumero, listaStrings);
                  
                
                  }
                  
                  
                  

                
                myReader.close();
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

              


              //Ahora 

            break;
        }

        case 2:{ //Postfix
            System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
            fpath = in.nextLine();
            try {
                File myObj = new File(fpath);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                   data = myReader.nextLine();
                  System.out.println(data);
                  //calculadora.getItems(data);
                   listaStrings = data.split(" ");
                  for (int i = 0; i<listaStrings.length; i++){
                      if (listaStrings[i].matches("[0-9]*")){
                          calculadora.getItems(listaStrings[i]);
                          //listaPostFix = calculadora.getItems(data);
                      } else if (listaStrings[i].matches("[+,-,*,/]")){
                          if (calculadora.count() > 1){
                          switch (listaStrings[i]) {
                              case "+":
                                  b = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  a = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  resultado = (T) String.valueOf(calculadora.suma(a, b));
                                  calculadora.push(resultado);
          
                                  if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                                      System.out.println("Resultado: " + resultado);
                                      calculadora.pull();
                                  }
                                  break;
                              case "-":
                                  b = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  a = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  resultado = (T) String.valueOf(calculadora.resta(a, b));
                                  calculadora.push(resultado);
          
                                  if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                                      System.out.println("Resultado: " + resultado);
                                      calculadora.pull();
                                  }
                                  break;
                              case "*":
                                  b = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  a = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  resultado = (T) String.valueOf(calculadora.multiplicacion(a, b));
                                  calculadora.push(resultado);
          
                                  if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                                      System.out.println("Resultado: " + resultado);
                                      calculadora.pull();
                                  }
                                  break;
                              case "/":
                                  b = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  a = Integer.valueOf((String) calculadora.peek());
                                  calculadora.pull();
                                  
                                  if (b == 0){
                                      System.out.println("No se puede realizar la división entre 0");
                                      break;
                                  } else {
                                      resultado = (T) String.valueOf(calculadora.division(a, b));
                                      calculadora.push(resultado);
          
                                      if (listaStrings[listaStrings.length - 1] == listaStrings[i]){
                                          System.out.println("Resultado: " + resultado);
                                          calculadora.pull();
                                      }
                                  }
          
                                  break;
                              default:
                                  break;
                              }
                          } else {
                              System.out.println("Insuficientes operandos para el operador");
                          }
                          }
                      
                      }
                  }
                
                myReader.close();
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }


            
            break;
        }
        
        default: 
        System.out.println("Debe de ingresar una opcion valida");
        break;
    }

	  
	  
   
  }
}
