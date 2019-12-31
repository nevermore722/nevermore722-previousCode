package com.zjh.spring.tx;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/7/16 11:29
 * @description：
 * @modified By：
 * @version: 1.0
 */
public interface BookShopDao {

    /**
     * 根据书号获取书的单价
     * @param isbn
     * @return
     */
    public int findBookPriceByIsbn(String isbn);

    /**
     * 更新数的库存，使书号对应的库存-1
     * @param isbn
     */
    public void updateBookStock(String isbn);

    /**
     * 更新用户的账户余额：使username 的balance - price
     * @param username
     * @param price
     */
    public void updateUserAccount(String username,int price);
}
