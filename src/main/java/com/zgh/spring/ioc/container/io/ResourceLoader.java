package com.zgh.spring.ioc.container.io;

import java.net.URL;

public class ResourceLoader extends AbstractResourceLoader {

	@Override
	public Resource loadResource(String name) {
		URL url = ClassLoader.getSystemResource(name);
		return new DefaultResource(url);
	}
}
