package pl.coderslab.author;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author){
        authorDao.save(author);
    }

    public void update(Author author){
        authorDao.update(author);
    }

    public Author findOne(Long id){
        return authorDao.findOne(id);
    }

    public void delete(Long id){
        authorDao.deleteAuthorRelations(id);
        authorDao.delete(id);
    }

    public List<Author> findAll(){
        return authorDao.findAll();
    }

    public List<Author> findAllWithBooks(){
        List<Author> authors = authorDao.findAll();
        for (Author author : authors) {
            Hibernate.initialize(author.getBooks());
        }
        return authors;
    }


}
