/**
 * 
 */
package org.dimigo.service;

import java.sql.Connection;
import java.util.List;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.SayingVO;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.service
 *  |_ LoginService
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 5.
 * </pre>
 *
 * @author : Dell
 * @version : 1.0
 */
public class UserService extends AbstractService {
	
	public UserVO login(UserVO user) throws Exception {
		
		Connection conn = null;
		try {
			// DB에서 id, pwd 조회
	//		boolean result = true;
	//		
	//		if(result) {
	//			user.setId(user.getId());
	//	    	user.setName("홍길동");
	//	    	user.setNickname("의적");
	//	    } else {
	//			throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
	//		}
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			UserVO result = dao.searchUser(user);
			
			if(result == null)
				throw new Exception("아이디 또는 비밀번호를 다시 확인하세요.");
			
			return result;
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public void signup(UserVO user) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			// 사용중인 아이디인지 먼저 체크
			UserVO result = dao.searchUserById(user);
			if(result != null) {
				throw new Exception("이미 사용중인 아이디입니다.");
			}
			
			// DB에 사용자정보 등록
			dao.insertUser(user);
			
	//		boolean result = true;
	//		
	//		if(!result) {
	//			throw new Exception("이미 사용중인 아이디입니다.");
	//		}
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public void creatememo(UserVO memo) throws Exception{
		Connection conn = null;
		System.out.println("creatememo들어옴");
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			System.out.println("dao들어가기전");
			dao.createMemo(memo);
		} finally{
			if(conn != null) conn.close();
		}
		
	}
	
	public void deletememo(UserVO memo) throws Exception{
		Connection conn = null;
		System.out.println("deletememo들어옴");
		System.out.println(memo);
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			System.out.println("dao들어가기전");
			
			dao.deletememo(memo);
		} finally{
			if(conn != null) conn.close();
		}
	}
	
	public void insertmemo(UserVO memo) throws Exception{
		Connection conn = null;
		System.out.println("insertememo들어옴");
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			System.out.println("dao들어가기전");
			
			dao.insertMemo(memo);
		} finally{
			if(conn != null) conn.close();
		}
		
	}
	
	public List<UserVO> searchmemo(UserVO user) throws Exception{
	
		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.searchmemo(user);	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
public void getsaying(SayingVO say) throws Exception{
		
		Connection conn = null;

		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			dao.getsaying(say);	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public String getcontent(UserVO user) throws Exception{
		
		Connection conn = null;

		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.getcontent(user);	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
	
	public List<UserVO> searchUserList(UserVO user) throws Exception {

		Connection conn = null;
		
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.searchUserList(user);	
			
		} finally {
			if(conn != null) conn.close();
		}
	}
}
