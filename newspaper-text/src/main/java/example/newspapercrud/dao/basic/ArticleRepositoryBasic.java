package example.newspapercrud.dao.basic;

import example.newspapercrud.dao.ArticleRepository;
import example.newspapercrud.dao.model.ArticleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleRepositoryBasic  {
    private final List<ArticleEntity> storage = new ArrayList<>();


    public List<ArticleEntity> getAll() {
        return new ArrayList<>(storage); // devolver copia para evitar modificaciones externas
    }




    public Optional<ArticleEntity> getById(int id) {
        return storage.stream()
                .filter(article -> article.getId() == id)
                .findFirst();
    }


    public ArticleEntity save(ArticleEntity article) {
        // asignar id autoincremental si no tiene
        if (article.getId() == 0) {
            int newId = storage.size() + 1;
            article.setId(newId);
        }
        storage.add(article);
        return article;
    }




    public ArticleEntity update(ArticleEntity article) {
        Optional<ArticleEntity> existingOpt = getById(article.getId());
        if (existingOpt.isPresent()) {
            ArticleEntity existing = existingOpt.get();
            existing.setName(article.getName());
            existing.setNpaperId(article.getNpaperId());
            existing.setAvgRanting(article.getAvgRanting());
            existing.setType(article.getType());
            return existing;
        } else {
            throw new IllegalArgumentException("Artículo con id " + article.getId() + " no encontrado");
        }
    }


    public boolean delete(int id) {
        return storage.removeIf(article -> article.getId() == id);
    }
}
