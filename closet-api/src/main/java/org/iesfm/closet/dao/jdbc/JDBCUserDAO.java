package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.UserDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JDBCUserDAO implements UserDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCUserDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    // QUERIES MYSQL

    //private static final String DELETE_BOOK = "DELETE FROM book WHERE isbn = :isbn ";


    // IMPLEMENTACION DE LAS QUERIES

    /*
    @Override
    public List<Book> bookListByYear(int year) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);

        return jdbc.query(SELECT_BOOK_BY_YEAR, params, ((rs, rowNum) -> new Book(
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year")
        )));
    }*/

}
