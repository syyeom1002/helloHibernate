package kr.ac.hansung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Configuration conf=new Configuration();
        conf.configure();
        SessionFactory sessionFactory=conf.buildSessionFactory();*/

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();// session 만들기
        Transaction tx= session.beginTransaction();

        Product product1 = new Product();
        product1.setName("노트북");
        product1.setPrice(2000);
        product1.setDescription("Awesome Notebook");//id는 할 필요없음 자동적으로 저장할때 만들어짐(@GeneratedValue)

        Product product2 = new Product();
        product2.setName("노트북2");
        product2.setPrice(1000);
        product2.setDescription("Powerful Notebook");

        session.save(product1);//캐시에 저장(반영)
        session.save(product2);//여기서는 또 데이터베이스에 바로 저장함 auto로 놓으면 confused함 hibernate에서 내부적으로 하는것

        /*Product savedProduct = session.get(Product.class,product1.getId());
        System.out.println("saved product: " + savedProduct);*/

        Query<Product> aQuery = session.createQuery("from Product ", Product.class);//HQL
        List<Product> products = aQuery.getResultList();
        System.out.println(products);

        tx.commit();//transaction 닫기?// 이때 insert됨 db에
        session.close();
        sessionFactory.close();
    }
}
