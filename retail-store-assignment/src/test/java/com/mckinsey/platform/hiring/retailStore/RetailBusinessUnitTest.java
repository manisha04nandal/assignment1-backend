package test.java.com.mckinsey.platform.hiring.retailStore;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import main.java.com.mckinsey.platform.hiring.retailStore.Item;
import main.java.com.mckinsey.platform.hiring.retailStore.model.User;
import main.java.com.mckinsey.platform.hiring.retailStore.model.UserType;
import main.java.com.mckinsey.platform.hiring.retailStore.service.RetailBusinessService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * The Retail store test. This test must pass before the application
 * is submitted for evaluation.
 * 
 * @author manisha nandal
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/spring/retail-store.xml"})
public final class RetailBusinessUnitTest {

	@Autowired ApplicationContext applicationContext;
	
	
	/*@Before
	public void setupInitialData() {
	}*/

	@Test
	public void testEmployee() {
		RetailBusinessService businessService = applicationContext.getBean(RetailBusinessService.class);
		List<Item> items = Arrays.asList(new Item("i1",2,10,"c1"), new Item("i2",1,15,"grocery"),new Item("i3",1,25,"c3"));
		double amount = businessService.getNetPayableAmount(items, new User(UserType.EMPLOYEE,new Date()));
		assertEquals(46.5, amount,0.001);
	}
	
	@Test
	public void testNewCustomer() {
		RetailBusinessService businessService = applicationContext.getBean(RetailBusinessService.class);
		List<Item> items = Arrays.asList(new Item("i1",2,10,"c1"), new Item("i2",1,15,"grocery"),new Item("i3",1,25,"c3"));
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -1);
		double amount = businessService.getNetPayableAmount(items, new User(UserType.CUSTOMER,date.getTime()));
		assertEquals(60, amount,0.001);
	}
	
	@Test
	public void testOldCustomer() {
		RetailBusinessService businessService = applicationContext.getBean(RetailBusinessService.class);
		List<Item> items = Arrays.asList(new Item("i1",2,10,"c1"), new Item("i2",1,15,"grocery"),new Item("i3",1,25,"c3"));
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -2);
		double amount = businessService.getNetPayableAmount(items, new User(UserType.CUSTOMER,date.getTime()));
		assertEquals(57.75, amount,0.001);
	}
	
	@Test
	public void testAffiliate() {
		RetailBusinessService businessService = applicationContext.getBean(RetailBusinessService.class);
		List<Item> items = Arrays.asList(new Item("i1",2,10,"c1"), new Item("i2",1,15,"grocery"),new Item("i3",1,25,"c3"));
		double amount = businessService.getNetPayableAmount(items, new User(UserType.AFFILIATE,new Date()));
		assertEquals(55.5, amount,0.001);
	}
	
	@Test
	public void testBillDiscount() {
		RetailBusinessService businessService = applicationContext.getBean(RetailBusinessService.class);
		List<Item> items = Arrays.asList(new Item("i1",1,100,"c1"), new Item("i2",1,700,"grocery"),new Item("i3",1,150,"c3"));
		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, -1);
		double amount = businessService.getNetPayableAmount(items, new User(UserType.CUSTOMER,date.getTime()));
		assertEquals(905, amount,0.001);
	}

	/*@After
	public void cleanup() {
	}*/
	
	
}
