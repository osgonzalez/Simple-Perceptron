import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Perceptron perceptron = new Perceptron(3);
		perceptron.inicializar();
		
		System.out.println(perceptron);
		
		double[][] listaInputs = {{1,-1,-1},{1,-1,1},{1,1,-1},{1,1,1}};
		int[] listaResultadosEsperados = {-1,1,1,1};
		int numIteracionesMaximas = 200;	
		
		
		perceptron.entrenar(listaInputs, listaResultadosEsperados, numIteracionesMaximas);
		
		
		
		
		for(int i=0; i < listaInputs.length; i++) {
			int outputObtenido = perceptron.calcularOutput(listaInputs[i]);
			int outputEsperado = listaResultadosEsperados[i];
			
			System.out.println(Arrays.toString(listaInputs[i]) + " => " + "outputEsperado: " + outputEsperado
					+ " ,outputObtenido: " + outputObtenido + (outputObtenido != outputEsperado ? " (Error)" : " (Correcto)"));
		}

	}

}
