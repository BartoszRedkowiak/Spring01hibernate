package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class BookConverter implements Converter<String, Book> {

    @Autowired
    BookDao bookDao;

    @Override
    public Book convert(String s) {
        if (s == null || s.isEmpty()){
            return null;
        }
        return bookDao.findOne(Long.parseLong(s));
    }
}
