package cm.fmt.Umd.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGenerator {

	public static KeyPair  getGeneratedKey() {
 
		KeyPair KeyPair;
		try {
			 
			KeyPairGenerator KeyPairGenerator=java.security.KeyPairGenerator.getInstance("RSA");
			KeyPairGenerator.initialize(2048);
			KeyPair=KeyPairGenerator.genKeyPair();
				
		}catch(Exception ex) {
			throw new IllegalStateException();
		}
		return KeyPair;
	}
}
