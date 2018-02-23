package de.leuphana.jee.shop.behaviour;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceTest {

	private CustomerService shop;
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		shop = (CustomerService) applicationContext.getBean("shop");
	}

	@After
	public void tearDown() throws Exception {
		applicationContext = null;
	}

	@Test
	public void canNumberOfArticlesBeFetched() {
		Assert.assertEquals(2, shop.getArticles().size());
	}

}
