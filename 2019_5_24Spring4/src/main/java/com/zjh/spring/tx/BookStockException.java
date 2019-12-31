package com.zjh.spring.tx;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author ：ZouJiaHui
 * @date ：Created in 2019/7/17 14:36
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class BookStockException extends RuntimeException {

    public BookStockException(String message) {
        super(message);
    }
}
