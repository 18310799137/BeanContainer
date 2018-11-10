package com.zgh.spring.ioc.container.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DefaultResource extends AbstractResource{

	public DefaultResource(URL url) {
		super(url);
	}

	@Override
	public InputStream getInputStream() {
		InputStream inputStream = null;
		try {
			URLConnection openConnection = url.openConnection();
			inputStream = openConnection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
