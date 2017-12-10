package com.holonomix.hsqldb.model.utility;

import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {
	Cipher ecipher;
	Cipher dcipher;
	private static String key = "qweopd12!=nkvkj#34lnrj-~#kln*/";

	/**
	 * Input a string that will be md5 hashed to create the key.
	 * 
	 * @return void, cipher initialized
	 */

	private EncryptDecrypt() {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			this.setupCrypto(kgen.generateKey());
		} catch (Exception e) {

		}
	}

	private EncryptDecrypt(String key) {
		SecretKeySpec skey = new SecretKeySpec(getMD5(key), "AES");
		this.setupCrypto(skey);
	}

	private void setupCrypto(SecretKey key) {
		// Create an 8-byte initialization vector
		byte[] iv = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
				0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };

		AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
		try {
			ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			// CBC requires an initialization vector
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		} catch (Exception e) {

		}
	}

	// Buffer used to transport the bytes from one stream to another
	byte[] buf = new byte[1024];

	/**
	 * Input is a string to encrypt.
	 * 
	 * @return a Hex string of the byte array
	 */
	private String encrypt(String plaintext) {
		try {
			byte[] ciphertext = ecipher.doFinal(plaintext.getBytes("UTF-8"));
			return this.byteToHex(ciphertext);
		} catch (Exception e) {

			return null;
		}

	}

	/**
	 * Input encrypted String represented in HEX
	 * 
	 * @return a string decrypted in plain text
	 */
	private String decrypt(String hexCipherText) {
		try {
			String plaintext = new String(dcipher.doFinal(this
					.hexToByte(hexCipherText)), "UTF-8");
			return plaintext;
		} catch (Exception e) {

			return null;
		}
	}

	private static byte[] getMD5(String input) {
		try {
			byte[] bytesOfMessage = input.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			return md.digest(bytesOfMessage);
		} catch (Exception e) {
			return null;
		}
	}

	static final String HEXES = "0123456789ABCDEF";

	private static String byteToHex(byte[] raw) {
		if (raw == null) {
			return null;
		}
		final StringBuilder hex = new StringBuilder(2 * raw.length);
		for (final byte b : raw) {
			hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(
					HEXES.charAt((b & 0x0F)));
		}
		return hex.toString();
	}

	private static byte[] hexToByte(String hexString) {
		int len = hexString.length();
		byte[] ba = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			ba[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
					.digit(hexString.charAt(i + 1), 16));
		}
		return ba;
	}

	public static String encryptPassword(String password) {
		String cyphertext = null;
		try {

			EncryptDecrypt encrypter = new EncryptDecrypt(key);

			cyphertext = encrypter.encrypt(password);
			System.out.println(cyphertext);

		} catch (Exception e) {

		}
		return cyphertext;
	}

	public static String decryptPassword(String password) {
		try {

			EncryptDecrypt encrypter = new EncryptDecrypt(key);

			String plaintext = encrypter.decrypt(password);
			return plaintext;
		} catch (Exception e) {
			return null;

		}
	}

	public static void main(String args[]) {
		try {

			EncryptDecrypt encrypter = new EncryptDecrypt(key);

			String cyphertext = encrypter.encrypt("");
			System.out.println(cyphertext);

			String plaintext = encrypter
					.decrypt("C7D1916A599982DF3F3ABE292A84FF5A");
			System.out.println(plaintext);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
