package pl.coderslab.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String s) {
        if (s == null || s.isEmpty()){
            return null;
        }
        return authorDao.findOne(Long.parseLong(s));
    }
}
