package by.news.dao;

import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.news.bean.News;
import by.news.bean.NewsCategory;
import by.news.bean.NewsStatus;
import by.news.bean.User;

public class NewsDaoImplTest {

	private static final DaoProvider provider = DaoProvider.getInstance();
	private static final NewsDao newsDao = provider.getNewsDao();

	@BeforeClass
	public static void startUp() throws Exception {
		DBInit.startUp();
	}

	@AfterClass
	public static void shoutDown() throws Exception {
		DBDestroy.shutDown();
	}

	@Test
	public void testInsertNews() {

		News news = new News();
		news.setTitle("Title");
		news.setBrief("Brief");
		news.setContent("Content");
		news.setCategory(NewsCategory.BUSINESS_NEWS);
		news.setDate(LocalDateTime.now());
		news.setStatus(NewsStatus.APPROVED);
		User user = new User();
		user.setId(1);

		news.setUser(user);

		try {
			newsDao.saveNews(news);
			Assert.assertTrue(true);
		} catch (DaoExeption e) {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void testSelectNews() {
		try {
			News news = newsDao.getNews(1);
			Assert.assertTrue(news.getId() == 1);
		} catch (DaoExeption e) {

			Assert.assertTrue(false);
		}
	}

	@Test
	public void testGetNumberOfNews() {
		try {
			long number = newsDao.getNumberOfNews(NewsStatus.APPROVED.ordinal(), "");
			Assert.assertEquals(2, number);

		} catch (DaoExeption e) {
			Assert.assertTrue(false);
		}
	}

}
