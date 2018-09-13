package org.dimigo.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TranslateAPI implements IAction{

	private String a;
	
	/**
	 * @param a the a to set
	 */
	public void setA(String a) {
		this.a = a;
	}

	public String tran(String a) throws Exception {
		
		return parseJson(a);
	}
	
	
	@SuppressWarnings({ "unchecked"})
	public String parseJson(String keyword) throws Exception {
		String json = translate(keyword);

		Map<String, Object> map = new ObjectMapper().readValue(json, Map.class);
		Map<String, Object> message = (Map<String, Object>) map.get("message");
		Map<String, Object> result = (Map<String, Object>) message.get("result");
		
		return (String) result.get("translatedText");
	}

	public String translate(String sentence) {
		String clientId = "AXiPh33WyDbSDw0lMszs";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "3H4TuCvuJ9";// 애플리케이션 클라이언트 시크릿값";
		String result = null;
		try {
			String text = URLEncoder.encode(sentence, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// post request
			String postParams = "source=ko&target=en&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			
			
			result = response.toString();
			
			System.out.println(result);
			
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.dimigo.action.IAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//trans로 입력받은 글을 받아와서 번역해서 다시 출력

		String trans = request.getParameter("trans");

		String result = tran(trans);
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/trans.jsp");
		rd.forward(request, response);
	}
}