package example.newspapercrud.dao.jdbc;

import example.newspapercrud.dao.ArticleRepository;
import example.newspapercrud.dao.model.ArticleEntity;
import example.newspapercrud.domain.model.TypeDTO;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class jdbcArticleRepository implements ArticleRepository {
    @Override
    public List<ArticleEntity> getAll() {
        try (
            Connection myConnection= DriverManager.getConnection("jdbc:mysql://dam2.mysql.iesquevedo.es:3335/kevinandzouanadegracia_newspaper","root","quevedo2dam");
            Statement stmt= myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            ResultSet rs=stmt.executeQuery(SQLQueries.GET_ALL_ARTICLES);
            return articlesMapper.mapRS(resultSet)


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return List.of();
    }

    @Override
    public Optional<ArticleEntity> getById(int id) {
        return Optional.empty();
    }

    @Override
    public ArticleEntity save(ArticleEntity article) {
        return null;
    }

    @Override
    public ArticleEntity update(ArticleEntity article) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
