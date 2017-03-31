import java.io.IOException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.swing.JOptionPane;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TripleDES {
	
	private static final String CRYPTOGRAPHY_ALGO_3DES = "DESede";
	private static Cipher cipher = null;
	private static DESedeKeySpec keySpec = null;
	private static SecretKeyFactory keyFactory = null;
	
	public static String encrypt(String inputString, String commonKey)throws InvalidKeyException, IllegalBlockSizeException,BadPaddingException {
		String encryptedValue = null;
		SecretKey key = getSecretKey(commonKey);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] inputBytes = inputString.getBytes();
		byte[] outputBytes = cipher.doFinal(inputBytes);
		encryptedValue = new BASE64Encoder().encode(outputBytes);
	 	return encryptedValue;
	 }
	public static String decrypt(String encryptedString, String commonKey)throws InvalidKeyException, IllegalBlockSizeException,BadPaddingException, IOException {
		String decryptedValue = "";
		// When Base64Encoded strings are passed in URLs, '+' character gets converted to space and so we need to reconvert the space to '+' and since encoded string cannot have space in it so we are completely safe.
		encryptedString = encryptedString.replace(' ', '+');
		SecretKey key = getSecretKey(commonKey);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] recoveredBytes = cipher.doFinal(new BASE64Decoder().decodeBuffer(encryptedString));
		decryptedValue = new String(recoveredBytes);
		return decryptedValue;
	}
	private static SecretKey getSecretKey(String secretPassword) {
		SecretKey key = null;
		try {
			cipher = Cipher.getInstance(CRYPTOGRAPHY_ALGO_3DES);
			keySpec = new DESedeKeySpec(secretPassword.getBytes("UTF8"));
			keyFactory = SecretKeyFactory.getInstance(CRYPTOGRAPHY_ALGO_3DES);
			key = keyFactory.generateSecret(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error generation of the key, the system exit.");
		}
		return key;
	}
 }