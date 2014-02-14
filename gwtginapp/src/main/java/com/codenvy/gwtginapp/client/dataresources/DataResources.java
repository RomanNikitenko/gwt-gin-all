package com.codenvy.gwtginapp.client.dataresources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface DataResources extends ClientBundle {

	@Source("resources/javaImg.jpg")
	ImageResource imgJava();

	@Source("resources/style.css")
	StyleCss css();

}
