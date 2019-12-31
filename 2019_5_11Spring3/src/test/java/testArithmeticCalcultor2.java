import com.zjh.spring.xml.ArithmeticCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zjh
 * @Date: 2019/5/11 22:07
 * @Version 1.0
 */
public class testArithmeticCalcultor2 {

    @Test
    public void testArithmeticCalcultor() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spingConfig/applicationContext-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName());

        int result = arithmeticCalculator.add(1,2);
        System.out.println("result:"+ result);

        result = arithmeticCalculator.div(1000,10);
        System.out.println("result:"+result);
    }

}
