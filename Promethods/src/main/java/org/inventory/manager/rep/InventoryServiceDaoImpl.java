package org.inventory.manager.rep;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.inventory.manager.config.HibernateUtil;
import org.inventory.manager.model.Product;

public class InventoryServiceDaoImpl implements InventoryServiceDao{

	public String addProduct(Product product){
		String productName = product.getName();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		return productName;
	}
	
	public void removeProduct(long id){
		Product product = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		product = (Product) session.load(Product.class, id);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateProduct(Product product){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public Product getProduct(long id){
		Product product = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		product = (Product) session.load(Product.class, id);
		session.getTransaction().commit();
		session.close();
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct(){
		List<Product> productList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		productList = (List<Product>) session.createQuery("from Product").list();
		session.getTransaction().commit();
		session.close();
		return productList;
	}
	public void removeBulkProduct(List<Long> idList ){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM TrackedItem item WHERE item.id IN (:ids)");
		query.setParameter("ids", idList);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
}
