package com.zgh.spring.ioc.container.factory;

/**
 * 
 * @ClassName: TagNames
 * @Description: 定义XML资源文件解析标签枚举名称
 * @author Administrator
 * @date 2018年11月10日
 *
 */
public enum TagNames {

	bean("bean"), id("id"), className("class"), property("property"), name("name"), value("value");
	private TagNames(String nameStringText) {
		this.nameStringText=nameStringText;
	}

	private String nameStringText;

	public String getNameStringText() {
		return nameStringText;
	}

	public void setNameStringText(String nameStringText) {
		this.nameStringText = nameStringText;
	}

}
