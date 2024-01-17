package util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptUtil {
	public static String hashPassword(String plainPassword) {
		return BCrypt.withDefaults().hashToString(12, plainPassword.toCharArray());
	}

	public static boolean verifyPassword(String inputPassword, String storePassword) {
		return BCrypt.verifyer().verify(inputPassword.toCharArray(), storePassword).verified;
	}
	
}
