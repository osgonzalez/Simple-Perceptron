import java.util.Arrays;

public class Perceptron {
	
	private double[] pesos;
	private int numeroInputs;
	private static final double TASA_APRENDIZAJE = 0.5d;
	private static final String NUMERO_INPUTS_INCORRECTO = "Error!, El numero de Inputs "
			+ "proporcionado no se corresponde con el numero de Inputs del perceptron";
	
	
	
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


	public int calcularOutput(double[] inputs) throws Exception {
		if(inputs.length != this.numeroInputs) {
			throw new Exception(NUMERO_INPUTS_INCORRECTO);
		}
		
		double suma = 0;
		
		for(int i=0; i<this.numeroInputs; i++) {
			suma += inputs[i] * this.pesos[i];
		}
		
		return suma >= 0 ? 1 : -1;
	}
	
	public boolean entrenar(double[][] listaInputs, int[] listaResultadosEsperados , int numIteracionesMaximas) throws Exception {
		boolean entrenamientoCorrectamenteFinalizado = false;
		int numIteracionActual = 0;
		while(!entrenamientoCorrectamenteFinalizado && numIteracionActual < numIteracionesMaximas) {
			entrenamientoCorrectamenteFinalizado = true;
			
			for(int i=0; i < listaInputs.length; i++) {
				
				int outputObtenido = calcularOutput(listaInputs[i]);
				int outputEsperado = listaResultadosEsperados[i];
				
				String log = listaInputs[i] + " => " + "outputEsperado: " + outputEsperado
						+ " ,outputObtenido: " + outputObtenido;
				
				if(outputObtenido != outputEsperado) {
					entrenamientoCorrectamenteFinalizado = false;
					recalcular(listaInputs[i], outputObtenido, outputEsperado);
					log += " (Error)";
					break;
				}
				
				System.out.println(log);
			}
				
			
			
		}
		
		return entrenamientoCorrectamenteFinalizado;
	}
	

	public void recalcular(double[] inputs, int outputObtenido, int outputEsperado) {
		
	}
	
}
