/**
 * 
 */
package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dimigo.vo.SayingVO;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.dao
 *  |_ UserDao
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 6.
 * </pre>
 *
 * @author : Dell
 * @version : 1.0
 */
public class UserDao {

	private Connection conn = null;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	public UserVO searchUser(UserVO vo) throws Exception {

		String sql = "SELECT ID, NAME, NICKNAME FROM USER WHERE ID=? AND PWD=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());

			ResultSet rs = pstmt.executeQuery();

			UserVO result = null;
			if (rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public UserVO searchUserById(UserVO vo) throws Exception {

		String sql = "SELECT ID, NAME, NICKNAME FROM USER WHERE ID=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();

			UserVO result = null;
			if (rs.next()) {
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}

	public void insertUser(UserVO vo) throws Exception {

		String sql = "INSERT INTO USER VALUES(?, ?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickname());
			int cnt = pstmt.executeUpdate();

			if (cnt == 0)
				throw new Exception("사용자 등록 실패");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시 오류가 발생하였습니다.");
		}
	}

	public void createMemo(UserVO memo) throws Exception {
		System.out.println("dao들어옴");
		System.out.println(memo);
		String sql = "INSERT INTO MEMO VALUES(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			System.out.println(memo.getId());
			pstmt.setString(1, memo.getId());
			pstmt.setString(2, memo.getTitle());
			pstmt.setInt(3, memo.getYear());
			pstmt.setInt(4, memo.getMonth());
			pstmt.setInt(5, memo.getDay());
			pstmt.setString(6, memo.getContent());
			pstmt.setInt(7, memo.getHour());
			pstmt.setInt(8, memo.getMinute());
			pstmt.setInt(9, memo.getSecond());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("메모등록시 오류");
			e.printStackTrace();
			throw new Exception("메모 제목 중복");
		}

	}

	public void insertMemo(UserVO memo) throws Exception {
		System.out.println("dao들어옴");
		System.out.println(memo);
		String sql = "UPDATE MEMO SET TITLE=?,CONTENT=? WHERE TITLE=? AND ID=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, memo.getChangetitle());
			pstmt.setString(2, memo.getContent());
			pstmt.setString(3, memo.getTitle());
			pstmt.setString(4, memo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("메모등록시 오류");
			e.printStackTrace();
			throw new Exception("메모 수정시 오류 발생하였습니다.");
		}

	}

	public String getcontent(UserVO vo) throws Exception {

		String sql = "SELECT CONTENT FROM MEMO WHERE TITLE=? AND ID=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getId());

			ResultSet rs = pstmt.executeQuery();
			String content_ = null;
			UserVO result;

			while (rs.next()) {
				result = new UserVO();
				result.setContent(rs.getString(1));
				content_ = rs.getString(1);
			}
			return content_;
		}

	}

	public void getsaying(SayingVO say) throws Exception {

		String sql = "SELECT TELL,PEOPLE FROM SAYING WHERE NUM=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, say.getNumber());
			System.out.println(say.getNumber());
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				say.setTell(rs.getString(1));
				say.setPeople(rs.getString(2));
			}
				
			//System.out.println(rs.getString(1) + "userdao");
			//System.out.println(rs.getString(2) + "userdao");
			} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("명언 정보 조회 실패");
		}
	}

	public void deletememo(UserVO user) throws Exception {
		System.out.println("dao 들어옴-delete");

		String sql = "DELETE FROM MEMO WHERE ID=? and TITLE=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getTitle());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("사용자 삭제 실패");
			e.printStackTrace();
			throw new Exception("사용자 삭제 실퍂");
		}
		System.out.println("delete dao 종료");
	}

	public List<UserVO> searchmemo(UserVO vo) throws Exception {
		
		System.out.println("dao드렁옴 = searchmemo");

		String sql = "SELECT TITLE,YEAR,MONTH,DAY FROM MEMO WHERE TITLE LIKE \"%"
				+ vo.getSearch() + "%\" AND ID=?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			System.out.println("title : " + vo.getTitle());
			pstmt.setString(1, vo.getId());

			
				
			System.out.println(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			UserVO result = null;
			List<UserVO> list = new ArrayList<UserVO>();

			while (rs.next()) {
				result = new UserVO();
				result.setTitle(rs.getString(1));
				result.setYear(rs.getInt(2));
				result.setMonth(rs.getInt(3));
				result.setDay(rs.getInt(4));
				list.add(result);
			}

			System.out.println("searchmemo : " + vo);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("메모 조회 시 오류가 발생하였습니다.");
		}
	}

	public List<UserVO> searchUserList(UserVO vo) throws Exception {

		String sql = "SELECT TITLE,YEAR,MONTH,DAY,CONTENT FROM MEMO WHERE ID=? ORDER BY YEAR DESC, MONTH DESC, DAY DESC, HOUR DESC,MINUTE DESC,HOUR DESC, SECOND DESC";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, vo.getId());

			ResultSet rs = pstmt.executeQuery();

			UserVO result = null;
			List<UserVO> list = new ArrayList<UserVO>();

			while (rs.next()) {
				result = new UserVO();
				result.setTitle(rs.getString(1));
				result.setYear(rs.getInt(2));
				result.setMonth(rs.getInt(3));
				result.setDay(rs.getInt(4));
				list.add(result);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
		}
	}
}
