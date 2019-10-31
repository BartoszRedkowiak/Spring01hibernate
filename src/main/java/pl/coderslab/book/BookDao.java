package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.GenerationType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book){
        entityManager.persist(book);
    }

    public void update(Book book){
        entityManager.merge(book);
    }

    public Book findOne(Long id){
        return entityManager.find(Book.class, id);
    }

    public void delete(Long id){
        Book book = findOne(id);
        if (book != null){
            entityManager.remove(book);
        }
    }

    public List<Book> findAll(boolean isProposition){
        Query query = entityManager.createQuery("SELECT b FROM Book b where b.proposition = :prop");
        query.setParameter("prop", isProposition);
        return query.getResultList();
    }

    public List<Book> getRatingList(int rating, boolean isProposition){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating and b.proposition = :prop");
        query.setParameter("rating", rating );
        query.setParameter("prop", isProposition );
        return query.getResultList();

    }

}
