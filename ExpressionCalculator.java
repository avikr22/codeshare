package com.practice;


import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator
{

	public static void main(String[] args)
	{
		List<String> result = keypadPermutaion("45");
		System.out.println("Total possible combinations of characters  \n" + result.size());
		System.out.println("The final result  \n" + result);
	}


	public static List<String> keypadPermutaion(String input) {
		char[][] keyOptions=new char[][]{
			{'a','b','c','0'},{'d','e','f','1'},{'g','h','i','2'},{'j','k','l','3'},
			{'m','n','o','4'},{'p','q','r','5'},{'s','t','u','6'},{'v','w','x','7'},
			{'y','8'},{'z','9'}
		};

		List<String> tempList = new ArrayList<>();
		List<String> resList = new ArrayList<>();

		if(input.length() == 0) {
			 resList.add("Passed input is Null");
			 return resList;
		}
		//
		for(int i = input.length()-1; i>=0; i--){
			int num = input.charAt(i) - '0';
			System.out.println("Picked number in loop is " + num);
			if(resList.isEmpty()){
				for(char c:keyOptions[num]){
					resList.add(String.valueOf(c));
				}
				System.out.println("List after 1 iteration: " + resList);
			}else{
				for(char c:keyOptions[num]){			
					String key=String.valueOf(c);
					for(String s:resList){
						tempList.add(key+s);
					}
				}
				System.out.println("List after " + (input.length() - i) +  " iterations: " + tempList);
				List<String> swap = resList;
				resList = tempList;
				tempList = swap;
				tempList.clear();
			}
		}
		
		System.out.println("################################################################");
		return resList;
	}
}