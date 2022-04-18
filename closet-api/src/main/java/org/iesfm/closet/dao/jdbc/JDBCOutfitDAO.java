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

    private final static String INSERT_OUTFIT = "INSERT INTO outfit(" +
            " top_id, " +
            " bottom_id, " +
            " shoes_id, " +
            " categories" +
            ") " +
            "VALUES(" +
            " :top_id, " +
            " :bottom_id, " +
            " :shoes_id, " +
            " :categories" +
            ")";

    private static final String SELECT_OUTFITS = "SELECT * FROM outfit";

    // seleccionar las categorias de un outfit
    private static final String SELECT_OUTFIT_CATEGORIES = "SELECT categories FROM outfit where id = :id";
    // select * from categories where category in.. category = :name

    // TODO -- hacer consulta bien - NO FUNCIONA - en consola SI FUNCIONA la query que no esta comentada
    //private static final String SELECT_OUTFITS_FROM_CATEGORY = "SELECT o.* FROM outfit o INNER JOIN category c ON o.category=c.name WHERE c.name=:name";
    private static final String SELECT_OUTFITS_FROM_CATEGORY = "SELECT * FROM outfit WHERE categories = :name";



    // IMPLEMENTACION DE LAS QUERIES

    @Override
    public boolean insert(String name, Outfit outfit) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("top_id", outfit.getTop());
            params.put("bottom_id", outfit.getBottom());
            params.put("shoes_id", outfit.getShoes());
            params.put("categories", name);

            return jdbc.update(INSERT_OUTFIT, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    // TODO - no funciona
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
