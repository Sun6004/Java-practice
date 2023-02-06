package chapter25;

import java.util.Arrays;

public class ByteToString {
	public static void main(String[] args) {
		byte[] bytes = { 73, 32, 108, 111, 118, 101, 32, 121, 111, 117 };
		String str = new String(bytes);
		System.out.println(str);
		String str2 = "You love me";
		byte[] bytes2 = str2.getBytes();
		System.out.println(Arrays.toString(bytes2));
	}
}
