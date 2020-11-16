package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import model.Items;

public class ItemDaoImpl implements ItemDao {
	private EntityManagerFactory emf; // ORM에 사용되는 객체

	@PersistenceUnit // setter 주입을 위해 사용하는 어노테이션
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	// JPQL = ORM 쿼리를 칭함
	public List<Items> findAll() {
		EntityManager em = emf.createEntityManager(); // EntityManager생성
		return em.createQuery("from Items", Items.class).getResultList(); // 결과를 리스트에 담기 위해 getResultList() 사용
	}

	//검색 결과가 여러건일 경우에는 getResultList(), 한개일때는 getSingleResult()사용
	public Items findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Items where item_id = :item_id", Items.class).setParameter("item_id", id)
				.getSingleResult();
	}

}
