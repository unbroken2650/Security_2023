
import java.security.MessageDigest;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;



public class HashTest_hw {

	public static void main(String args[]) throws Exception
	{
	    Security.addProvider(new BouncyCastleProvider());
	    
	    MessageDigest hash = MessageDigest.getInstance("SHA1");
	
		String student_no="20192650";
		// 0에서 100사이의 랜덤한 정수를 출력 
		int random_num = (int)(Math.random()*100);
		byte[] out;
		
		// hash 함수의 1-2번째 바이트가 0이 될 때의 hash 값을 출력
		while(true)
		{
			hash.update(Utils.toByteArray(student_no));
			hash.update(Utils.toByteArray(Integer.toString(random_num)));
			out = hash.digest();
			if(out[0]==0) {
				System.out.println("Answer #1: "+ Utils.toHexString(out)+ " With random number "+random_num);
				break;
			}
			else {
				random_num++;
				continue;
			}
		}
		// hash 함수의 1-4번째 바이트가 0이 될 때의 hash 값을 출력
		while(true)
		{
			hash.update(Utils.toByteArray(student_no));
			hash.update(Utils.toByteArray(Integer.toString(random_num)));
			out = hash.digest();
			if(out[0]==0 && out[1] == 0) {
				System.out.println("Answer #2: "+ Utils.toHexString(out) + " With random number "+random_num);
				break;
			} 
			else {
				random_num++;
				continue;
			}
		}	
	}
}
