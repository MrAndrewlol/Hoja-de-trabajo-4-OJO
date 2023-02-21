/**
 * @author Seccion 10
 * //Utilizado de la hoja de trabajo 2
 */

 public interface ICalculator {
	
	String getData();
	
	void setData(String data);
	
	int Calculatotinfix(int opcionnumero, String listaString[]);
	
	int CalculatoPost(int opcionnumero, String listaString[]);


}