import java.io.*;
import java.util.*;

class LetterFrequencyAttack {
	public BufferedReader bf;
	public Map<String, Integer> map = new HashMap<String, Integer>();

	public LetterFrequencyAttack() {
		
	}

	public void read() throws IOException {
			 bf = new BufferedReader(new FileReader("ciphertext.txt"));
	}

	public void close() throws IOException {
		bf.close();
	}

	public void test() throws IOException {
		int c;
		while ((c = bf.read()) != -1) {
			System.out.print((char)(c));	
		}
	}

	public void map() throws IOException {
		int c;
		String s;
		char ch;
		while ((c = bf.read()) != -1) {
			ch = Character.toUpperCase((char)c);
			if (!Character.isLetter(ch)) continue;
			s = Character.toString(ch);
			if (! map.containsKey(s))
				map.put(s, 1);
			else 
				map.put(s, map.get(s) + 1);
		}
	}

	public Map.Entry<String, Integer> maxEntry() {
		Map.Entry<String, Integer> max = null;
		for (Map.Entry<String, Integer> current : map.entrySet()) {
			if (max == null) max = current;
			else if (max.getValue() < current.getValue())
				max = current;
		}
		return max;
		
	}


	public void decrypt(int shift) throws IOException {
		int c;
		char ch;



		while ((c = bf.read()) != -1) {
			ch = (char)c;
			if (ch >= 'A' && ch <= 'Z') 
				ch = (char)((c - 'A' - shift + 26) % 26 + 'A');
			System.out.print(ch);
		}

	}





	public static void main(String[] args) throws IOException {
		LetterFrequencyAttack lfa = new LetterFrequencyAttack();
		lfa.read();
		lfa.map();
		lfa.close();

		int shift = 0;
		Map.Entry<String, Integer> max;
	

		for (int i = 0; i < 10; ) {
		System.out.println();
		i++;	
		System.out.println("top " + i);
		System.out.println("-----------");
		max = lfa.maxEntry();
		shift = max.getKey().charAt(0) - 'E';
		System.out.printf("shift: %d\n", shift);
		lfa.read();
		System.out.print("plaintext: ");
		lfa.decrypt(shift);	
		lfa.map.remove(max.getKey());	
		System.out.println();
		}
	


//		max = lfa.maxEntry();
//		System.out.println(max);
//		shift = max.getKey().charAt(0) - 'E';
//		System.out.printf("shift: %d\n", shift);
//		lfa.read();
//		lfa.decrypt(shift);
	}





}







