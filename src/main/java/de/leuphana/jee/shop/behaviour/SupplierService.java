package de.leuphana.jee.shop.behaviour;

import java.util.Set;

import de.leuphana.jee.shop.structure.Article;

public interface SupplierService {
	void addArticleFromSupplier(Article article);

	Set<Article> getArticles();
}