package com.xjj.e_15_cache;

/**
 * @Author LJ
 * @Date 2020/12/1
 * msg
 */

public interface BookRepository {
    Book getByIsbn(String isbn);
}
