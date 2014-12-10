package cz.quazard.utils.encryption;

import java.security.MessageDigest;

public final class CryptUtils {
	private static final byte[] _xor_key = { 82, 33, -72, -51, 16, 108, 69, 60 };
	private static final char[] _hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/* zakoduje vstupni retezec */
	public static String createHash(String password) {
		try {
			byte[] pwd = password.getBytes("8859_1");
			byte[] buffer = new byte[16];
			int i, length = password.length() > 16 ? 16 : password.length();

			System.arraycopy(pwd, 0, buffer, 0, length);
			for (i = length; i < 16; i++)
				buffer[i] = 0x20;

			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(buffer);
			pwd = md.digest();
			StringBuffer hash = new StringBuffer(pwd.length * 2);
			for (i = 0; i < pwd.length; i++) {
				int num = (int) pwd[i];
				num &= 0x000000FF;
				hash.append(Integer.toHexString(num));
			}
			return hash.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.toString());
		}
	}

	private static void xor_data(byte[] data, byte[] key) {
		byte tmp;
		int i, k = 0;

		while (k < data.length) {
			for (i = 0; i < key.length; i++) {
				tmp = (byte) ((data[k] ^ key[i]) & 0x000000FF);
				data[k] = tmp;
				k++;
				if (k >= data.length)
					break;
			}
		}
	}

	private static final void byte2hex(byte b, StringBuffer buf) {
		int high = ((b & 0xF0) >> 4);
		int low = (b & 0x0F);
		buf.append(_hexChars[high]);
		buf.append(_hexChars[low]);
	}

	private static final byte hex2byte(int chigh, int clow) throws IllegalArgumentException {
		int k1 = (int) 'A';
		int k2 = (int) '0';

		int high = (chigh >= k1) ? chigh - k1 + 10 : chigh - k2;
		if (high > 15 || high < 0)
			throw new IllegalArgumentException("Ilegal char: " + (char) chigh);

		int low = (clow >= k1) ? clow - k1 + 10 : clow - k2;
		if (low > 15 || low < 0)
			throw new IllegalArgumentException("Ilegal char: " + (char) clow);

		return (byte) ((high << 4) + low);
	}

	private static final String toHexString(byte[] block) {
		int len = block.length;
		StringBuffer buf = new StringBuffer(2 * len);

		for (int i = 0; i < len; i++) {
			byte2hex(block[i], buf);
		}
		return buf.toString();
	}

	private static final byte[] fromHexString(String str_data) throws IllegalArgumentException {
		byte[] data = new byte[str_data.length() / 2];

		try {
			for (int i = 0, j = 0; i < data.length; i++, j += 2) {
				data[i] = hex2byte((int) str_data.charAt(j), (int) str_data.charAt(j + 1));
			}
			return data;
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Throwable ex) {
			throw new IllegalArgumentException(ex.toString());
		}
	}

	public static String crypt(String str_data) throws IllegalArgumentException {
		try {
			byte[] data = str_data.getBytes("8859_1");
			xor_data(data, _xor_key);
			return toHexString(data);
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Throwable ex) {
			throw new IllegalArgumentException(ex.toString());
		}
	}

	public static String decrypt(String hex_data) throws IllegalArgumentException {
		try {
			byte[] data = fromHexString(hex_data.toUpperCase()); // hexString2Bin( hex_data );
			xor_data(data, _xor_key);
			return new String(data, "8859_1");
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Throwable ex) {
			throw new IllegalArgumentException(ex.toString());
		}
	}

	private static void help() {
		System.out.println("Hash : java CryptUtils -hash value1 [value2 ... valueN]");
		System.out.println("Decryptovani : java CryptUtils -decrypt value1 [value2 ... valueN]");
		System.out.println("Cryptovani : java CryptUtils -crypt value1 [value2 ... valueN]");
		System.out.println("Help : java CryptUtils -help");
	}

	public static void main(String[] params) {
		try {
			// System.out.println(createHash("ahoj"));

			// System.out.print(EncryptionManager.getInstance().decrypt("uJJj/Ox4g8Q="));
			if (params.length > 0) {
				if (params[0].equals("-help")) {
					help();
				} else if (params[0].equals("-decrypt")) {
					for (int i = 1; i < params.length; i++) {
						System.out.println("Vlozeny slovo: " + params[i]);
						System.out.println("Dekryptovane slovo: " + decrypt(params[i]));
						System.out.println("-------------------------------------------------");
					}
				} else if (params[0].equals("-crypt")) {
					for (int i = 1; i < params.length; i++) {
						System.out.println("Vlozeny slovo: " + params[i]);
						System.out.println("Zakryptovane slovo: " + crypt(params[i]));
						System.out.println("-------------------------------------------------");
					}
				} else if (params[0].equals("-hash")) {
					for (int i = 1; i < params.length; i++) {
						System.out.println("Vlozeny slovo: " + params[i]);
						System.out.println("Hash: " + createHash(params[i]));
						System.out.println("-------------------------------------------------");
					}
				} else {
					System.out.println("Nespravne vstupne parametre");
					System.out.println("-------------------------------------------");
					help();
				}
			} else {
				System.out.println("Chybaju vstupne parametre");
				System.out.println("-------------------------------------------");
				help();
			}
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}

}