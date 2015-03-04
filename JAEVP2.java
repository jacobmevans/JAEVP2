
import java.util.Scanner;



public class JAEVP2 {
	
	public static class Node{
		
		boolean terminal;
		int outDegree;
		Node[] children;
		Node root;
		
		Node(){
		terminal = false;
		outDegree = 0;
	    children = new Node[26];
		}
		
		
	//Function that creates an empty root node at start of program.
	public void createEmptyNode(){
		
		Node newNode = new Node();
		newNode.terminal = false;
		root = newNode;
	}
	
	
	//Function that returns false if s is already present, true otherwise.
	public boolean insert(String s){
		
		
	    
	    
	    Node temp = root;
	    
	    for(int i = 0; i < s.length(); i++){
	    	
	    	int pos = s.charAt(i) - 'a';
	    	
	    	if(temp.children[pos] == null){
	    		temp.children[pos] = new Node();
	    		temp.outDegree++;
	    		
	    		
	    		if(i == s.length() - 1){
		    		
		    		temp.children[pos].terminal = true;
		    		
		    		return true;
		    	}
	    	} 		
	    	
	    	
	    	temp = temp.children[pos];
	    }
	    
		return false;
		
	}
	
	//Function that returns true if s is present, false otherwise.
	boolean isPresent(String s){
		
		Node temp = root;
		
		for(int i = 0; i < s.length(); i++){
			    	
			    	int pos = s.charAt(i) - 'a';
			    	
			    	if(temp.children[pos] == null){
			    		return false;
			    	}
			    		
			    		if(i == s.length() - 1){	
			    			if(temp.children[pos].terminal == true){
			    				return true;
			    			}
			    		}
			    			    	
			    	temp = temp.children[pos];
		}
		return false;
				
	}
	
	//Function that returns false is s is not present, true otherwise.
	boolean delete(String s){
		
		return false;
		
	}
	
	//Function that returns the number of words in the data structure.
	int membership(){
		
		Node temp = root;
		int wordCount = 0;
		
		for(int i = 0; i < 26; i++){
			
			if (temp.children[i] == null){
				
				
				
			}
				if (temp.children[i] != null){
					temp.children[i].membership();
				}
			
		}
		return 0;
	}
	
	//Function that lists all members of the Trie in alphabetical order.
	void listAll(){
		
		//Code for listAll
		
	}
	}
	
	 public static void main(String[] args) {
	        
	        Node Trie = new Node();
	        Trie.createEmptyNode();
	   
	        
	        Scanner sc = new Scanner(System.in); // switch the comments before submitting
	        //Scanner sc = new Scanner(new File("p115sd1.txt"));
	        String line = "";
	        boolean done = false;
	        
	        while(!done) {
		        line = sc.nextLine();
		        String [] tokens = line.split(" ");
				switch(tokens[0]) {
		        
				    //Case N, returns name.
		            case "N": {
		            
		                System.out.println("Jacob Evans");
		                break;
		                
		            }
		           
		            //Case A, calls insert and returns "Word inserted/Word Already Exists" upon completion.
		            case "A": {
		           
		            	boolean insert = Trie.insert(tokens[1]);
		            	
		            	if(insert == true){
		            		System.out.println("Word Inserted");
		            	}else{
		            		System.out.println("Word Already Exists");
		            	}
		            	
		            	break;
		            	
		            }
		            
		            //Case D, calls delete and returns "Word deleted/Word not present" upon completion.
		            case "D": {
		            
		            	boolean delete = Trie.delete(tokens[1]);
		                if(delete == true){
		                	System.out.println("Word Deleted");
		                }else{
		                	System.out.println("Word not present");
		                }
		                
		                break;
		                
		            }
		            
		            //Case S, calls isPresent and returns "Word found/Word not found" upon completion.
		            case "S": {
		        
		                boolean isPresent = Trie.isPresent(tokens[1]);
		                
		                if(isPresent == true){
		                	System.out.println("Word found");	                	
		                }else{
		                	System.out.println("Word not found");
		                }
		                
		            	break;
		            	
		            }
		            
		            //Case M, calls membership and returns "Membership is ####" where #### is the number of words in the Trie.
		            case "M":{
		            	
		            	int Membership = Trie.membership();
		            	
		            	System.out.println("Membership is " + Membership);
		            	
		            	break;
		            }
		            
		            //Case C, checks the input against the existing Trie for spelling mistakes, returning "Spelling mistake" if word is not found.
		            case "C":{
		            	
		            	
		            }
		            
		            //Case L, calls listAll which prints all of the words in the Trie in alphabetical order, one per line.
		            case"L":{
		            	
		            	Trie.listAll();
		            	
		            }
		            
		            case "E": {
		            	
		                done = true;
		                break;
		                
		            }
		            
		        } // end of switch

	        }//end of while
	  }//end of  main
}//End of file

	    
	    

