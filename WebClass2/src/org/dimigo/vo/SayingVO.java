/**
 * 
 */
package org.dimigo.vo;

/**
 *<pre>
 *org.dimigo.vo
 *     |_Sayingvo
 *
 * 1. 개요  : 
 * 2. 작성일 : 2017. 11. 24.
 *</pre>
 *
 * @author Dell
 * @version : 1.0
 */
public class SayingVO {
	private int number;
	private String tell;
	private String people;
	
	public SayingVO(){}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the tell
	 */
	public String getTell() {
		return tell;
	}

	/**
	 * @param tell the tell to set
	 */
	public void setTell(String tell) {
		this.tell = tell;
	}

	/**
	 * @return the people
	 */
	public String getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(String people) {
		this.people = people;
	}
	
	
}
