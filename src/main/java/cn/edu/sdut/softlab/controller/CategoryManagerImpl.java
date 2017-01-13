/*
 * @author gaoyisheng 
 * @date 2017-1-11
 */

package cn.edu.sdut.softlab.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

import cn.edu.sdut.softlab.model.Category;
import cn.edu.sdut.softlab.service.CategoryFacade;


/**
 *   类管理器.
 *  @author gaoyisheng
 */
public class CategoryManagerImpl implements CategoryManager {


	@Inject
	private transient Logger logger;
	@Inject
	CategoryFacade categoryService;

	@Inject
	private UserTransaction utx;

	private Category newCategory = new Category();

	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewStuff(Category newCategory) {
		this.newCategory = newCategory;
	}

	@Override
	@Produces
	@Named
	@RequestScoped
	public List<Category> getCategories() throws Exception {
		try {
			utx.begin();
			return categoryService.findAll();
		} finally {
			utx.commit();
		}
	}

	@Override
	public String addCategory() throws Exception {
		try {
			utx.begin();
			categoryService.create(newCategory);
			logger.log(Level.INFO, "Added {0}", newCategory);
			return "/Categories.xhtml?faces-redirect=true";
		} finally {
			utx.commit();
		}
	}

}
