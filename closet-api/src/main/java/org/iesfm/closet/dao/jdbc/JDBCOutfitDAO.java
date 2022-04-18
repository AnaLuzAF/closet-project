package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JDBCOutfitDAO implements OutfitDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCOutfitDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // añadir outfit a una categoria

    // TODO - INSERTAR UN OUTFIT EN UNA CATEGORIA - HACER TABLA NUEVA BBDD??
    // TODO - INSERT OUTFIT INTO CATEGORY
    // TODO - falta userId??
    private final static String INSERT_OUTFIT = "INSERT INTO outfit(" +
            " top, " +
            " bottom, " +
            " shoes, " +
            " tags" +
            ") " +
            "VALUES(" +
            " :top, " +
            " :bottom, " +
            " :shoes, " +
            " :tags" +
            ")";

    private static final String SELECT_OUTFITS = "SELECT * FROM outfit";

    // seleccionar las categorias de un outfit
    private static final String SELECT_OUTFIT_CATEGORIES = "SELECT categories FROM outfit where id = :id";

    // TODO -- hacer consulta bien
    private static final String SELECT_OUTFITS_FROM_CATEGORY = "SELECT o.* FROM outfit o INNER JOIN category c ON o.category=c.name WHERE c.name=:name";

    /*
    private static final String SELECT_LENT_BOOKS = "" +
            "SELECT " +
            "o.* " +
            "FROM outfit o " +
            "INNER JOIN category c " +
            "ON o.category=c.name " +
            "WHERE c.name=:name";

    private static final String SELECT_AVAILABLE_BOOKS = "" +
            "SELECT " +
            "* " +
            "FROM book " +
            "WHERE isbn NOT IN (" +
            "SELECT DISTINCT isbn FROM book_lend WHERE status=1" +
            ")";
*/

    // IMPLEMENTACION DE LAS QUERIES



    @Override
    public boolean insert(Outfit outfit) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("top", outfit.getTop());
            params.put("bottom", outfit.getBottom());
            params.put("shoes", outfit.getShoes());
            // TODO - buscar el get TAGS en otro ejercicio
            params.put("tags", outfit.getCategories());

            return jdbc.update(INSERT_OUTFIT, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public List<Outfit> listOutfitsFromCategory(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbc.query(
                SELECT_OUTFITS_FROM_CATEGORY,
                (rs, rowNum) ->
                        new Outfit(
                                rs.getInt("id"),
                                rs.getString("top_id"),
                                rs.getString("bottom_id"),
                                rs.getString("shoes_id"),
                                Arrays.asList(rs.getString("categories"))
                        )
        );
    }

    // listar todos los outfits
    @Override
    public List<Outfit> listAll() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_OUTFITS,
                (rs, rowNum) ->
                        new Outfit(
                                rs.getInt("id"),
                                rs.getString("top_id"),
                                rs.getString("bottom_id"),
                                rs.getString("shoes_id"),
                                Arrays.asList(rs.getString("categories"))
                        )
        );
    }
}
