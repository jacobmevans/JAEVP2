
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;


public class JAEVP2 {
	
		public static class Node{
			
			boolean terminal;	//Variable to show Node makes a word.
			int outDegree;		//Variable to keep track of number of children Node has.
			Node[] children;	//Array variable to represent the 26 letters of the English alphabet.
			Node root;			//Node element to represent the root node of the Trie.
			int wordCount = 0;	//Variable to count words.
			
			
			Node(){
				terminal = false;			//Initialize to false, new Node is not a word unless end of word.
				outDegree = 0;				//Initialize to 0, new Node has no children.
			    children = new Node[26];	//Initialize array to size 26 for the English alphabet.
			}//end of Node Constructor
			
			
		//Function that creates an empty root node at start of program.
		public void createEmptyNode(){
			
			Node newNode = new Node();
			newNode.terminal = false;
			root = newNode;
		}//end of createEmptyNode
		
		
		//Function that returns false if s is already present, true otherwise.
		public boolean insert(String s){
			
		    Node temp = root;
		   
		    for(int i = 0; i < s.length(); i++){
		    	
		    	int pos = s.charAt(i) - 'a';	//Variable to track letter of string.
		    	
		    	if(temp.children[pos] == null){	//If current's child is null create a new node to link current to new.
		    		
		    		temp.children[pos] = new Node();
		    		temp.outDegree++;	//Since current has a new child increment its outDegree.
		    		if(i == s.length() - 1){	//If the next letter is last.
			    		
			    		temp.children[pos].terminal = true;	//Set last char of word to terminal, since it is end of word.
			    		return true;	//Word successfully inserted, return true.	
			    	}
		    	} 		
		    	temp = temp.children[pos];	//Increment to subtree.
		    }
			return false;
		}//end of insert
		
		//Function that returns true if s is present, false otherwise.
		boolean isPresent(String s){
			
			Node temp = root;
			
			for(int i = 0; i < s.length(); i++){
				    	
				    	int pos = s.charAt(i) - 'a';	//Variable to track letter of string.
				    	
				    	if(temp.children[pos] == null){	//If current's child is null return false, as it is not in the Trie.
				    		return false;
				    	}
				    		
				    	if(i == s.length() - 1){	//If the next letter is last.
				    		if(temp.children[pos].terminal == true){	//If current's child is terminal, word exists: return true.
				    		return true;
				    		}
				    	}		    	
				    	temp = temp.children[pos];	//Increment to subtree
			}
			return false;
					
		}//end of isPresent.
		
		boolean delete(String s){
			return delete(s, root);
		}
		//Function that returns false is s is not present, true otherwise.
		boolean delete(String s, Node rootNode){
			
			
			
			
			Node parent = rootNode;
			Node temp = rootNode;
			for(int i = 0; i < s.length(); i++){
			
				int pos = s.charAt(i) - 'a';
				System.out.println(pos);
				parent = temp;
				temp = temp.children[pos];
				
				if(i == s.length() -1){
										
					if(temp.outDegree >= 1){	//If temporary has an outDegree of 1 or greater.
						System.out.println("outDegree greate than 1");
						temp.terminal = false;	//Set temporary's terminal value to false.
						return true;
					}else if(parent.outDegree > 1){	//Else if no children and parent has another child.
						System.out.println("no children and parent has another child");
						parent.children[pos] = null;
						return true;
					}else if (parent.outDegree == 1){	//Else if no children and parent has no other children.
						System.out.println("no children and parent has no other children");
						parent.children[pos] = null;
						delete(s.substring(0, s.length() - 1));
						return true;
					}
				}
				
			}
			
			return false;
			
		}//end of delete
		
		
		public int membership(){	//Initial public call from main that sends root into private call.
			wordCount = 0;
			return membership(root);
		}
		
		//Function that returns the number of words in the data structure.
		private int membership(Node rootNode){
			
			for(int i = 0; i < 26; i++){	//Iterate through the current root's subtrees.
				
				if (rootNode == null){	//If root itself is null, return 0;
					return 0;
				}else if(rootNode.children[i] != null){
					
					if(rootNode.children[i].terminal == true){	//If child of rootNode at current position is a terminal increment wordCount.
						wordCount++;
					}
					 membership(rootNode.children[i]);	//Recursive call to search current rootNode's subtrees.
				}
			}
			return wordCount;
		}//end of membership.
		
		
		void listAll(){
			listAll("",root);
		}
		//Function that lists all members of the Trie in alphabetical order.
		void listAll(String s, Node rootNode){
			
			if (rootNode == null){	//If root itself is null, return 0.
				
			}else{	
				if(rootNode.terminal == true){	//If root is a terminal print out the string with a newline.
					System.out.println(s);
				}
				for(int i = 0;i < 26; i ++){	
					if(rootNode.children[i] != null){	//If child of rootNode at current position is not null, recurse.
						listAll(s + (char)(i+'a'), rootNode.children[i]); //Recursive call to keep going down the subtree.
					}
				}
			}	
		}
		
	}
	
	 public static void main(String[] args) {
	        
	        Node Trie = new Node();	//Create new node to represent root.
	        Trie.createEmptyNode();	//Initialize Trie to an empty root node.
	   
	        
	        Scanner sc = new Scanner(System.in); 
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
		            	
		            	for(int i = 1; i < tokens.length; i++){
		            	
		            		boolean isPresent = Trie.isPresent(tokens[i]);
		            		
		            		if(!isPresent){
		            			System.out.println("Spelling mistake " + tokens[i]);
		            		}
		            	}
		            	break;
		            }
		            
		            //Case L, calls listAll which prints all of the words in the Trie in alphabetical order, one per line.
		            case"L":{
		            	
		            	Trie.listAll();
		            	break;
		            	
		            }
		            
		            case "E": {
		            	
		                done = true;
		                break;
		                
		            }
		            
		        } // end of switch

	        }//end of while
	  }//end of  main
}//End of file

	    
	    

