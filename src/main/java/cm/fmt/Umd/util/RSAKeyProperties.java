package cm.fmt.Umd.util;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.stereotype.Component;
@Component
public class RSAKeyProperties {
	private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;
	public RSAKeyProperties() { 
		KeyPair keyPair=KeyGenerator.getGeneratedKey();
		this.publicKey =(RSAPublicKey)keyPair.getPublic();
		this.privateKey = (RSAPrivateKey)keyPair.getPrivate();
	}
	public RSAPublicKey getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(RSAPublicKey publicKey) {
		this.publicKey = publicKey;
	}
	public RSAPrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(RSAPrivateKey privateKey) {
		this.privateKey = privateKey;
	}
    

}
