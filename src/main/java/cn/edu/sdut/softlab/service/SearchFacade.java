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
	@Inject
	EntityManager em;
	/*
	 
	参考 ：
	
	public List<T> findByNamedQuery(String namedQueryName) {
		return em.createNamedQuery(namedQueryName).getResultList();
	}
	*/
	
/*    @SuppressWarnings("unchecked")
	public List<Item> simpleSearch(String name) {
    	
    	return em.createQuery("SELECT i FROM Item i " + 
    								"WHERE i.name LIKE '%?1%' ")
    			.setParameter(1, name)
    			.getResultList();
    }*/
    
	@SuppressWarnings("unchecked")
	public List<Item> allDT() {
    	
    	return em.createQuery("SELECT i FROM Item i ")
    			.getResultList();
    }
    
     
    @SuppressWarnings("unchecked")
    public List<Item> simpleSearch(String name) {
    
        String queryString = "SELECT i FROM Item i " +
                             "WHERE i.name LIKE '%?1%'";
        Query query = em.createQuery(queryString);
        
        query.setParameter(1, name);
        return query.getResultList();
    }
    
    
}
