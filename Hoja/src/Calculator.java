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
				int valorA = 0;
				int valorB = 0;
			
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
						for (int i = 0; i < estalista.size(); i++){
							if ( listaString[i].matches("[+,-,*,/]")){
								valorA = Integer.valueOf(estalista.get(i-1));
								valorB = Integer.valueOf(estalista.get(i-2));
								switch(listaString[i]){
									case "+":{
										valorA = miListaInterna.suma(valorA, valorB);
										estalista.removeAll(estalista);
										estalista.add(String.valueOf(valorA));
										
										break;
									}
									case "-":{
										valorA = miListaInterna.resta(valorA, valorB);
										estalista.removeAll(estalista);
										estalista.add(String.valueOf(valorA));
										
										break;
										
									}
									case "*":{
										valorA = miListaInterna.multiplicacion(valorA, valorB);
										estalista.removeAll(estalista);
										estalista.add(String.valueOf(valorA));
										
										break;
										
									}
									case "/":{
										valorA = miListaInterna.division(valorA, valorB);
										estalista.removeAll(estalista);
										estalista.add(String.valueOf(valorA));
										
										break;
										
									}
								}
						}

					}
				}
					while(estalista.size()> 1){
						operador = miListaInterna.peek();
						miListaInterna.pull();
						valorA = Integer.valueOf(estalista.get(estalista.size()-2));
						valorB = Integer.valueOf(estalista.get(estalista.size()-1));
						
							switch(operador){
								case "+":{
									valorA = miListaInterna.suma(valorA, valorB);
									estalista.removeAll(estalista);
									estalista.add(String.valueOf(valorA));
									
									break;
								}
								case "-":{
									valorA = miListaInterna.resta(valorA, valorB);
									estalista.removeAll(estalista);
									estalista.add(String.valueOf(valorA));
									
									break;
									
								}
								case "*":{
									valorA = miListaInterna.multiplicacion(valorA, valorB);
									estalista.removeAll(estalista);
									estalista.add(String.valueOf(valorA));
									
									break;
									
								}
								case "/":{
									valorA = miListaInterna.division(valorA, valorB);
									estalista.removeAll(estalista);
									estalista.add(String.valueOf(valorA));
									
									break;
									
								}
							}

					}
				System.out.println("El resultado es de " +estalista.get(0));
				estalista.removeAll(estalista);
				decision = true;
			}
			break;
		}
			case 2:{ //lista single
				 boolean decision = false;
				 int valorA = 0;
				 int valorB = 0;
			
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
						 for (int i = 0; i < estalista.size(); i++){
							 if ( listaString[i].matches("[+,-,*,/]")){
								 valorA = Integer.valueOf(estalista.get(i-1));
								 valorB = Integer.valueOf(estalista.get(i-2));
								 switch(listaString[i]){
									 case "+":{
										 valorA = miListaInterna.suma(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
									 }
									 case "-":{
										 valorA = miListaInterna.resta(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
									 case "*":{
										 valorA = miListaInterna.multiplicacion(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
									 case "/":{
										 valorA = miListaInterna.division(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
								 }
						 }
 
					 }
				 }
					 while(estalista.size()> 1){
						 operador = miListaInterna.peek();
						 miListaInterna.pull();
						 valorA = Integer.valueOf(estalista.get(estalista.size()-2));
						 valorB = Integer.valueOf(estalista.get(estalista.size()-1));
						 
							 switch(operador){
								 case "+":{
									 valorA = miListaInterna.suma(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
								 }
								 case "-":{
									 valorA = miListaInterna.resta(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
								 case "*":{
									 valorA = miListaInterna.multiplicacion(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
								 case "/":{
									 valorA = miListaInterna.division(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
							 }
 
					 }
				 System.out.println("El resultado es de " +estalista.get(0));
				 estalista.removeAll(estalista);
				 decision = true;
			 }
			 break;
			}

			case 3:{//lista
				 // Arraylist
				 boolean decision = false;
				 int valorA = 0;
				 int valorB = 0;
				 
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
						 for (int i = 0; i < estalista.size(); i++){
							 if ( listaString[i].matches("[+,-,*,/]")){
								 valorA = Integer.valueOf(estalista.get(i-1));
								 valorB = Integer.valueOf(estalista.get(i-2));
								 switch(listaString[i]){
									 case "+":{
										 valorA = miListaInterna.suma(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
									 }
									 case "-":{
										 valorA = miListaInterna.resta(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
									 case "*":{
										 valorA = miListaInterna.multiplicacion(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
									 case "/":{
										 valorA = miListaInterna.division(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
								 }
						 }
 
					 }
				 }
					 while(estalista.size()> 1){
						 operador = miListaInterna.peek();
						 miListaInterna.pull();
						 valorA = Integer.valueOf(estalista.get(estalista.size()-2));
						 valorB = Integer.valueOf(estalista.get(estalista.size()-1));
						 
							 switch(operador){
								 case "+":{
									 valorA = miListaInterna.suma(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
								 }
								 case "-":{
									 valorA = miListaInterna.resta(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
								 case "*":{
									 valorA = miListaInterna.multiplicacion(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
								 case "/":{
									 valorA = miListaInterna.division(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
							 }
 
					 }
				 System.out.println("El resultado es de " +estalista.get(0));
				 estalista.removeAll(estalista);
				 decision = true;
			 }
			 break;
			}
			case 4:{//lista doble

				 // Arraylist
				 boolean decision = false;
				 int valorA = 0;
				 int valorB = 0;
				 
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
						 for (int i = 0; i < estalista.size(); i++){
							 if ( listaString[i].matches("[+,-,*,/]")){
								 valorA = Integer.valueOf(estalista.get(i-1));
								 valorB = Integer.valueOf(estalista.get(i-2));
								 switch(listaString[i]){
									 case "+":{
										 valorA = miListaInterna.suma(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
									 }
									 case "-":{
										 valorA = miListaInterna.resta(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
									 case "*":{
										 valorA = miListaInterna.multiplicacion(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
									 case "/":{
										 valorA = miListaInterna.division(valorA, valorB);
										 estalista.removeAll(estalista);
										 estalista.add(String.valueOf(valorA));
										 
										 break;
										 
									 }
								 }
						 }
 
					 }
				 }
					 while(estalista.size()> 1){
						 operador = miListaInterna.peek();
						 miListaInterna.pull();
						 valorA = Integer.valueOf(estalista.get(estalista.size()-2));
						 valorB = Integer.valueOf(estalista.get(estalista.size()-1));
						 
							 switch(operador){
								 case "+":{
									 valorA = miListaInterna.suma(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
								 }
								 case "-":{
									 valorA = miListaInterna.resta(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
								 case "*":{
									 valorA = miListaInterna.multiplicacion(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
								 case "/":{
									 valorA = miListaInterna.division(valorA, valorB);
									 estalista.removeAll(estalista);
									 estalista.add(String.valueOf(valorA));
									 
									 break;
									 
								 }
							 }
 
					 }
				 System.out.println("El resultado es de " +estalista.get(0));
				 estalista.removeAll(estalista);
				 decision = true;
			 }
				break;
			}
		}


		
		
	}

	public void CalculatoPost(int opcionnumero, String listaString[]) { //Infix osea 1 2 + a  1 + 2
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
	