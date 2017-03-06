/**
 * 
 */
package cn.edu.sdut.softlab.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.component.datatable.DataTable;

import cn.edu.sdut.softlab.model.Item;
import cn.edu.sdut.softlab.service.SearchFacade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;//
import javax.faces.bean.ApplicationScoped;

/**
 * @author gaoyisheng
 *
 */
@Named("SearchManager")
@Dependent
@ApplicationScoped	//SessionScoped 得到的List<>无法sortBy  改为Faces.Bean.ApplScoped..(模仿primefaces)还是不行 = =               
public class SearchManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;
	
	//bukeyi = =
/*	private Item newItem = new Item();
		
	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}
	*/

	//作为中间变量的存在。类似Credentials
	@Inject
	Tempor tem;
	
	public Tempor getTem() {
		return tem;
	}

	public void setTem(Tempor tem) {
		this.tem = tem;
	}


	@Inject
	SearchFacade searchService;
	
	
	public List<Item> getItemsSearchDT(){
		String i = tem.getName();
		
		if (i == null || i.equals("")){
			return searchService.allDT();
		}
		return searchService.fuzzySearch(i);
	}
	
	//1 模仿 primefaces 解决sortBy
	//2 用DataTable解决?无法sortBy    
	private DataTable dt= new DataTable(){};
	
	
	/*
	public List<Item> simpleSearch(String name) {
    	
    	return em.createQuery("SELECT i FROM Item i " + 
    								"WHERE i.name LIKE '%?1%' ")
    			.setParameter(1, name)
    			.getResultList();
       
    }*/
	
	
}
