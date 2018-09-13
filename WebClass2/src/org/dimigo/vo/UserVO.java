/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *  |_ User
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 9. 21.
 * </pre>
 *
 * @author : Dell
 * @version : 1.0
 */
public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String nickname;
	private String title;
	private int year;
	private int month;
	private int day;
	private String content;
	private int m_count;
	private int d_count;
	private String changetitle;
	private String search;
	private int minute;
	private int second;
	private int hour;

	
	/**
	 * @return the search
	 */
	/**
	 * @return the changetitle
	 */
	// 기본생성자 만들기
	public UserVO() {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param nickName
	 */	public UserVO(String id, String pwd, String name, String nickname) {
			super();
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.nickname = nickname;
		}
	
	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the number

	/**
	 * @return the m_count
	 */
	 
		public String getSearch() {
			return search;
		}

		/**
		 * @param search the search to set
		 */
		public void setSearch(String search) {
			this.search = search;
		}

	 
		public String getChangetitle() {
			return changetitle;
		}


		public void setChangetitle(String changetitle) {
			this.changetitle = changetitle;
		}

	public int getM_count() {
		return m_count;
	}

	/**
	 * @param m_count the m_count to set
	 */
	public void setM_count(int m_count) {
		this.m_count = m_count;
	}

	/**
	 * @return the d_count
	 */
	public int getD_count() {
		return d_count;
	}

	/**
	 * @param d_count the d_count to set
	 */
	public void setD_count(int d_count) {
		this.d_count = d_count;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nickName
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserVO [year="+year+",search="+search+",month=" + month +",changetitle=" + changetitle+",id=" + id + ", pwd=" + pwd + ", name=" + name + ", nickname=" + nickname + ", title=" + title+ ", content=" + content  + "]";
	}


	
}
