package com.leyou.item.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * @Description  
 * @Author  duanml
 * @Date 2019-04-22 
 */
@Setter
@Getter
@ToString
@Entity
@Table ( name ="tb_spec_param" )
public class SpecParam  implements Serializable {

	private static final long serialVersionUID =  2537295464168517748L;

	/**
	 * 主键
	 */
	@Id
	@KeySql(useGeneratedKeys = true)
   	@Column(name = "id" )
	private Long id;

	/**
	 * 商品分类id
	 */
   	@Column(name = "cid" )
	private Long cid;

   	@Column(name = "group_id" )
	private Long groupId;

	/**
	 * 参数名
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 是否是数字类型参数，true或false
	 */
   	@Column(name = "`numeric`" )
	private Boolean numeric;

	/**
	 * 数字类型参数的单位，非数字类型可以为空
	 */
   	@Column(name = "unit" )
	private String unit;

	/**
	 * 是否是SKU通用属性，true或false
	 */
   	@Column(name = "generic" )
	private Boolean generic;

	/**
	 * 是否用于搜索过滤，true或false
	 */
   	@Column(name = "searching" )
	private Boolean searching;

	/**
	 * 数值类型参数，如果需要搜索，则添加分段间隔值，1.0-5.2
	 */
   	@Column(name = "segments" )
	private String segments;

}
