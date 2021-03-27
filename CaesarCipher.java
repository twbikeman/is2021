public class CaesarCipher {

	public StringBuffer sb;
	public StringBuffer c = new StringBuffer();
	public int key;
	
	public CaesarCipher(String s, int k) {
		sb = new StringBuffer(s);
		key = k;
	}

	public void encrypt() {
		for (int i = 0; i < sb.length(); i++) {
			c.append((char)(((int)sb.charAt(i) - 65 + this.key)%26 + 65));
		}
		
	}


	
	public static void main(String[] args) {
		CaesarCipher cc = new CaesarCipher("TEST", 5);
		System.out.println(cc.sb);		
		cc.encrypt();
		System.out.println(cc.c);
	}

}
