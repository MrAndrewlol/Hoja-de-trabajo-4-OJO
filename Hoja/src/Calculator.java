import java.util.ArrayList;


import structure5.*;

/**
 * @author José Prince
 * Utilizado de la hoja de trabajo No.2
 */
public class Calculator<T> {

	private PostFixCalculator<String> miListaInterna;
	private  AbstractStack<SinglyLinkedList<String>> listaLinkedList;
	private String data;
	private Vector<T> vector;
	private static boolean unicainstance = false;
	private static Calculator<String> calculadora;
	private int valor; //opcion para elegir linked o single o array o el vector
	
	public Calculator() {
		miListaInterna = new PostFixCalculator<String>(); 
		listaLinkedList = new SinglyLinkedList<T>();
		data = "";
		vector = new Vector<T>();
		unicainstance = true;
		valor = 0;

		
	}
	
	public static Calculator<String> getInstance() {
		if (unicainstance) {
			return calculadora;
		} else {
			calculadora = new Calculator<String>();
			return calculadora;
		}
	}

	

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void Calculatoton(int opcionnumero) {
		switch(opcionnumero){
			case 1:{ // Arraylist

			}
			case 2:{ //Vector
				miListaInterna.peek();
			}

			case 3:{//lista

			}
		}
		
	}






}
	