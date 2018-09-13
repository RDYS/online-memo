/**
 * 
 */
package org.dimigo.action;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.UserService;
import org.dimigo.vo.SayingVO;

/**
 *<pre>
 *org.dimigo.action
 *     |_SayingAction
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 24.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class SayingAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
		Random random = new Random();
		
		UserService service = new UserService();
		SayingVO say = new SayingVO();
		
		
		//랜덤으로 0~35사이의 숫자를 받아와서 say에 저장 후에 sql연동해서 해당 숫자에 넣어진 명언을 가지고와서 출력
		say.setNumber(random.nextInt(35));
			
		service.getsaying(say);
		
		request.setAttribute("say", say);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/saying.jsp");
		rd.forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
