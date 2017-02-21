/**
 * 
 */
package cn.edu.sdut.softlab.service;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import cn.edu.sdut.softlab.model.Item;

/**
 * @author gaoyisheng
 *
 */
public class SearchFacade {

	 @Inject EntityManager em;

	/*
	 * 参考 ：
	 * 
	 * public List<T> findByNamedQuery(String namedQueryName) { return
	 * em.createNamedQuery(namedQueryName).getResultList(); }
	 */

	/**
	 * . 模糊查询
	 * 
	 * JPA动态查询 通配符 配合 变量
	 */
	// public List<Item> fuzzySearch(String name) {
	//
	// /*
	// * ERROR : java.lang.IllegalArgumentException: Parameter with that
	// * position [1] did not exist at
	// * cn.edu.sdut.softlab.service.SearchFacade.fuzzySearch(SearchFacade.
	// * java:39)
	// *
	// * 为什么不行？？
	// */
	// /*
	// * return em.createQuery("SELECT i FROM Item i " +
	// * "WHERE i.name LIKE '%?1%' ") .setParameter(1, name) .getResultList();
	// */
	// if (name == null || name.equals("")) {
	//
	// // test 倘若 是 name 的问题，那么 返回模糊查询 1 的 结果。
	// return em.createQuery("SELECT i FROM Item i WHERE i.name LIKE '%:param%'
	// ").setParameter("param", "1")
	// .getResultList();
	// }
	//
	// // test 倘若 不是 name 的问题，那么 返回模糊查询 4 的 结果。
	// return em.createQuery("SELECT i FROM Item i WHERE i.name LIKE '%:param%'
	// ").setParameter("param", "4")
	// .getResultList();
	//
	// return
	// em.createQuery("SELECT i FROM Item i WHERE i.name LIKE '%:param%' ")
	// .setParameter("param", name) .getResultList();
	//
	//
	// }

	@SuppressWarnings("unchecked")
	public List<Item> allDT() {

		return em.createQuery("SELECT i FROM Item i ").getResultList();
	}

	/*
	 * . 模糊查询
	 * 
	 * JPA动态查询 通配符 配合 变量
	 */

	/*
	 * ERROR : java.lang.IllegalArgumentException: Parameter with that position
	 * [1] did not exist at
	 * cn.edu.sdut.softlab.service.SearchFacade.fuzzySearch(SearchFacade.java:
	 * 39)
	 *
	 * 为什么不行？？
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<Item> fuzzySearch(String name)
	 * {
	 * 
	 * String queryString = "SELECT i FROM Item i WHERE i.name LIKE '%?1%'";
	 * Query query = em.createQuery(queryString);
	 * 
	 * query.setParameter(1, name); return query.getResultList(); }
	 */

	
	/**
	 * 
	 * 不容易，，注意两点。 通配符(%)的位置，位置变量(?)的参数 
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


