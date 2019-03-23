package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * <p>Title: com.leyou.item.service</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/20 20:19
 * Description: 品牌Service服务类
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    /**
     * 分页查询品牌数据并返回
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows,
                                              String sortBy, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page,rows);

        //过滤条件
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name","%" + key + "%")
                    .orEqualTo("letter",key.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }

        //执行数据库查询操作
        List<Brand> brandList = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brandList)) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }

        //解析分页查询结果
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return new PageResult<>(pageInfo.getTotal(),brandList);
    }


    /**
     * 新增品牌数据、并维护品牌和商品分类中间表数据
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        //保存品牌信息
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if (1 != count) {
            throw new LyException(ExceptionEnum.SAVE_BRAND_ERROR);
        }
        //维护品牌ID 和  商品类别的关系
        for (Long cid : cids) {
            count = brandMapper.insertCategoryBrand(cid, brand.getId());
            if (1 != count) {
                throw new LyException(ExceptionEnum.SAVE_BRAND_ERROR);
            }
        }
    }
}
