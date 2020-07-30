package com.vj.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WelcomeClientFor301 {
	
	public static void main(String[] args) {
		
		/**
		 > Rest Resource team/devs will use Swagger to generate the documentations for 
		   their resources.
		 > Based on the documentation provided by Resource Team with Swagger URL.
		 > We will develop the client to access those services/methods using respective 
		 	RequestMethods and URL patterns.
		 */
		
		try {
			URL url = new URL("http://localhost:2525/welcome");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			int httpStatusCd = conn.getResponseCode();
			if(httpStatusCd==200) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				while(line!=null) {
					System.out.println(line);
					line = br.readLine();
				}
				conn.disconnect();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
