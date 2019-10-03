package com.excel.mapper;

import com.excel.entity.po.TtlProductInfoPo;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-10-02 23:06
 */
public interface TtlProductInfoMapper {
    List<TtlProductInfoPo> listProduct(Map<String, Object> map);
}
