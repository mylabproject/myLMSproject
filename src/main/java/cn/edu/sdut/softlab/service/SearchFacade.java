/**
 * 
 */
package cn.edu.sdut.softlab.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import cn.edu.sdut.softlab.model.Item;

/**
 * @author gaoyisheng
 *
 */
//@RequestScoped 	//为了使searchManager得到的List<>可以sortBy 模仿PrimeFaces改写生命周期为ApplScoped
@Stateless
public class SearchFacade {

	 @Inject EntityManager em;


	/**
	 * . 模糊查询
	 * 
	 * JPA动态查询 通配符 配合 变量
	 */

	@SuppressWarnings("unchecked")
	public List<Item> allDT() {

		return em.createQuery("SELECT i FROM Item i ").getResultList();
	}

	/*
	 * . 模糊查询
	 * 
	 * JPA动态查询 通配符 配合 变量
	 */

	
	/**
	 * 
	 *  注意   通配符(%)的位置，位置变量(?)的参数 
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Item> fuzzySearch(String name) {

		String queryString = "SELECT i FROM Item i WHERE i.name LIKE ?";
		Query query = em.createQuery(queryString);

		query.setParameter(1, "%" + name + "%");
		return query.getResultList();
	}
	

	public Item singleFuzzySearch(String name) {

		String queryString = "SELECT i FROM Item i WHERE i.name LIKE :param";
		Query query = em.createQuery(queryString);

		query.setParameter("param", "'%"+name+"%'");
		return (Item) query.getSingleResult();
	}
	
	

}


