package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Article;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.services.contract.ArticleLocal;
import tn.esprit.thewalkingdev.services.contract.ArticleRemote;

@Stateless
public class ArticleCrud implements ArticleLocal,ArticleRemote {
	@PersistenceContext(unitName="vgta")
	   EntityManager entityManager ;
	
	@Override
	public Boolean addArticle(Article article) {
		Team t_media = new Team();
		t_media.setId_team(2);
		article.setTeam(t_media);
		entityManager.persist(article);
		return true;
	}

	@Override
	public Boolean updateArticle(Article article) {
		entityManager.merge(article);
		return true;
	}

	@Override
	public void deleteArticle(int id) {
		entityManager.remove(findArticlebyId(id));
		
		
	}

	@Override
	public Article findArticlebyId(Integer idArticle) {
		Article article = null;

		article = entityManager.find(Article.class, idArticle);

		return article;
	}

	@Override
	public List<Article> findAllArticles() {
		Query query = entityManager.createQuery("select a from Article a");
		return query.getResultList();
	}

	@Override
	public List<Article> searchArticle(String keyword){
	Query query = entityManager.createQuery("select a from Article a where a.title like :kw or a.text like :kw");

	query.setParameter("kw", "%"+keyword+"%");
			
	return query.getResultList();
	}
	
}
