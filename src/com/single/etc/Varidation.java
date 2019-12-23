package com.single.etc;

import java.util.regex.Pattern;

// �پ��� ��ȿ�� �˻縦 �����ϴ� Ŭ����
public class Varidation {
	/** Null �Ǵ� ""�̸� true ��ȯ*/
	public static boolean isNullStr(String str) {
		if(str == null || str.equals("")) {
			return true;
		}
		return false;
	}
		
	/** ���̵� ���Ŀ� �´����� Ȯ���ؼ� ������ true �ٸ��� false ��ȯ
	 * �����ڿ� ����, Ư������(_)�� �̷���� 4~10���� �ܾ�*/
	public static boolean isIdStr(String str) {
		if(Pattern.matches("^[0-9a-zA-Z]{4,10}$", str)) {
			return true;
		}
		return false;
	}
	
	/** �н����� ���Ŀ� �´����� Ȯ���ؼ� ������ true �ٸ��� false ��ȯ
	 * ������, ����, Ư������(!, @, #)�� �� 4~10�ڸ� ����*/
	public static boolean isPasswordStr(String str) {
		if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#]).{4,10}", str)) {
			return true;
		}
		return false;
	}
	
	/** �̸����Ŀ� �´����� Ȯ���ؼ� ������ true �ٸ��� false ��ȯ
	 * �ѱ��̳� ���� 3 ~ 10�ڸ�*/
	public static boolean isNameStr(String str) {
		if(Pattern.matches("[a-zA-Z��-�R]{3,10}", str)) {
			return true;
		}
		return false;
	}
	
	/** ������� ���Ŀ� �´����� Ȯ���ؼ� ������ true �ٸ��� false ��ȯ*
	 * yyyy-mm-dd ������ �´��� Ȯ�� */
	public static boolean isBirthStr(String str) {
		if(Pattern.matches("(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])", str)) {
			return true;
		}
		return false;
	}
	
	/** ��ȭ��ȣ ���Ŀ� �´����� Ȯ���ؼ� ������ true �ٸ��� false ��ȯ
	 * ...
	 * */
	public static boolean isTelStr(String str) {
		if(Pattern.matches("(01[0139]|02|031)-(\\d{4}|\\d{3})-\\d{4}", str)) {
			return true;
		}
		return false;
	}
	
	/** ��Ʈ ���Ŀ� �´����� Ȯ���ؼ� ������ true �ٸ��� false ��ȯ
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