package home.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int result = 0;
		int x = Integer.parseInt(br.readLine()); 
		int y = Integer.parseInt(br.readLine()); 
        
		System.out.println(x+y);
		br.close();
	}

}
