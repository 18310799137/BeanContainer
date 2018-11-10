package com.zgh.spring.ioc.container.io;

import java.net.URL;

public abstract class AbstractResource implements Resource {

	protected URL url;

	public AbstractResource(URL url) {
		this.url = url;
	}

}
