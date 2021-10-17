package Test;

import java.security.MessageDigest;
import java.util.UUID;

public class SHA256 {
	
	
	
	public static String getSHA256(String input) 
	{
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			byte[] salt ="Hello This is Salt".getBytes();
			digest.reset();
			digest.update(salt);
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			for (int i = 0; i < chars.length; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if (hex.length() == 1) 	result.append("0");			
				result.append(hex);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result.toString();
	}
	
	
	
	
	public static void UUIDuse() {
		
		String tempPw = UUID.randomUUID().toString().replace("-", "");
		tempPw = tempPw.substring(0,10);
		
		System.out.println("임시 비밀번호 확인"+tempPw);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(SHA256.getSHA256("1234"));

		SHA256.UUIDuse();
		
	}
	
}
