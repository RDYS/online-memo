/**
 * 
 */
package org.dimigo.action;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

/**
 *<pre>
 *org.dimigo.action
 *     |_GetAction
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 20.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class GetMemoAction implements IAction{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		try{
			//list에 있는 memo제목을 클릭시 원래 그 memo에 작서 되어있던 제목과 내용을 가져와서 화면에 띄워줌.
			HttpSession session = request.getSession();
			UserService service = new UserService();
						
			UserVO user = new UserVO();
			
			user = (UserVO) session.getAttribute("user");
			
			user.setTitle(request.getParameter("title"));		
			
			System.out.println(user+"수정전");
			
			user.setContent(service.getcontent(user));
			
			
			session.setAttribute("title", request.getParameter("title"));
			session.setAttribute("content", service.getcontent(user));

			RequestDispatcher rd = request.getRequestDispatcher("jsp/insertmemo.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);		}
	}	

}
