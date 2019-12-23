package com.single.etc;

import java.util.regex.Pattern;

// ´Ù¾çÇÑ À¯È¿¼º °Ë»ç¸¦ ÀúÀåÇÏ´Â Å¬·¡½º
public class Varidation {
	/** Null ¶Ç´Â ""ÀÌ¸é true ¹İÈ¯*/
	public static boolean isNullStr(String str) {
		if(str == null || str.equals("")) {
			return true;
		}
		return false;
	}
		
	/** ¾ÆÀÌµğ Çü½Ä¿¡ ¸Â´ÂÁö¸¦ È®ÀÎÇØ¼­ ¸ÂÀ¸¸é true ´Ù¸£¸é false ¹İÈ¯
	 * ¿µ¹®ÀÚ¿Í ¼ıÀÚ, Æ¯¼ö¹®ÀÚ(_)·Î ÀÌ·ç¾îÁø 4~10°³ÀÇ ´Ü¾î*/
	public static boolean isIdStr(String str) {
		if(Pattern.matches("^[0-9a-zA-Z]{4,10}$", str)) {
			return true;
		}
		return false;
	}
	
	/** ÆĞ½º¿öµå Çü½Ä¿¡ ¸Â´ÂÁö¸¦ È®ÀÎÇØ¼­ ¸ÂÀ¸¸é true ´Ù¸£¸é false ¹İÈ¯
	 * ¿µ¹®ÀÚ, ¼ıÀÚ, Æ¯¼ö¹®ÀÚ(!, @, #)·Î µÈ 4~10ÀÚ¸® ¹®ÀÚ*/
	public static boolean isPasswordStr(String str) {
		if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#]).{4,10}", str)) {
			return true;
		}
		return false;
	}
	
	/** ÀÌ¸§Çü½Ä¿¡ ¸Â´ÂÁö¸¦ È®ÀÎÇØ¼­ ¸ÂÀ¸¸é true ´Ù¸£¸é false ¹İÈ¯
	 * ÇÑ±ÛÀÌ³ª ¿µ¹® 3 ~ 10ÀÚ¸®*/
	public static boolean isNameStr(String str) {
		if(Pattern.matches("[a-zA-Z°¡-ÆR]{3,10}", str)) {
			return true;
		}
		return false;
	}
	
	/** »ı³â¿ùÀÏ Çü½Ä¿¡ ¸Â´ÂÁö¸¦ È®ÀÎÇØ¼­ ¸ÂÀ¸¸é true ´Ù¸£¸é false ¹İÈ¯*
	 * yyyy-mm-dd Çü½ÄÀÌ ¸Â´ÂÁö È®ÀÎ */
	public static boolean isBirthStr(String str) {
		if(Pattern.matches("(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])", str)) {
			return true;
		}
		return false;
	}
	
	/** ÀüÈ­¹øÈ£ Çü½Ä¿¡ ¸Â´ÂÁö¸¦ È®ÀÎÇØ¼­ ¸ÂÀ¸¸é true ´Ù¸£¸é false ¹İÈ¯
	 * ...
	 * */
	public static boolean isTelStr(String str) {
		if(Pattern.matches("(01[0139]|02|031)-(\\d{4}|\\d{3})-\\d{4}", str)) {
			return true;
		}
		return false;
	}
	
	/** ÈùÆ® Çü½Ä¿¡ ¸Â´ÂÁö¸¦ È®ÀÎÇØ¼­ ¸ÂÀ¸¸é true ´Ù¸£¸é false ¹İÈ¯
	 * */
	public static boolean isHintStr(String str) {
		if(Pattern.matches(".{0,50}", str)) {
			return true;
		}
		return false;
	}
//test	
	public static void main(String[] args) {
		System.out.println(isPasswordStr("1234!@"));
	}
}