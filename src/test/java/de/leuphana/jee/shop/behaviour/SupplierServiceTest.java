package de.leuphana.jee.shop.behaviour;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.jee.shop.structure.Article;

public class SupplierServiceTest {

	private SupplierService shop;
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		shop = (SupplierService) applicationContext.getBean("shop");
		
		Article article = new Article();
		article.setArticleId(47111);
		article.setName("Kann weg");
		article.setPrice(12.45);
		shop.addArticleFromSupplier(article);
		
		article = new Article();
		article.setArticleId(815);
		article.setName("Doof");
		article.setPrice(2.5);
		shop.addArticleFromSupplier(article);
	}

	@After
	public void tearDown() throws Exception {
		applicationContext = null;
	}

	@Test()
	public void canNumberOfArticlesBeFetched() {
		Assert.assertEquals(4, shop.getArticles().size());
		// Test auf Exception
//		Assert.assert(shop.addArticleFromSupplier(article));
	}

}
