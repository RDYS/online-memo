/**
 * 
 */
package org.dimigo.action;

import java.util.Calendar;
import java.util.List;

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
 *     |_SearchMemoAction
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 21.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class SearchMemoAction implements IAction{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		try{
			
			HttpSession session = request.getSession();
			UserService service = new UserService();
			UserVO user = new UserVO();
			user = (UserVO) session.getAttribute("user");
			String search = request.getParameter("search");
			
			System.out.println("search : "+search);
			
			user.setSearch(search);
						
			List<UserVO> result = service.searchmemo(user);
			request.setAttribute("list", result);
						
			RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);		}
	}	


}
