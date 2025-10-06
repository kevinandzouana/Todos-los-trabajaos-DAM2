package example.newspapercrud.dao.jdbc.mappers;

import org.example.newspapercrud.dao.model.ArticleEntity;
import org.example.newspapercrud.dao.model.TypeEntity;
import org.example.newspapercrud.domain.model.TypeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapArticles {
    public List<ArticleEntity> mapRS(ResultSet rs) throws SQLException {
        List<ArticleEntity> list=new ArrayList<>();
        while (rs.next()) {
            list.add(new ArticleEntity(
                    rs.getInt("id"),
                    rs.getString("name_article"),
                    new TypeEntity(rs.getInt("type_id"),rs.getString()),
                    rs.getInt("id_newspaper")

            ));
        }
        return list;
    }
}
