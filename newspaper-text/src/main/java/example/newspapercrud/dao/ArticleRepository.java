package example.newspapercrud.dao;

import example.newspapercrud.dao.model.ArticleEntity;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {


        List<ArticleEntity> getAll();


        Optional<ArticleEntity> getById(int id);


        ArticleEntity save(ArticleEntity article);


        ArticleEntity update(ArticleEntity article);


        boolean delete(int id);

    boolean delete(ArticleEntity article, boolean confirmation);
}
