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
 * @Date 2019-04-27 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="tb_spu_detail" )
public class SpuDetail  implements Serializable {

	private static final long serialVersionUID =  843591698168606105L;

	/**
	 * 对应的SPU表ID
	 */
   	@Column(name = "spu_id" )
	@Id
	private Long spuId;

	/**
	 * 商品描述信息
	 */
   	@Column(name = "description" )
	private String description;

	/**
	 * 全部规格参数数据
	 */
   	@Column(name = "specifications" )
	private String specifications;

	/**
	 * 特有规格参数及可选值信息，json格式
	 */
   	@Column(name = "spec_template" )
	private String specTemplate;

	/**
	 * 包装清单
	 */
   	@Column(name = "packing_list" )
	private String packingList;

	/**
	 * 售后服务
	 */
   	@Column(name = "after_service" )
	private String afterService;

}
