package in.co.rays.product;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class ProductModel  extends HttpServlet{
	 public void add(ProductDTO dto) {
			
			SessionFactory sf =  new Configuration().configure().buildSessionFactory();
			
	         Session session = sf.openSession();
	         
	         Transaction tx = session.beginTransaction();
	         
	         session.save(dto);
	         tx.commit();
	         session.close();
		

	}
		public void update(ProductDTO dto) {
			
			SessionFactory sf =  new Configuration().configure().buildSessionFactory();
			
	        Session session = sf.openSession();
	        
	        Transaction tx = session.beginTransaction();

	        session.update(dto);
	        tx.commit();
		   session.close();
		
		}
		
		public void delete(ProductDTO dto) {
			
			SessionFactory sf =  new Configuration().configure().buildSessionFactory();
			
	        Session session = sf.openSession();
	        
	        Transaction tx = session.beginTransaction();
	        
	        session.delete(dto);
	        tx.commit();
	        session.close();
			
			
		}
		public List search(ProductDTO dto) {
		SessionFactory sf =  new Configuration().configure().buildSessionFactory();
			
	        Session session = sf.openSession();
	        
	        Transaction tx = session.beginTransaction();
	        
	   Criteria  c = session.createCriteria(ProductDTO.class);
	   
	   if (dto!=null) {
		   
		 if(dto.getName()!=null && dto.getName().length()>0) {
			 c.add(Restrictions.like("name", dto.getName() + "%"));
		 }
		 
		 if ( dto.getId()>0) {
			 c.add(Restrictions.like("id", dto.getName() + "%"));

		 }
}
	   List list = c.list();
	   tx.commit();

			
			return list;
			
			
		} 
		public ProductDTO findByPk(int id) {
	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
			
	        Session session = sf.openSession();
	        
	        Transaction tx = session.beginTransaction();

			ProductDTO dto = (ProductDTO) session.get(ProductDTO.class, id);
			return dto;
			
		}
		


}
