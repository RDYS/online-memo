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
 *     |_InsertMemo
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 20.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class InsertMemoAction implements IAction{
	private void validate(String title, String content) throws Exception {
		if(CommonUtil.isEmpty(title)) throw new Exception("제목을 입력하세요");
		if(CommonUtil.isEmpty(content)) throw new Exception("내용을 입력하세요");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("InsertMemoAction들어옴");
		
		Calendar cal = Calendar.getInstance();
		
		UserVO memo = new UserVO();
		
		try{
			
			//memo창을 열어서 수정한 내용들을 가져와 원래 있던 내용들과 바꿈ㄴ
			HttpSession session = request.getSession();
			UserService service = new UserService();
			UserVO user = new UserVO();
			user = (UserVO) session.getAttribute("user");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			System.out.println("title="+user.getTitle()+"changetitle ="+title+"content="+content);
			
			validate(title, content);
						
			System.out.println(session.getAttribute("user"));
			
			user.setChangetitle(title);
			user.setYear(cal.get(Calendar.YEAR));
			user.setMonth(cal.get(Calendar.MONTH)+1);
			user.setDay(cal.get(Calendar.DATE));
			user.setContent(content);
			
			System.out.println("momo정보 들어가기전");
			
			service.insertmemo(user);
			
			System.out.println(user+"list초기화 되기전");
			
			List<UserVO> result = service.searchUserList(user);
			
			request.setAttribute("list", result);
						
			RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/insertmemo.jsp");
			rd.forward(request, response);		}
	}	

}
