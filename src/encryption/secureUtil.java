package encryption;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class secureUtil {
	private static final String RSA_ENC_ALG = "PBEWithMD5AndDES"; // 암호화 알고리즘
	private static String RSA_ENC_KEY;
	private static String AES_ENC_KEY;

	@Value("#{configProps['pass.rsaEncKey']}")
	public void setRsaEncKey(String key) {
		RSA_ENC_KEY = key;
	}

	@Value("#{configProps['pass.aesEncKey']}")
	public void setAesEncKey(String key) {
		AES_ENC_KEY = key;
	}

	/**
	 * @MethodName : decrypt
	 * @date : 2016. 12. 5.
	 * @author : jhkim
	 * @description : property 용 RSA 복호화
	 * @history : ----------------------------------------------------------------------- 변경일 작성자 변경내용 ----------- ------------------- --------------------------------------- 2016. 12. 5. jhkim 최초 작성 -----------------------------------------------------------------------
	 * 
	 * @param encText
	 * @return
	 */
	public static String decrypt(String encText) {
		if (!StringUtil.isNull(encText) && encText.matches("^ENC\\(.*\\)$")) {
			StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

			encryptor.setAlgorithm(RSA_ENC_ALG);
			encryptor.setPassword(RSA_ENC_KEY);

			return encryptor.decrypt(encText.replaceAll("^ENC\\(", "").replaceAll("\\)$", ""));
		}

		return encText;
	}

	/**
	 * @MethodName : encrypt
	 * @date : 2016. 12. 5.
	 * @author : jhkim
	 * @description : property 용 RSA 암호화.
	 * @history : ----------------------------------------------------------------------- 변경일 작성자 변경내용 ----------- ------------------- --------------------------------------- 2016. 12. 5. jhkim 최초 작성 -----------------------------------------------------------------------
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encrypt(String plainText) {
		if (!StringUtil.isNull(plainText)) {
			StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

			encryptor.setAlgorithm(RSA_ENC_ALG);
			encryptor.setPassword(RSA_ENC_KEY);

			return "ENC(" + encryptor.encrypt(plainText) + ")";
		}

		return plainText;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
