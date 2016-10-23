package movietickets.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookingController {

	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";
	
	@RequestMapping(value="/bookingTraining", method=RequestMethod.GET)
	public 
	@ResponseBody
	Map<String, String> bookTraining(	@RequestParam("location") String location,
																				@RequestParam("program") String program,
																				@RequestParam("course") String course,
																				@RequestParam("trainingSession") String trainingSession,
																				HttpServletRequest request
			) {
		
		System.out.println("Came to the bookings controller");
		System.out.println("The location is: " + location);
		System.out.println("The program is: " + program);
		System.out.println("The course is: " + course);
		System.out.println("The session is: " + trainingSession);

		HttpSession session = request.getSession();
		
		session.setAttribute("location", location);
		session.setAttribute("program", program);
		session.setAttribute("course", course);
		session.setAttribute("session", trainingSession);
		
		int count=1;
		Map<String, String> responseMap = new HashMap<>();
		
		do {

			String secureTokenId = randomAlphaNumeric(36);
			String payPalResponse = getSecureToken(secureTokenId);
			responseMap.clear();
			
			if (payPalResponse != null && payPalResponse.length()>0) {
				
				String[] responseAttributes = payPalResponse.split("&");

				for (String string : responseAttributes) {
					String[] array = string.split("=");
					responseMap.put(array[0], array[1]);
				}
				
				
				if ( responseMap.get("RESULT").equals("0")) {
					return responseMap;
				} 
				
			} else {
				return null;
			}

			count++;
			
		}while(count<=3);
		
		responseMap.put("error", "payflow connection issue");
		return responseMap;
		
	}
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static String getSecureToken(String secureTokenId) {
		
		String url = "https://pilot-payflowpro.paypal.com";
		
		try {
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			
			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			
			StringBuilder urlParameters = new StringBuilder();
			urlParameters.append("user=adpautrx&"); 
			urlParameters.append("PARTNER=VSA&");
			urlParameters.append("vendor=michaelwan&");
			urlParameters.append("pwd=PayPal321&");
			urlParameters.append("CREATESECURETOKEN=Y&");
			urlParameters.append("AMT=10&");
			urlParameters.append("Currency=AUD&");
			urlParameters.append("TrxTYPE=S&");
			urlParameters.append("SECURETOKENID=" + secureTokenId + "&");
			urlParameters.append("DESCRIPTION=TrainingCourse&");
			
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters.toString());
			wr.flush();
			wr.close();
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			return response.toString();
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
}
