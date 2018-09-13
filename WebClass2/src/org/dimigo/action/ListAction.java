		/**
 * 
 */
package org.dimigo.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *  |_ LoginAction
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 5.
 * </pre>
 *
 * @author : Dell
 * @version : 1.0
 */
public class ListAction implements IAction {
	
	public static String id2;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserVO user = new UserVO();
		
		try {
			//db에 있는 memo데이터들을 가져와서 테이블에 출력함.
			HttpSession session = request.getSession();
			UserService service = new UserService();
			user = (UserVO) session.getAttribute("user");
			
			List<UserVO> result = service.searchUserList(user);
			request.setAttribute("list", result);
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);
		}
    	
	}

}
