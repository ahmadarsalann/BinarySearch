package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		BinarySearchTree<String> words = new BinarySearchTree<>();
		Scanner bob = new Scanner(System.in);
		try{
	    	File file = new File("words.txt");
	    	Scanner scan = new Scanner(file);
	    	while(scan.hasNextLine()){
	    		String data = scan.nextLine();
	    		words.insert(data);
			}//end of while

    	}catch(FileNotFoundException e){
			System.out.println("File not Found");
		}//end of catch
		System.out.println("Loaded the words into a tree with height = " + words.height());

		String input = "";
		boolean good = true;
		boolean alpha = true;
		int a = 0;
		String[] input2;
		while(alpha) {
			if (good) {
				input = bob.nextLine();
				if(input.contains("END")){
					good = false;
					alpha = false;
					continue;
				}
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) == ',' || input.charAt(i) == '.' || input.charAt(i) == '?' || input.charAt(i) == '"' || input.charAt(i) == ';' ||
							input.charAt(i) == ':' || input.charAt(i) == '[' || input.charAt(i) == ']' || input.charAt(i) == '!' || input.charAt(i) == '(' ||
							input.charAt(i) == ')' || input.charAt(i) == '&' || input.charAt(i) == '$' || input.charAt(i) == '%') {
						input = input.substring(0, i) + input.substring(i + 1);
						i--;
					}//end of if
				}//end of for
				input2 = input.split(" ");
				int c = 0;
				while(c != input2.length){
					String please = input2[c];
					String check = words.search(please);
					if(check == null){
						System.out.println("You spelled " + please + " wrong!!!!!!!!!!!");
					}//end of if
					c++;
				}//end of while

			}//end of else if
		}//end of main while

    }//end of static main
}//end of main