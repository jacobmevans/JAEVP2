import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
;


public class JAEVP2Test {

	@Test
	public void testInsertandDelete() throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("C:/Users/Jake/workspace/JAEVP2/textFile.txt"));
		JAEVP2.Node myNode = new JAEVP2.Node();
		myNode.createEmptyNode();
		String line = "";
		
		while(sc.hasNextLine()){
			line = sc.nextLine();
			boolean result = myNode.insert(line);
			assertTrue(result);
			System.out.println("Inserted word " + line);
		}
		myNode.listAll();
		int membership = myNode.membership();
		System.out.println(membership);
		
		Scanner scs = new Scanner(new File("C:/Users/Jake/workspace/JAEVP2/textFile.txt"));
		while(scs.hasNextLine()){
			line = scs.nextLine();
			boolean result = myNode.isPresent(line);
			assertTrue(result);
			System.out.println("Word found " + line);
		}
		
		Scanner scd = new Scanner(new File("C:/Users/Jake/workspace/JAEVP2/textFile.txt"));
		while(scd.hasNextLine()){
			line = scd.nextLine();
			boolean result = myNode.delete(line);
			assertTrue(result);
			System.out.println("Deleted word " + line);
		}
	      membership = myNode.membership();
		  System.out.println(membership);
	}

}
