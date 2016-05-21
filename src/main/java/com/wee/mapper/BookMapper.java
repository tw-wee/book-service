package com.wee.mapper;

import com.wee.entity.BookEntity;
import com.wee.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper extends BaseMapper {
    public BookMapper() {
        register(BookEntity.class, Book.class);
    }
}
