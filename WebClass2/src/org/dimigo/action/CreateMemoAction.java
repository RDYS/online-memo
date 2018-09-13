/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *<pre>
 *org.dimigo.action
 *     |_CreateMemo
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 19.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class CreateMemoAction implements IAction{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Calendar cal = Calendar.getInstance();
		
		UserVO memo = new UserVO();
		
		try{
			 
			
			HttpSession session = request.getSession();
			UserService service = new UserService();
			UserVO user = new UserVO();
			user = (UserVO) session.getAttribute("user");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			
			System.out.println(title + ", " + content);
			
			System.out.println(session.getAttribute("user"));
			
			user.setTitle(title);
			user.setYear(cal.get(Calendar.YEAR));
			user.setMonth(cal.get(Calendar.MONTH)+1);
			user.setDay(cal.get(Calendar.DATE));
			user.setHour(cal.get(Calendar.HOUR));
			user.setMinute(cal.get(Calendar.MINUTE));
	        user.setSecond(cal.get(Calendar.SECOND));
	        user.setContent(content);
	      //제목과 내용을 받아와서 user에 넣어준다. 작성한 날짜와 시간 분 초와 함께
	        System.out.println("momo정보 들어가기전");
			
			service.creatememo(user);
			
			List<UserVO> result = service.searchUserList(user);
			//입력 받은 값들을 토대로  service->dao로 넘겨주어 dao에서 sql실행 후 받은 값들을 받아온다.
			
			request.setAttribute("list", result);
						
			RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/creatmemo.jsp");
			rd.forward(request, response);		
			}
	}	

}
