import com.zjh.spring.tx.BookShopDao;
import com.zjh.spring.tx.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/7/17 14:17
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class SpringTransactionTest {

    private ApplicationContext ctx = null;

    private BookShopDao bookShopDao = null;

    private BookShopService bookShopService = null;

    {
        ctx = new ClassPathXmlApplicationContext("springConfig/applicationContext.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("AA","1001");
    }

    @Test
    public void testBookShopDaoUpdateUserAccount(){
        bookShopDao.updateUserAccount("AA",200);
    }

    @Test
    public void testBookShopDaoUpdateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }
}
