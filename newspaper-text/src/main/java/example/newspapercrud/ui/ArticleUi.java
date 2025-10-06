package example.newspapercrud.ui;

import jakarta.inject.Inject;
import example.newspapercrud.domain.model.ArticleDTO;
import example.newspapercrud.domain.model.TypeDTO; // 👈 Importar tu DTO de tipo
import example.newspapercrud.domain.service.ArticleService;

import java.util.List;
import java.util.Optional; // 👈 Import necesario
import java.util.Scanner;

public class ArticleUi {
    private final ArticleService articleService;

    @Inject
    public ArticleUi(ArticleService articleService) {
        this.articleService = articleService;
    }
    public boolean getArticles() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        if (articles.isEmpty()) {
            System.out.println("No hay artículos registrados.");
        } else {
            articles.forEach(article ->
                    System.out.println("ID: " + article.getId() +
                            ", Nombre: " + article.getName() +
                            ", Periódico ID: " + article.getNpaperId() +
                            ", Rating: " + article.getAvgRanting() +
                            ", Tipo: " + (article.getType() != null ? article.getType().toString() : "N/A"))
            );
        }
        return false;
    }

    // Agregar un artículo
    public ArticleDTO addArticle(Scanner scanner) {
        System.out.print("Ingrese el nombre del artículo: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el ID del periódico: ");
        int npaperId = scanner.nextInt();

        System.out.print("Ingrese el promedio de rating: ");
        double avgRating = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer

        // Aquí supongo que TypeDTO se obtiene de alguna otra forma
        // Por ahora lo dejamos como null
        TypeDTO type = null;

        ArticleDTO article = new ArticleDTO();
        article.setName(name);
        article.setNpaperId(npaperId);
        article.setAvgRanting(avgRating);
        article.setType(type);

        return articleService.addArticle(article);
    }

    // Actualizar un artículo
    public void updateArticle(Scanner scanner) {
        System.out.print("Ingrese el ID del artículo a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Optional<ArticleDTO> existing = articleService.getArticleById(id);
        if (existing.isPresent()) {
            ArticleDTO article = existing.get();

            System.out.print("Nuevo nombre: ");
            String name = scanner.nextLine();
            System.out.print("Nuevo ID de periódico: ");
            int npaperId = scanner.nextInt();
            System.out.print("Nuevo rating promedio: ");
            double avgRating = scanner.nextDouble();
            scanner.nextLine();

            article.setName(name);
            article.setNpaperId(npaperId);
            article.setAvgRanting(avgRating);

            articleService.updateArticle(article);
            System.out.println("Artículo actualizado correctamente.");
        } else {
            System.out.println("No se encontró un artículo con ese ID.");
        }
    }

    // Eliminar un artículo
    public void deleteArticle(Scanner scanner) {
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = articleService.deleteArticleById(id);
        if (deleted) {
            System.out.println("Artículo eliminado correctamente.");
        } else {
            System.out.println("No se encontró un artículo con ese ID.");
        }
    }
}

