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
	

	private Calculator() throws SingletonException {
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

	public void Calculatotinfix(int opcionnumero, String listaString[]) { //Infix osea 1+2 a 1 2 +
		miListaInterna.setOpcion(opcionnumero);
		String listainterna[] = listaString;
		String datus;
		String operador;
		ArrayList<String> estalista = new ArrayList<>();
		
		switch(opcionnumero){
			case 1:{ // Arraylist
				boolean decision = false;
				while(decision == false){
					for (int e = 0; e < listainterna.length; e ++){
						if ( listaString[e].matches("[0-9]*")){
							datus = listaString[e];
							estalista.add(datus);

						}
					
						if ( listaString[e].matches("[+,-,*,/]")){
							miListaInterna.push(listaString[e]);
							
						}

						if ( listaString[e].matches("[)]")){
							datus = estalista.get(estalista.size()-1);
							operador = miListaInterna.peek();
							estalista.add(operador);
							miListaInterna.pull();

						}	
						
					}
					while(miListaInterna.isEmpty() == false){
						String datoameter;
						datoameter = miListaInterna.peek();
						miListaInterna.pull();
						estalista.add(datoameter);
						
						decision = true;

					}
					int valorA = 0;
					int valorB = 0;
					
					for (int i = estalista.size(); i > 0; i--){
						
						System.out.println(miListaInterna.peek());//llego hasta uno
						if ( estalista.get(i-1).matches("[0-9]*")){
							valorA = Integer.valueOf(miListaInterna.peek());
							miListaInterna.pull();
						if ( estalista.get(i-1).matches("[0-9]*")){	
							valorB = Integer.valueOf(miListaInterna.peek()); 
							miListaInterna.pull();						

						}

							
						
						if ( listaString[estalista.size()-i].matches("[+,-,*,/]")){
							operador = miListaInterna.peek();
							miListaInterna.pull();
							switch(operador){
								case "+":{
									valorA = miListaInterna.suma(valorA, valorB);
								}
								case "-":{
									valorA = miListaInterna.resta(valorA, valorB);
									
								}
								case "*":{
									valorA = miListaInterna.multiplicacion(valorA, valorB);
									
								}
								case "/":{
									valorA = miListaInterna.division(valorA, valorB);
									
								}
							}
							
						}
					}
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

	public void CalculatoPost(int opcionnumero, String listaString[]) { //Infix osea 1+2 a 1 2 +
		miListaInterna.setOpcion(opcionnumero);
		String listainterna[] = listaString;
		ArrayList<String> estalista = new ArrayList<>();
		
		switch(opcionnumero){
			case 1:{ // Arraylist
					for (int e = 0; e < listainterna.length; e ++){
						if ( listaString[e].matches("[+,-,*,/]")){
							miListaInterna.push(listaString[e]);
							System.out.println(miListaInterna.peek()); //print
							
						}
						else if (listaString[e].matches("[0-9]*")){
							estalista.add(listaString[e]);
							System.out.println(estalista.get(0));


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
	