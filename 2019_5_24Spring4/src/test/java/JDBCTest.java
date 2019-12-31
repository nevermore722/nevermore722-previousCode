import com.zjh.spring.jdbc.Employee;
import com.zjh.spring.jdbc.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjh
 * @Date: 2019/5/26 12:06
 * @Version 1.0
 */
public class JDBCTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;

    {
        ctx = new ClassPathXmlApplicationContext("springConfig/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = ctx.getBean(EmployeeDao.class);
    }



    /**
     * 获取单个列的值，或做统计查询
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT count(id) FROM employee";
        long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }


    /**
     * 查到实体类的集合
     * 注意调用的不是queryForList值
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id,name,email FROM employee WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql,rowMapper,3);
        System.out.println(employees);

    }

    /**
     * 从数据库中获取一条记录，实际得到对应的一个对象
     * 需要调用queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
     * 1.其中的RowMapper 指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
     * 2.使用SQL中列的别名完成列名的属性名映射
     * 3.不支持级联属性，JdbcTemplate到底是一个JDBC的小工具，而不是ORM框架
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id,name,email,dept_id as \"department.id\" FROM employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employee);
    }

    /**
     * 执行批量更新：批量的INSERT，UPDATE，DELETE
     * 最后一个参数是Object[]的List类型：因为修改一条记录
     * 需要一个Object的数组，那么多条不就需要多个Object的数组
     */
    @Test
    public void testBatchUpdate(){

        String sql = "INSERT INTO employee(name,email,dept_id) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA","aa@atguigu.com",1});
        batchArgs.add(new Object[]{"BB","bb@atguigu.com",2});
        batchArgs.add(new Object[]{"CC","cc@atguigu.com",3});
        batchArgs.add(new Object[]{"DD","dd@atguigu.com",2});
        batchArgs.add(new Object[]{"EE","ee@atguigu.com",1});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /**
     * 执行INSERT,UPDATE,DELETE
     */
    @Test
    public void testUpdate(){
        String sql = "UPDATE employee SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,"ZJH",1);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());

    }
}
