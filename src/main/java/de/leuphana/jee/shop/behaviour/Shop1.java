package de.leuphana.jee.shop.behaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.leuphana.jee.shop.structure.Article;
import de.leuphana.jee.shop.structure.Cart;
import de.leuphana.jee.shop.structure.CartItem;
import de.leuphana.jee.shop.structure.Catalog;
import de.leuphana.jee.shop.structure.CatalogType;
import de.leuphana.jee.shop.structure.Customer;

public class Shop1 implements CustomerService, SupplierService {
	private Catalog catalog;
	private Map<Integer, Customer> customers;

	public Shop1() {
		catalog = new Catalog(CatalogType.SUMMER);

		customers = new HashMap<Integer, Customer>();
	}

	public Integer createCustomerWithCart() {
		Cart cart = new Cart();

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCart(cart);

		return customer.getCustomerId();
	}

	public void addArticleToCart(Integer quantity, Integer articleId, Integer cartId) {

		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setArticleId(articleId);

		for (Customer customer : customers.values()) {
			Cart cart = customer.getCart();
			if (cart.getCartId().equals(cartId)) {
				cart.add(cartItem);
			}
		}
	}

	public Article getArticle(Integer articleId) {
		return catalog.getArticle(articleId);
	}

	public Set<Article> getArticles() {
		// Delegation
		return catalog.getArticles();
	}

	@Override
	public void addArticleFromSupplier(Article article) {
		catalog.getArticles().add(article);
	}

}
