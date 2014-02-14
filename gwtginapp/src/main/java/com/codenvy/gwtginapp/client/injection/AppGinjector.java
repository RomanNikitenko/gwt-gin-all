package com.codenvy.gwtginapp.client.injection;

import com.codenvy.gwtginapp.client.dataresources.DataResources;
import com.codenvy.gwtginapp.client.table.TablePresenter;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(AppGinModule.class)
public interface AppGinjector extends Ginjector {

	TablePresenter getTablePresenter();

	DataResources getDataResources();
}
