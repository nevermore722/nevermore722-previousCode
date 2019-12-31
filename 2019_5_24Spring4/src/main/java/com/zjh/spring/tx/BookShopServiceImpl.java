package com.zjh.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/7/17 16:53
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    @Override
    public void purchase(String username, String isbn) {
        //1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);


        //2.更新书的库存
        bookShopDao.updateBookStock(isbn);


        //3.更新用户余额
        bookShopDao.updateUserAccount(username,price);

    }
}
