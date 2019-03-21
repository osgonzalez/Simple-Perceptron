import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	
	private String URL;

	public CSVReader(String uRL) {
		super();
		URL = uRL;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public ArrayList<double[]> parse() {
		ArrayList<double[]> toRet = new ArrayList<double[]>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(this.URL))){
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] splitLine = line.split(",");
				double[] intLine = new double[splitLine.length];
				
				for(int i=0; i<splitLine.length; i++) {
					intLine[i] = Double.parseDouble(splitLine[i]);
				}
				
				toRet.add(intLine);
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return toRet;

	}
	
	public void parsingPrint(ArrayList<double[]> arrayList) {
		for(double[] line : arrayList) {
			for(double value : line) {				
				System.out.print(value + ",");
			}
			System.out.println("");
		}
	}
	

}
