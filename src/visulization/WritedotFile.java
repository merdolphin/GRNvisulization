package visulization;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import visulization.Pairs;

public class WritedotFile {
	
	
	HashMap<Pairs, Integer> matrix = new HashMap<Pairs, Integer>();
	
	public WritedotFile(HashMap<Pairs, Integer> matrix){
		this.matrix = matrix;		
	}

	public void Writing(){
		
		String line1 = "digraph graphname{";
		
		
		String endline = "}";
	
		try{
			File file = new File("test_data//result.dot");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(line1);
			output.newLine();
			
			for(Pairs key: matrix.keySet()){
				String line2 = "\t" + key.getSource() + "->" + key.getTarget();
				output.write(line2);
				output.newLine();
			}
			
			output.write(endline);
			output.close();
		} catch( IOException e ){
			e.printStackTrace();
		}
	}
}


