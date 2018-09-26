package com.yy.web.listener.vo.user;

import com.yy.web.listener.vo.BaseEventVO;
import lombok.Data;

/**
 * @author ransheng
 * @desc
 * @create 2018-09-26
 **/
@Data
public class RegisterEventVO extends BaseEventVO<String> {

    public RegisterEventVO(String id) {
        this.id=id;
    }
}
