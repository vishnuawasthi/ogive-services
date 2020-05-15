package com.app.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService {

	@Override
	public String sendSMS(String number, String messageBody) {
		try {
			// Construct data
			//String apiKey = "apikey=" + "yourapiKey";
			String apiKey = "apikey=" + "ApKMRChtmro-xCsuiYTBcwqc9ygI0qFocUQ41bpLfh";
			String message = "&message=" + messageBody;
			//String sender = "&sender=" + "VA-INFO";
			String sender ="";
			//918123456789
			String numbers = "&numbers=" +number;

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

}
