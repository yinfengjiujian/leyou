package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>Title: com.leyou.item.mapper</p>
 * <p>Company:东软集团(neusoft)</p>
 * <p>Copyright:Copyright(c)</p>
 * User: Administrator
 * Date: 2019/3/20 20:18
 * Description: No Description
 */
public interface BrandMapper extends Mapper<Brand> {

    //向表tb_category_brand插入数据
    @Insert("INSERT INTO tb_category_brand(category_id,brand_id) VALUES(#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid,@Param("bid") Long bid);

    @Select("SELECT a.id,a.name,a.letter,a.image\n" +
            "FROM tb_brand a\n" +
            "INNER JOIN tb_category_brand c on a.id = c.brand_id \n" +
            "where c.category_id=#{cid}")
    List<Brand> queryBrandsByCategoryId(@Param("cid") Long cid);
    
}
