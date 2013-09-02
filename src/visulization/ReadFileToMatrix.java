
package visulization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import visulization.Pairs;
/***
 * Written by lina on 2013/08/26
 */

public class ReadFileToMatrix {
	
	String fileName;
	
	public ReadFileToMatrix(String fileName){
		this.fileName = fileName;
	}

	public HashMap<Pairs, Integer> ToMatrix(){
		try{
			
			File file = new File (fileName);
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			
			HashMap<Pairs, Integer> matrix = new HashMap<Pairs, Integer>();
			
			String line;

			while( (line = in.readLine()) != null ){
				int j = 0;
				
				String temp[] = new String[3];
				for(String date : line.split("\t")){
					temp[j++] = date;
				}
				
				if(!temp[0].equals(temp[1]) && Integer.parseInt(temp[2]) != 0){
					
					Pairs tempPair = new Pairs(temp[0],temp[1]);
					//System.out.println(tempPair + temp[2]);
				
					matrix.put(tempPair,Integer.parseInt(temp[2]));
				}
			}
			in.close();
			return matrix;
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return null;		
	}
			
}