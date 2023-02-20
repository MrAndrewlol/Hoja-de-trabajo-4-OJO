import java.util.ArrayList;


import structure5.*;

/**
 * @author José Prince
 * Utilizado de la hoja de trabajo No.2
 */
public class Calculator {

	private Infixcalculator<String> miListaInterna;
	private PostFixCalculator<String> milistapostfix;
	private static boolean unicainstance = false;
	private static Calculator calculadora;
	private int valor; //opcion para elegir linked o single o array o el vector
	private String data;
	
	public Calculator() {
		data = "";
		unicainstance = true;
		valor = 0;
		miListaInterna = new Infixcalculator<>();
		milistapostfix = new PostFixCalculator<>();
	}


	public Calculator(Infixcalculator<String> miListaInterna,PostFixCalculator<String> milistapostfix, int valor, String data) {
		this.miListaInterna = miListaInterna;
		this.valor = valor;
		this.data = data;
		this.milistapostfix = milistapostfix;
	}
	

	
	
	/** 
	 * @return Calculator<String>
	 */
	public static Calculator getInstance() {
		if (unicainstance) {
			return calculadora;
		} else {
			calculadora = new Calculator();
			return calculadora;
		}
	}

	

	
	/** 
	 * @return String
	 */
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void Calculatoton(int opcionnumero, String listaString[]) {
		miListaInterna.setOpcion(opcionnumero);
		String listainterna[] = listaString;
		
		switch(opcionnumero){
			case 1:{ // Arraylist
				while(miListaInterna.isEmpty() ){
					for (int e = 0; e < listainterna.length; e ++){
						miListaInterna.push(listaString[e]);
						System.out.println(miListaInterna.peek()); //print
					}

				}


			}
			case 2:{ //lista single
				
				
			}

			case 3:{//lista

			}

			case 4:{//lista doble

			}
		}


		
		
	}


	public Infixcalculator<String> getMiListaInterna() {
		return this.miListaInterna;
	}

	public void setMiListaInterna(Infixcalculator<String> miListaInterna) {
		this.miListaInterna = miListaInterna;
	}

	public PostFixCalculator<String> getmilistapostfix() {
		return this.milistapostfix;
	}

	public void setmilistapostfix(PostFixCalculator<String> milistapostfix) {
		this.milistapostfix = milistapostfix;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}





}
	