package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.pojos.Item;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
                    rs.getInt("top_id"),
                    rs.getInt("bottom_id"),
                    rs.getInt("shoes_id"),
                    rs.getString("category"),
                    rs.getInt("user_id")
            );


    private final static String INSERT_OUTFIT = "INSERT INTO outfit(" +
            " top_id, " +
            " bottom_id, " +
            " shoes_id, " +
            " category, " +
            " user_id" +
            ") " +
            "VALUES(" +
            " :top_id, " +
            " :bottom_id, " +
            " :shoes_id, " +
            " :category, " +
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

    @Override
    public int insert(int userId, Outfit outfit) {
        final KeyHolder holder = new GeneratedKeyHolder();

        try {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("top_id", outfit.getTop());
            params.addValue("bottom_id", outfit.getBottom());
            params.addValue("shoes_id", outfit.getShoes());
            params.addValue("category", outfit.getCategory());
            params.addValue("user_id", userId);
            jdbc.update(INSERT_OUTFIT, params, holder, new String[] {"id"});

            Number generatedId = holder.getKey();
            return generatedId.intValue();

        } catch (DuplicateKeyException e) {
            return -1;
        }
    }


/*
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
