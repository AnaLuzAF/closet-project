package org.iesfm.closet.dao.jdbc;

import org.iesfm.closet.dao.OutfitDAO;
import org.iesfm.closet.pojos.Outfit;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // IMPLEMENTACION DE LAS QUERIES

    @Override
    public boolean insert(Outfit outfit) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("top", outfit.getTop());
            params.put("bottom", outfit.getBottom());
            params.put("shoes", outfit.getShoes());
            // TODO - buscar el get TAGS en otro ejercicio
            params.put("tags", outfit.getTags());

            return jdbc.update(INSERT_OUTFIT, params) == 1;
        } catch (DuplicateKeyException e) {
            return false;
        }
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
                                rs.getString("top"),
                                rs.getString("bottom"),
                                rs.getString("shoes"),
                                // TODO - buscar lo de list de strings (tags)
                                Collections.singletonList(rs.getString("tags"))
                        )
        );
    }

}
