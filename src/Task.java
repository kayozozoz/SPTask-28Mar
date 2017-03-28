/**
 * @author Wang Xiaofan
 * 28 Mar 2017
 */
import java.util.*;
import java.io.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

public class Task {
	
	static HashMap <Character, String> numMap = new HashMap <Character, String>();
	static HashMap <Character, String> charMap = new HashMap <Character, String>();
	static HashSet <String> dictionary;

	public static void main(String[] args) throws IOException, BadLocationException {
		preprocessing();

		Scanner sc = new Scanner(System.in);

		while(true){
			System.out.println("Please enter the question number and input: ");
			int qnNum = sc.nextInt();
			String str = sc.next();
			
			if(qnNum == 1){
				System.out.println(qnOne(str));
			}else if(qnNum == 2){
				System.out.println(qnTwo(str));
			}else if(qnNum == 3){
				System.out.println(qnThree(str));
			}else if(qnNum == 4){
				System.out.println(qnFour(str));
			}else{
				break;
			}
		}
		sc.close();
	}
	
	public static int qnOne(String str){
		int length = str.length();
		int ans = 0;
		
		for(int i = 0; i < length; i++){
			int tmp = (charMap.get(str.charAt(i)).charAt(1)) - '0';  //get int from hashmap
			ans += tmp;
		}
		
		return ans;
		
	}
	
	public static String qnTwo(String str){
		int length = str.length();
		String ans = "";
		
		for(int i = 0; i < length; i++){
			char tmp = charMap.get(str.charAt(i)).charAt(0);  //get number combination from hashmap
			ans += tmp;
		}
		
		return ans;
		
	}
	
	public static LinkedList<String> qnThree(String str){
		LinkedList<String> queue = new LinkedList<String>();
		int length = str.length();
		String strRoot = "";
		queue.add(strRoot);
		int lengthOfWord = 1;
		
		for(int i = 0; i < length; i++){  //each digit
			String tmp = numMap.get(str.charAt(i));  //letters for the digit
			int tmpLength = tmp.length();
			
			if(tmpLength == 0){  //if '0' or '1' is pressed return null
				return null;
			}
			
			while(strRoot.length() < lengthOfWord){  //iterate through previous added strings
				queue.poll();
				for(int j = 0; j < tmpLength; j++){  //iterate through the letters
					queue.add(strRoot+tmp.charAt(j));  //add each digit to elements in queue
				}
				strRoot = queue.peek();
			}
			lengthOfWord++;  //for next round
		}
		return queue;
	}
	
	public static List<String> qnFour(String str){
		LinkedList<String> allwords = qnThree(str);  //to get all possible letter combinations
		if(allwords == null){  //if '0' or '1' is pressed return null
			return null;
		}
		List<String> ans = new LinkedList<String>();  //to store all possible words from dictionary
		
		while(!allwords.isEmpty()){
			String tmp = allwords.poll();
			if(dictionary.contains(tmp)){
				ans.add(tmp);
			}
		}
		return ans;
	}
	
	
	public static void preprocessing() throws IOException, BadLocationException{
		//for qn 3 + 4
		numMap.put('0', "");
		numMap.put('1', "");
		numMap.put('2', "abc");
		numMap.put('3', "def");
		numMap.put('4', "ghi");
		numMap.put('5', "jkl");
		numMap.put('6', "mno");
		numMap.put('7', "pqrs");
		numMap.put('8', "tuv");
		numMap.put('9', "wxyz");
		
		//for qn 1 + 2
		charMap.put('0', "01");
		charMap.put('1', "11");
		charMap.put('a', "21");
		charMap.put('b', "22");
		charMap.put('c', "23");
		charMap.put('d', "31");
		charMap.put('e', "32");
		charMap.put('f', "33");
		charMap.put('g', "41");
		charMap.put('h', "42");
		charMap.put('i', "43");
		charMap.put('j', "51");
		charMap.put('k', "52");
		charMap.put('l', "53");
		charMap.put('m', "61");
		charMap.put('n', "62");
		charMap.put('o', "63");
		charMap.put('p', "71");
		charMap.put('q', "72");
		charMap.put('r', "73");
		charMap.put('s', "74");
		charMap.put('t', "81");
		charMap.put('u', "82");
		charMap.put('v', "83");
		charMap.put('w', "91");
		charMap.put('x', "92");
		charMap.put('y', "93");
		charMap.put('z', "94");
		
		//for qn 4
		try {
			//IO for rtf file
			FileInputStream in = new FileInputStream("F:\\Projects\\SPTask\\src\\WordsRTF.rtf");
			RTFEditorKit kit = new RTFEditorKit();
			Document document = kit.createDefaultDocument();
			kit.read(in, document, 0);
			String text = document.getText(0, document.getLength());
			
			//convert text to hashset
			String[] tmp = text.split("\n");
			dictionary = new HashSet<String>(Arrays.asList(tmp));
			
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary not found");
		}	
	}	
}
