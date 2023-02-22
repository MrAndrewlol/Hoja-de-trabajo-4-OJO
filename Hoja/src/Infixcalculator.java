import java.util.ArrayList;
import structure5.*;

/**
 * @author Andre Jo
 * Utilizado de la hoja de trabajo No.2
 */
public class Infixcalculator<T> implements IStack<T>, IinfixCalculator {

	private ArrayList<T> miListaInterna;
	private SinglyLinkedList<T> milistaenlzada;
	private DoublyLinkedList<T> dobleenlazada;
	private Vector<T> itsvector;
	private int opcion;
	
	public Infixcalculator() {
		miListaInterna = new ArrayList<T>(); 
		milistaenlzada = new SinglyLinkedList<T>();
		dobleenlazada = new DoublyLinkedList<T>();
		itsvector = new Vector<T>();
		opcion = 0;
	}

	public Infixcalculator(ArrayList<T> miListaInterna, SinglyLinkedList<T> milistaenlzada, DoublyLinkedList<T> dobleenlazada, Vector<T> itsvector, int opcion) {
		this.miListaInterna = miListaInterna;
		this.milistaenlzada = milistaenlzada;
		this.dobleenlazada = dobleenlazada;
		this.itsvector = itsvector;
		this.opcion = opcion;
	}
	
	
	/** 
	 * @return int
	 * Cuenta los elementos del stack
	 */
	@Override
	public int count() {
		int lista = 0;

		switch(opcion){
			case 1:{ //arraylist
				lista = miListaInterna.size();

			}

			case 2:{ //singlelinkedlist
				lista = milistaenlzada.size();

			}
			
			case 3:{// Double linked list
				lista = dobleenlazada.size();
			}

			case 4:{// Vector
				lista = itsvector.size();

			}

		}
		return lista;
	}

	
	/** 
	 * @return boolean
	 * Indica si no hay elementos en el stack
	 */
	@Override
	public boolean isEmpty() {
		boolean verdadofalso = false;

		switch(opcion){
			case 1:{ //arraylist
				verdadofalso = miListaInterna.isEmpty();

			}

			case 2:{ //singlelinkedlist
				verdadofalso = milistaenlzada.isEmpty();

			}
			
			case 3:{// Double linked list
				verdadofalso = dobleenlazada.isEmpty();
			}

			case 4:{// Vector
				verdadofalso = itsvector.isEmpty();

			}

		}
		return verdadofalso;

		
	}

	
	/** 
	 * @param value
	 * Añade un dato a la pila
	 */
	@Override
	public void push(T value) {
		switch(opcion){
			case 1:{ //arraylist
				miListaInterna.add(0, value);

			}

			case 2:{ //singlelinkedlist
				milistaenlzada.add(0, value);

			}
			
			case 3:{// Double linked list
				dobleenlazada.add(0, value);
			}

			case 4:{// Vector
				itsvector.add(0, value);

			}

		}
	}

	
	/** 
	 * @return T
	 * Quita el primer dato de la pila
	 */
	@Override
	public T pull() {
		T quitar = null; 

		switch(opcion){
			case 1:{ //arraylist
				quitar = miListaInterna.remove(0);

			}

			case 2:{ //singlelinkedlist
				quitar = milistaenlzada.remove(0);

			}
			
			case 3:{// Double linked list
				quitar = dobleenlazada.remove(0);
			}

			case 4:{// Vector
				quitar =  itsvector.remove(0);

			}
		}
		return quitar;
	}

	
	/** 
	 * @return T
	 * Obtiene el dato de la primera posición del stack
	 */
	@Override
	public T peek() {	
		
		T quitar = null; 

		switch(opcion){
			case 1:{ //arraylist
				quitar = miListaInterna.get(0);

			}

			case 2:{ //singlelinkedlist
				quitar = milistaenlzada.get(0);

			}
			
			case 3:{// Double linked list
				quitar = dobleenlazada.get(0);
			}

			case 4:{// Vector
				quitar =  itsvector.get(0);

			}
		}
		return quitar;
		
	}

	
	/** 
	 * @param operandos
	 * @return boolean
	 * Muestra si solo hay un elemento en el stack
	 */
	public boolean isOneItem(IStack operandos){
		boolean oneItem = false;
		if (miListaInterna.size() == 1){
			oneItem = true;
		}
		return oneItem;
	}

	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una suma
	 */
	public int suma(int a, int b){
		return a + b;
	}

	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una resta
	 */
	public int resta(int a, int b){
		return a - b;
	}
	
	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una multiplicación
	 */
	public int multiplicacion(int a, int b){
		return a * b;
	}
	
	
	/** 
	 * @param a
	 * @param b
	 * @return int
	 * Hace una división
	 */
	public int division(int a, int b){
		return a/b;
	}
	
	
	/** 
	 * @param item
	 * @return boolean
	 * Indica si un elemento es un operador
	 */
	public boolean isOperator(String item){
			boolean operator = false;
			if (item.matches("[+,-,*,/]")){
				operator = true;
			}
		return operator;
	}
	
	
	


	public int getOpcion() {
		return this.opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	

}

