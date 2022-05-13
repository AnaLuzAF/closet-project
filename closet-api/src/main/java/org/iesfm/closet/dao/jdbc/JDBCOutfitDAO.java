package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JDBCOutfitDAO implements OutfitDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCOutfitDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static RowMapper<Outfit> OUTFIT_ROW_MAPPER =
            (rs, rowNum) -> new Outfit(
                    rs.getInt("id"),
                    rs.getString("top_id"),
                    rs.getString("bottom_id"),
                    rs.getString("shoes_id"),
                    // consulta que dado un outfit id saque los tags - ver SHOPREST
                    rs.getString("category"),
                    rs.getInt("user_id")
            );


    private final static String INSERT_OUTFIT = "INSERT INTO outfit(" +
            " top_id, " +
            " bottom_id, " +
            " shoes_id, " +
            " category" +
            " user_id" +
            ") " +
            "VALUES(" +
            " :top_id, " +
            " :bottom_id, " +
            " :shoes_id, " +
            " :category" +
            " :user_id" +
            ")";

    private static final String SELECT_OUTFITS = "SELECT * FROM outfit WHERE user_id=:user_id";

    private static final String SELECT_USER_OUTFITS_FROM_CATEGORY = "SELECT * FROM outfit WHERE category=:category AND user_id=:user_id";

    @Override
    public List<Outfit> listUserOutfits(int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id",userId);
        return jdbc.query(SELECT_OUTFITS, params, OUTFIT_ROW_MAPPER);
    }

    @Override
    public List<Outfit> listUserOutfitsByCategory(int userId, String category) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id",userId);
        params.put("category",category);
        return jdbc.query(SELECT_USER_OUTFITS_FROM_CATEGORY ,params,OUTFIT_ROW_MAPPER);
    }


    // IMPLEMENTACION DE LAS QUERIES

    /*
    @Override
    public boolean insert(Outfit outfit) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("top_id", outfit.getTop());
            params.put("bottom_id", outfit.getBottom());
            params.put("shoes_id", outfit.getShoes());
            params.put("category", outfit.getCategory());

            return jdbc.update(INSERT_OUTFIT, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }


    // listar outfits de una categoria
    @Override
    public List<Outfit> listUserOutfitsFromCategory(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbc.query(
                SELECT_USER_OUTFITS_FROM_CATEGORY,
                OUTFIT_ROW_MAPPER
        );
    }

    // listar todos los outfits
    @Override
    public List<Outfit> listUserOutfits() {
        Map<String, Object> params = new HashMap<>();
        return jdbc.query(
                SELECT_OUTFITS,
                OUTFIT_ROW_MAPPER
        );
    }

     */
}
