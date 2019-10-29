package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book){
        bookDao.save(book);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public Book findOne(Long id){
        return bookDao.findOne(id);
    }

    public void delete(Long id){
        bookDao.delete(id);
    }

    public List<Book> findAll(){
        return bookDao.findAll();
    }

    public Book findBookWithAuthors(Long id) {
        Book book = findOne(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

}
