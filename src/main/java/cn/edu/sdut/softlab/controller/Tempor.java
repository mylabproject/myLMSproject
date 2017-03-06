/**
 * 
 */
package cn.edu.sdut.softlab.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

/**
 * @author gaoyisheng
 *
 */
@RequestScoped	//因为只作为中间变量传值，所以Request
@Named
@Default
public class Tempor {

	/// 作为 查询的 中间变量
	
	//之后添加其他字段的属性

	private String name;
	private String word;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	



}
