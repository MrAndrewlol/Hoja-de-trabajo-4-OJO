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
  
    Calculator incalculadora;  
   
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
    System.out.println("\nAntes de eso desea usar \n1.Stack Arraylist \n2.Singlelinkedlist  \n3.Double linked \n4.Vector");
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

        case 2:{ //Postfix osea 1 1 +  a 1 + 1
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
                  
                  incalculadora.CalculatoPost(opcionnumero, listaStrings);
                  
                
                  }
                  
                  
                  

                
                myReader.close();
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

              


              //Ahora 

            break;
        }
        
        default: 
        System.out.println("Debe de ingresar una opcion valida");
        break;
    }

	  
	  
   
  }
}
