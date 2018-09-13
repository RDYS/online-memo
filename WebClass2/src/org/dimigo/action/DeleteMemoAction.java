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
import org.dimigo.vo.UserVO;

/**
 *<pre>
 *org.dimigo.action
 *     |_DeleteMemoAction
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 20.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class DeleteMemoAction implements IAction{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try{
			
			//삭제버튼을 누른 줄에 있는 memo 제목을 가져와 db에서 해당하는 제목을 가진 memo를 삭제함.
			
			HttpSession session = request.getSession();
			UserService service = new UserService();
			UserVO user = new UserVO();
			
			user = (UserVO) session.getAttribute("user");
			
			user.setTitle(request.getParameter("title"));		
			
			System.out.println(user+"delete memo");
			
			service.deletememo(user);
			System.out.println("dao 갔다옴");
			List<UserVO> result = service.searchUserList(user);
			
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
