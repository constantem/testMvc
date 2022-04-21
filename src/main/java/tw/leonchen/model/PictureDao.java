package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PictureDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public Picture insert(Picture bean) {
		Session session = sessionFactory.openSession();
		
		if(bean != null) {
			session.save(bean);
		}		
		session.close();
		
		return bean;
	}
	
}
