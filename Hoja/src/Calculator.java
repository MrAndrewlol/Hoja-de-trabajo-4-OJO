import java.util.ArrayList;

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

	
	/** 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	
	/** 
	 * @param opcionnumero
	 * @param ArrayList<>();switch(opcionnumero
	 */
	public void Calculatotinfix(int opcionnumero, String listaString[]) { //Infix osea 1+2 a 1 2 +
		miListaInterna.setOpcion(opcionnumero);
		String listainterna[] = listaString;
		String datus;
		String operador;
		ArrayList<String> estalista = new ArrayList<>();
		

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
		}


	public void CalculatoPost(int opcionnumero, String listaString[]) { //Infix osea 1 2 + a  1 + 2
		milistapostfix.setOpcion(opcionnumero);
		String listainterna[] = listaString;
		ArrayList<String> estalista = new ArrayList<>();
		
			 // Arraylist
				int pi = 0;
					for (int e = 0; e < listainterna.length; e ++){

						if ( listaString[e].matches("[+,-,*,/]")){
							milistapostfix.push(listaString[e]);
							System.out.println(milistapostfix.peek()); //print
							pi--;
							
						}
						else if (listaString[e].matches("[0-9]*")){
							estalista.add(listaString[e]);
							System.out.println(estalista.get(pi));
						}
						pi++;
					}
					int opinion = estalista.size()-1;
					while(milistapostfix.isEmpty() == false){
						
						estalista.add(opinion, milistapostfix.peek());
						milistapostfix.pull();
						opinion = opinion - 1;

					}
					int valorA = 0;
					int valorB = 0;
					boolean suii = true;
					String sentence = "";
					for(int z = 0;z < estalista.size(); z++){
						sentence = sentence + estalista.get(z);
					}
					

					for(int b = 0;b < estalista.size()-1; b++){
						if (estalista.get(b).matches("[*,/]")){
							valorA = Integer.valueOf(estalista.get(b+1));
							valorB = Integer.valueOf(estalista.get(b-1));
							switch(estalista.get(b)){
								case "*":{
									valorA = milistapostfix.multiplicacion(valorA, valorB);
									estalista.remove(b+1);
									estalista.remove(b);
									estalista.remove(b-1);
									
									estalista.add(String.valueOf(valorA));
									b = 0;
									suii = false;
									

									break;
									
								}
								case "/":{
									valorA = milistapostfix.division(valorA, valorB);
									estalista.remove(b+1);
									estalista.remove(b);
									estalista.remove(b-1);
									estalista.add(String.valueOf(valorA));
									b = 0;
									suii = false;
									
									break;
									
								}
							}

						}
						
						if (estalista.get(b).matches("[-,+]" )& suii == false){
							valorA = Integer.valueOf(estalista.get(b+1));
							valorB = Integer.valueOf(estalista.get(b-1));
							switch(estalista.get(b)){
								case "+":{
									valorA = milistapostfix.suma(valorA, valorB);
									estalista.remove(b+1);
									estalista.remove(b);
									estalista.remove(b-1);
									
									estalista.add(0, String.valueOf(valorA));
									b = 0;
									

									break;
									
								}
								case "-":{
									valorA = milistapostfix.resta(valorA, valorB);
									estalista.remove(b+1);
									estalista.remove(b);
									estalista.remove(b-1);
									
									estalista.add(String.valueOf(valorA));
									b = 0;
									
									break;
									
								}
							}

						}

					}
					System.out.println("El resultado es "+ sentence +  " es " +estalista.get(0));
					
				




		
		
	}
	


	
	/** 
	 * @return int
	 */
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}





}
	