/**
 * 
 */
package cn.edu.sdut.softlab.controller;

import java.util.List;

import cn.edu.sdut.softlab.model.ItemAccount;

/**
 * @author gaoyisheng
 *
 */
public interface ItemAccountManager {

	
	/**
	 * 获得所有 ItemAccount 列表.
	 *
	 * @return 所有 ItemAccount 列表
	 * @throws Exception
	 */
	abstract List<ItemAccount> getItemAccounts() throws Exception;

	/**
	 * 新增 ItemAccount .
	 *
	 * @return 返回 ItemAccount 列表页面
	 * @throws Exception
	 */
	String addItemAccount() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	String deleteItemAccount() throws Exception;
}
