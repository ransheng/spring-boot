package com.yy.web.listener.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-16
 **/
@Data
public class BaseEventVO<T> implements Serializable{

    protected T id;

}
