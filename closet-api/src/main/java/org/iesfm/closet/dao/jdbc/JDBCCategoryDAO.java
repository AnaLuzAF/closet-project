package org.iesfm.closet.dao.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCCategoryDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCCategoryDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final String INSERT_CATEGORY = "INSERT INTO category(name) VALUES(:name)";
    private static final String SELECT_CATEGORIES = "SELECT * FROM category";
    private static final String DELETE_CATEGORY = "DELETE FROM category WHERE name=:name";

    /*
    @Override
    public boolean addCategory(Category category) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("name", category.getName());
            return jdbc.update(INSERT_CATEGORY, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public List<Category> listAll() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_CATEGORIES,
                (rs, rowNum) ->
                        new Category(
                                rs.getString("name")
                        )
        );
    }

    @Override
    public int deleteCategory(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbc.update(DELETE_CATEGORY, params);
    }

     */
}
