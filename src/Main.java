
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://n3vrax.wordpress.com/2011/08/14/aesrijndael-java-implementation/
 * @author David S
 *
 */
public class Main {
	
	public static void main(String[] args) {		
		try{
			//AES
			String plainText;
			 long startTime = System.currentTimeMillis();
		      long total = 0;

			/**From file*/
//			plainText = readFromFile("File/short-input.txt");
//			plainText = readFromFile("File/medium-input.txt");
//			plainText = readFromFile("File/large-input.txt");
			/**Hardcode mode*/
			plainText = "makan nasi";			

			/**Key Algorithm*/
			String k = "kriptografi";
			System.out.println("Plain Text: "+plainText);
			byte[] enc = AES.encrypt(plainText.getBytes(), k.getBytes());
			System.out.println("Encrypted text AES: "+new String(enc));
			
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println(elapsedTime);
			
			
			byte[] dec = AES.decrypt(enc, k.getBytes());
			System.out.println("Decrypted text AES: "+new String(dec));
			System.out.println("------------------");
	

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Return string formatted after open a file
	 * @param path
	 * @return
	 */
	private static String readFromFile(String path) {	
		String results = "";
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(path));
 
			while ((sCurrentLine = br.readLine()) != null) {
				results+=sCurrentLine;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return results;
	}

}
