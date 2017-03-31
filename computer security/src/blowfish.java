import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * This program demonstrates how to encrypt/decrypt input
 * using the Blowfish Cipher with the Java Cryptograhpy.
 *
 */
public class blowfish {
	 
    private static String algorithm = "Blowfish";
    private static Key key = null;
    private static Cipher cipher = null;
    
    public static void setUp() throws Exception {
        key = KeyGenerator.getInstance(algorithm).generateKey();
        cipher = Cipher.getInstance(algorithm);
    }
    public static String encrypt(String input)throws InvalidKeyException, BadPaddingException,IllegalBlockSizeException {
  	  	String encryptedValue = null;
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        byte[] outputBytes = cipher.doFinal(inputBytes);
        encryptedValue = new BASE64Encoder().encode(outputBytes);
        return encryptedValue;
    }

    public static String decrypt(String encryptedString)throws InvalidKeyException, BadPaddingException,IllegalBlockSizeException, IOException {
  	  	encryptedString = encryptedString.replace(' ', '+');
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(new BASE64Decoder().decodeBuffer(encryptedString));
        String recovered = new String(recoveredBytes);
        return recovered;
    }
}