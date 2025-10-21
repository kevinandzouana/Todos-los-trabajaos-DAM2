package example.newspapercrud.domain.service;

import jakarta.inject.Inject;
import example.newspapercrud.dao.ArticleRepository;
import example.newspapercrud.dao.basic.ArticleRepositoryBasic;
import example.newspapercrud.dao.model.ArticleEntity;
import example.newspapercrud.domain.model.ArticleDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArticleService {
    private final ArticleRepository articleRepository;

    @Inject
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public List<ArticleDTO> getAllArticles() {
        List<ArticleEntity> articles = articleRepository.getAll();
        return articles.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ArticleDTO> getArticleById(int id) {
        Optional<ArticleEntity> entityOpt = articleRepository.getById(id);
        return entityOpt.map(this::toDto);
    }


    public ArticleDTO addArticle(ArticleDTO dto) {
        ArticleEntity entity = toEntity(dto);
        ArticleEntity saved = articleRepository.save(entity);
        return toDto(saved);
    }


    public ArticleDTO updateArticle(ArticleDTO dto) {
        ArticleEntity entity = toEntity(dto);
        ArticleEntity updated = articleRepository.update(entity);
        return toDto(updated);
    }


    public boolean deleteArticleById(int id) {
        return articleRepository.delete(id);
    }



    private ArticleDTO toDto(ArticleEntity entity) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNpaperId(entity.getNpaperId());
        dto.setType(dto.getType()); // aquí asumo que entity.getType() devuelve un TypeDTO
        return dto;
    }

    private ArticleEntity toEntity(ArticleDTO dto) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setNpaperId(dto.getNpaperId());
        entity.setType(entity.getType()); // idem arriba
        return entity;
    }
}

