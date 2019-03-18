import java.util.Arrays;

public class Perceptron {
	
	private double[] pesos;
	private int numeroInputs;
	private static final double TASA_APRENDIZAJE = 0.1d;
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
//			System.out.println("peso["+i+"] * input["+i+"] = " + this.pesos[i] + " * " + inputs[i] +" = " + inputs[i] * this.pesos[i]);
			suma += inputs[i] * this.pesos[i];
		}
//		System.out.println("Suma:" + suma );
		return suma >= 0 ? 1 : -1;
	}
	
	public boolean entrenar(double[][] listaInputs, int[] listaResultadosEsperados , int numIteracionesMaximas) throws Exception {

		System.out.println("\n\n -------- Iniciando Entrenamiento -------- \n");
		
		boolean entrenamientoCorrectamenteFinalizado = false;
		int numIteracionActual = 0;
		while(!entrenamientoCorrectamenteFinalizado && numIteracionActual < numIteracionesMaximas) {
			System.out.println("\n -------- Iteracion ["+ (numIteracionActual+1) +"] -------- \n");
			entrenamientoCorrectamenteFinalizado = true;
			
			for(int i=0; i < listaInputs.length; i++) {
				
				int outputObtenido = calcularOutput(listaInputs[i]);
				int outputEsperado = listaResultadosEsperados[i];
				
				String log = Arrays.toString(listaInputs[i]) + " => " + "outputEsperado: " + outputEsperado
						+ " ,outputObtenido: " + outputObtenido;
				
				if(outputObtenido != outputEsperado) {
					entrenamientoCorrectamenteFinalizado = false;
					System.out.println(log + " (Error)");
					recalcular(listaInputs[i], outputObtenido, outputEsperado);
					break;
				}else {
					System.out.println(log + " (Correcto)");
				}
				
				
			}
				
			numIteracionActual++;
			
		}
		
		System.out.println("\n\n -------- Entrenamiento Finalizado " 
		+ (entrenamientoCorrectamenteFinalizado ? "Con Exito " : "Sin Exito ") 
		+ "-------- \n");
		
		return entrenamientoCorrectamenteFinalizado;
	}
	

	public void recalcular(double[] inputs, int outputObtenido, int outputEsperado) {
		
		StringBuilder log = new StringBuilder();
		log.append(" -------- Recalculando -------- ");

		//double error = outputEsperado - outputObtenido;
		double error = outputObtenido - outputEsperado;
		
		log.append("\nError = " + error);
		
		for(int i=0; i<this.numeroInputs; i++) {
			
			log.append("\n peso["+i+"] = " + this.pesos[i]);
			
			pesos[i] = pesos[i] + TASA_APRENDIZAJE * error;
			
			log.append(" => " + this.pesos[i]);
		}
		
//		System.out.println(log.toString());
	}
	
}
