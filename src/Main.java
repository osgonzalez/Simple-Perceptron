import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//runORGatePerceptron();
		
		runWeigthSizePerceptron();

	}
	
	public static void runORGatePerceptron() throws Exception {
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
		
		System.out.println("\n"+perceptron);
	}
	
	public static void runWeigthSizePerceptron() throws Exception {
		Perceptron perceptron = new Perceptron(4);
		perceptron.inicializar();
		
		System.out.println(perceptron);
		
		CSVReader csvReader = new CSVReader("./Dataset Weigth-Size.csv");
		ArrayList<double[]> datosArrayList = csvReader.parse();
		
		csvReader.parsingPrint(datosArrayList);

		double[][] listaInputs = new double[datosArrayList.size()][];
		int[] listaResultadosEsperados = new int[datosArrayList.size()];
		
		for(int i=0; i<datosArrayList.size(); i++) {
			double[] lineaDato = datosArrayList.get(i);
			listaResultadosEsperados[i] = (int) lineaDato[lineaDato.length-1]; 
			lineaDato[lineaDato.length-1] = 1; //Parametro por defecto
			listaInputs[i] = lineaDato;
		}
		

		int numIteracionesMaximas = 6;	
		
		perceptron.entrenar(listaInputs, listaResultadosEsperados, numIteracionesMaximas);
		
		
		
		
		for(int i=0; i < listaInputs.length; i++) {
			int outputObtenido = perceptron.calcularOutput(listaInputs[i]);
			int outputEsperado = listaResultadosEsperados[i];
			
			System.out.println(Arrays.toString(listaInputs[i]) + " => " + "outputEsperado: " + outputEsperado
					+ " ,outputObtenido: " + outputObtenido + (outputObtenido != outputEsperado ? " (Error)" : " (Correcto)"));
		}
		
		System.out.println("\n"+perceptron);
		
		calcularPorcentajeAcierto(perceptron, listaInputs, listaResultadosEsperados);
	}
	
	
	public static void calcularPorcentajeAcierto(Perceptron perceptron, double[][] listaInputs, 
			int[] listaResultadosEsperados) throws Exception {
		
		float aciertos = 0;
		
		for(int i=0; i < listaInputs.length; i++) {
			int outputObtenido = perceptron.calcularOutput(listaInputs[i]);
			int outputEsperado = listaResultadosEsperados[i];
			
			if(outputObtenido == outputEsperado) {
				aciertos++;
			}
		}
		float totales = listaResultadosEsperados.length;
		float porcentageAciertos = (aciertos / totales) * 100;
		
		System.out.println("\nEl perceptron ha obtenido un acierto del "+ porcentageAciertos + "% (" +
				aciertos + " de " + listaResultadosEsperados.length + ")");
	}

}
