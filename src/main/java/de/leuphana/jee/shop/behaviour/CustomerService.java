package de.leuphana.jee.shop.behaviour;

import java.util.Set;

import de.leuphana.jee.shop.structure.Article;

public interface CustomerService {
	Integer createCustomerWithCart();
	void addArticleToCart(Integer quantity, Integer articleId, Integer cartId);
	Article getArticle(Integer articleId);
	Set<Article> getArticles();
}