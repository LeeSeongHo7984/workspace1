package com.varxyz.ncs.util;

import java.util.Arrays;

public class StringsUtil {
	
	/**
	 * 주어진 문자열에 숫자(양수에 한함)와 관련된 문자열을 추출하여 리턴한다.
	 * 숫자가 없을때 빈문자열을 리턶나다.
	 * 
	 * ex) "abc432def" 입력시 "432" 출력
	 * 
	 * @param target
	 * @return
	 */
	public String extractIntCharacters(String str) {
		
		str = "abc432def";
		String str2 = "";
		
		char[] charArr = str.toCharArray();
		
		str = Arrays.toString(charArr);
		
		for(int i = 0; i < str.length(); i++ ) {
			
			if(str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				 str2 += str.charAt(i);
			} else if(str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				return "";
			}
		}
		
		return str2;
	}

	
	/**
	 * 주어진 문자열에 포함된 숫자(양수에 한함)문자열을 정수로 리턴한다.
	 * 숫자가 없을때 IllegalArgumentException 예외를 던진다.
	 * 
	 * ex) "abc432def" 입력시 432 출력
	 * @param target
	 * @return
	 */
	public int extractNum(String target) throws IllegalArgumentException {
		target = "abc432def";
		String str = "";
		
		char[] charArr = target.toCharArray();
		
		target = Arrays.toString(charArr);
		
		for(int i = 0; i < target.length(); i++ ) {
			
			if(target.charAt(i) >= 48 && target.charAt(i) <= 57) {
				str += target.charAt(i);
			}
		}
		
		if (str == "") {
			throw new IllegalArgumentException();
		}
		
		int intResult = Integer.parseInt(str);
		
		return intResult;
	}
	
}