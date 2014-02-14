package com.codenvy.gwtginapp.client.entrypoint;

import com.codenvy.gwtginapp.client.dataresources.DataResources;
import com.codenvy.gwtginapp.client.injection.AppGinjector;
import com.codenvy.gwtginapp.client.table.Presenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwtgin implements EntryPoint {

	private final AppGinjector injector = GWT.create(AppGinjector.class);
	private DataResources resources;
	private Presenter tablePresent;

	public void onModuleLoad() {

		resources = injector.getDataResources();
		resources.css().ensureInjected();

		tablePresent = injector.getTablePresenter();
		tablePresent.go(RootLayoutPanel.get());
	}
}
