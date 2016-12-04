package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewalkingdev.entites.Article;

@Local
public interface ArticleLocal {

	Boolean addArticle(Article article);

	Boolean updateArticle(Article article);

	void deleteArticle(int id);

	Article findArticlebyId(Integer idArticle);

	List<Article> findAllArticles();
	
	List<Article> searchArticle(String keyword);
}
