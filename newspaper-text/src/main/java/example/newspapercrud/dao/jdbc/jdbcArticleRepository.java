package example.newspapercrud.dao.jdbc;

import example.newspapercrud.dao.ArticleRepository;
import example.newspapercrud.dao.Utilities.SQLQueries;
import example.newspapercrud.dao.jdbc.mappers.MapArticles;
import example.newspapercrud.dao.model.ArticleEntity;
import example.newspapercrud.domain.error.AppError;
import example.newspapercrud.domain.error.DatabaseError;
import example.newspapercrud.domain.error.FOREIGN_KEY_ERROR;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import static com.mysql.cj.conf.PropertyKey.logger;

public class jdbcArticleRepository implements ArticleRepository {

    private final MapArticles articlesMapper;

    public jdbcArticleRepository(MapArticles articlesMapper) {
        this.articlesMapper = articlesMapper;
    }
    @Override
    public List<ArticleEntity> getAll() {
        List<ArticleEntity> articles = new ArrayList<>();

        String url = "jdbc:mysql://dam2.mysql.iesquevedo.es:3335/kevinandzouanadegracia_newspaper";
        String user = "root";
        String password = "quevedo2dam";

        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SQLQueries.GET_ALL_ARTICLES)
        ) {
            articles = articlesMapper.mapRS(rs);
        } catch (SQLException e) {
            throw new DatabaseError("Error en la base de datos: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new AppError("Error inesperado: " + e.getMessage(), e);
        }

        return articles;
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

    @Override
    public boolean delete(ArticleEntity article, boolean confirmation) {
        try (Connection con = pool.getConnection();
             PreparedStatement deleteArticle = con.prepareStatement(SQLQueries.DELETE_ARTICLE);
             PreparedStatement deleteReadArticle = con.prepareStatement(SQLQueries.DELETE_ARTICLE_READARTICLES);){
            try {
                con.setAutoCommit(false);
                if (confirmation) {
                    deleteReadArticle.setInt(1, articleId);
                    deleteReadArticle.executeUpdate(); }

                deleteArticle.setInt(1, articleId);
                result = deleteArticle.executeUpdate();
                con.commit;
            }  catch (SQLIntegrityConstraintViolationException e) {
                con.rollback();
                //logger.log(Level.SEVERE,e.getMessage(),e);
                throw new FOREIGN_KEY_ERROR();
            catch (SQLException e) {
                    con.rollback();
                    logger.log(Level.SEVERE,e.getMessage(),e);
                    throw new DataBaseError(Constantes.DATA_BASE_ERROR);
                } finally { con.setAutoCommit(true);

                } catch (SQLException sqle) {
                    logger.log(Level.SEVERE,sqle.getMessage(),sqle);
                    throw new DataBaseError(Constantes.DATA_BASE_ERROR);
                }

            }
    }
}}
