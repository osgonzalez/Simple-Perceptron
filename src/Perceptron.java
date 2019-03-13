import java.util.Arrays;

public class Perceptron {
	
	private double[] pesos;
	private int numeroInputs;
	private static final double TASA_APRENDIZAJE = 0.5d;
	
	
	
	
	public Perceptron(int numeroInputs) {
		super();
		this.numeroInputs = numeroInputs;
	}
	
	
	//Inicializa los pesos con valores aleatorios
	public void inicializar() {
		this.pesos = new double[this.numeroInputs];
		for(int i = 0 ;  i< this.numeroInputs ; i++) {
			this.pesos[i] = Math.random() > 0.5 ? Math.random() : Math.random() * -1;
		}
	}
	
	public double[] getPesos() {
		return pesos;
	}
	public int getInputs() {
		return numeroInputs;
	}
	public static double getTasaAprendizaje() {
		return TASA_APRENDIZAJE;
	}


	@Override
	public String toString() {
		StringBuilder toRet = new StringBuilder();
		toRet.append(" -------- Perceptron -------- ");
		for(int i = 0; i< this.numeroInputs; i++) {
			toRet.append("\n peso["+i+"] = " + this.pesos[i]);
		}
		return toRet.toString();
	}


	
	

}
