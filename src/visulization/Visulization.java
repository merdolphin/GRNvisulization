/***
 * Written by lina on 2013/08/30
 */

package visulization;

import java.util.HashMap;

import visulization.ReadFileToMatrix;
import visulization.Pairs;
import visulization.GUIblueprint;
import visulization.WritedotFile;

public class Visulization{
	

	public static void main(String[] args) {
	
		HashMap<Pairs, Integer>mydate = new HashMap<Pairs, Integer>();
	
		ReadFileToMatrix myReading = new ReadFileToMatrix("test_data//finalnetwork.txt") ;
		
		mydate = myReading.ToMatrix();
		
		WritedotFile myWriting = new WritedotFile(mydate);
		myWriting.Writing();
		
		
		GUIblueprint.run();

	}
}