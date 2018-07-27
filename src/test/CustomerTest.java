import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerTest {

    private static EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hugo");
    }

    @AfterClass
    public static void destory() {
        entityManagerFactory.close();
    }

    @Test
    public void add() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Customer c = new Customer(null, "john");
        System.out.println(c.toString());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(c);
        tx.commit();
        em.close();
    }

    @Test
    public void update() {
        System.out.println("hugo123");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Customer c = em.getReference(Customer.class,1);
        tx.begin();
        c.setCname("hugo");
//        em.flush();
        tx.commit();
        em.close();
    }
}
