import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

public class Assignment1 {
	
	static String encryptedText = "";
	static String decryptedText = "";
	public static void main(String []args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException{
		JOptionPane.showMessageDialog(null, "The algorithm will only decrypt the message encrypted by this application if the key is not provided (Key been embedded to the system)", "The encrypter", JOptionPane.INFORMATION_MESSAGE);
		while(true){
			JFrame frame = new JFrame("InputDialog Example #1");
			Object[] choice = {"Encryption", "Decryption"};
			String favoriteChoice1 = null;
			while(favoriteChoice1==null){
				favoriteChoice1 = (String) JOptionPane.showInputDialog(frame, 
				        "What is the operation that you want to perform?",
				        "Please make your choice: ",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        choice, 
				        choice[0]);
				if(favoriteChoice1==null){
					System.exit(0);
				}
			}
			if(favoriteChoice1.equalsIgnoreCase("Encryption")){
				String ecText = null;
				while(ecText ==null|| ecText.equalsIgnoreCase("")){
					ecText = JOptionPane.showInputDialog("What is the text that you want to encrypted? (Cancel to exit)");
					if(ecText ==null){
						System.exit(0);
					}
					else if(ecText.equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(frame,"Please input something");
					}
				}
				
				Object[] choices = {"DES", "3DES", "RSA","AES","blowfish"};
				String favoriteChoice = null;
				while(favoriteChoice==null){
					favoriteChoice = (String) JOptionPane.showInputDialog(frame, 
					        "What is the algorithm that you want to user to encrypte text?",
					        "Please make your choice",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        choices, 
					        choices[0]);
					if(favoriteChoice==null){
						System.exit(0);
					}
				}
				if(favoriteChoice.equalsIgnoreCase("DES")){
					try{
						String des_Key = "";
						while(des_Key.length()<8){
							des_Key = JOptionPane.showInputDialog("What is the key that you want to use to encrypt the message? (The key size is 8 character)");//This des algo only use 56 + 8 parity bit as key length which means that key can only be 8 char or less
							if(des_Key==null){
								System.exit(0);
							}
							else if(des_Key.length()<8){
								JOptionPane.showMessageDialog(frame,"Please input a vaild key (The key must be more than 8 character, however the algorithm only take first 8 character)!!!");
							}
						}
						encryptedText = Cryptography_DES.encrypt(ecText, des_Key);
					}
					catch(Exception e){	
						JOptionPane.showMessageDialog(frame, "Error have occur");
						System.exit(0);
					}
				}
				else if(favoriteChoice.equalsIgnoreCase("3DES")){
					try {
						String DESede_Key = JOptionPane.showInputDialog("What is the key that you want to use to encrypt the message? (The key size must be more than 24 character, wrong input will cause error in generation of key and exit)");
						encryptedText = TripleDES.encrypt(ecText,DESede_Key);
					}
					catch(Exception e){	
						JOptionPane.showMessageDialog(frame, "Error have occur");
						System.exit(0);
					}
				}
				else if (favoriteChoice.equalsIgnoreCase("RSA")){
					JOptionPane.showMessageDialog(frame, "Warning, the RSA private key is stored in a file and if you do second time you will lost key first time generated!!!");
					encryptedText = RSA.Encrypt(ecText);
					RSA.saveKeyToFile();
				}
				else if(favoriteChoice.equalsIgnoreCase("AES")){
					try {
						encryptedText = AES.encrypt(ecText);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					try {
						blowfish.setUp();
						encryptedText = blowfish.encrypt(ecText);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Error have occur");
						System.exit(0);
					}
					
				}
				JTextArea text = new JTextArea(encryptedText);
				JOptionPane.showMessageDialog(frame, text, "Encrypted Text is :",JOptionPane.INFORMATION_MESSAGE);
			}
			if(favoriteChoice1.equalsIgnoreCase("Decryption")){
				String deText = null;
				while(deText ==null|| deText.equalsIgnoreCase("")){
					deText = JOptionPane.showInputDialog("What is the text that you want to decrypted? (Cancel to exit)");
					if(deText ==null){
						System.exit(0);
					}
					else if(deText.equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(frame,"Please input something");
					}
				}
				
				Object[] choices = {"DES", "3DES", "RSA","AES","blowfish"};
				String favoriteChoice = null;
				while(favoriteChoice==null){
					favoriteChoice = (String) JOptionPane.showInputDialog(frame, 
					        "What is the algorithm that you want to user to decrypte text?",
					        "Please make your choice",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        choices, 
					        choices[0]);
					if(favoriteChoice==null){
						System.exit(0);
					}
				}
				if(favoriteChoice.equalsIgnoreCase("DES")){
					try{
						String des_Key = "";
						while(des_Key.length()<8){
							des_Key = JOptionPane.showInputDialog("What is the key that you want to use to decrypt the message? (The key size is 8 character)");//This des algo only use 56 + 8 parity bit as key length which means that key can only be 8 char or less
							if(des_Key==null){
								System.exit(0);
							}
							else if(des_Key.length()<8){
								JOptionPane.showMessageDialog(frame,"Please input a vaild key (The key must be more than 8 character, however the algorithm only take first 8 character)!!!");
							}
						}
						decryptedText = Cryptography_DES.decrypt(deText, des_Key);
					}
					catch(Exception e){	
						e.printStackTrace();
						JOptionPane.showMessageDialog(frame, "Error have occur");
						System.exit(0);
					}
				}
				else if(favoriteChoice.equalsIgnoreCase("3DES")){
					try {
						String DESede_Key = JOptionPane.showInputDialog("What is the key that you want to use to decrypt the message? (The key size must be more than 24 character, wrong input will cause error in generation of key and exit)");
						decryptedText = TripleDES.decrypt(deText,DESede_Key);
					}
					catch(Exception e){	
						JOptionPane.showMessageDialog(frame, "Error have occur");
						System.exit(0);
					}
				}
				else if (favoriteChoice.equalsIgnoreCase("RSA")){
					decryptedText = RSA.Decrypt(deText);
					RSA.saveKeyToFile();
				}
				
				else if(favoriteChoice.equalsIgnoreCase("AES")){
					try {
						decryptedText = AES.decrypt(deText);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					try {
						blowfish.setUp();
						decryptedText = blowfish.decrypt(deText);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Error have occur");
						System.exit(0);
					}
					
				}
				JTextArea text = new JTextArea(decryptedText);
				JOptionPane.showMessageDialog(frame, text, "Decrypted Text is :",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
