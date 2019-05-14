package com.leyou.item.pojo;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;

/**
 * @Description  
 * @Author  duanml
 * @Date 2019-04-27 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="tb_spu" )
public class Spu  implements Serializable {

	private static final long serialVersionUID =  7396773559006551878L;

	/**
	 * spu id
	 */
   	@Column(name = "id" )
	@Id
	@KeySql(useGeneratedKeys = true)
	private Long id;

	/**
	 * 标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 子标题
	 */
   	@Column(name = "sub_title" )
	private String subTitle;

	/**
	 * 1级类目id
	 */
   	@Column(name = "cid1" )
	private Long cid1;

	/**
	 * 2级类目id
	 */
   	@Column(name = "cid2" )
	private Long cid2;

	/**
	 * 3级类目id
	 */
   	@Column(name = "cid3" )
	private Long cid3;

	/**
	 * 商品所属品牌id
	 */
   	@Column(name = "brand_id" )
	private Long brandId;

	/**
	 * 是否上架，0下架，1上架
	 */
   	@Column(name = "saleable" )
	private Integer saleable;

	/**
	 * 是否有效，0已删除，1有效
	 */
   	@Column(name = "valid" )
	private Integer valid;

	/**
	 * 添加时间
	 */
   	@Column(name = "create_time" )
	private Date createTime;

	/**
	 * 最后修改时间
	 */
	@JsonIgnore //加上此注解，即在对象返回前端时，忽略此字段
   	@Column(name = "last_update_time" )
	private Date lastUpdateTime;


   	@Transient  //加上此注解 用来区分此属性不是表的实体字段，需要忽视
   	private String cname;

   	@Transient  //加上此注解 用来区分此属性不是表的实体字段，需要忽视
   	private String bname;

}
