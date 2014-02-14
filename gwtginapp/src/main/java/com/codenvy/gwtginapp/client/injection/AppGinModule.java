package com.codenvy.gwtginapp.client.injection;

import com.codenvy.gwtginapp.client.dialogbox.DialogBoxView;
import com.codenvy.gwtginapp.client.dialogbox.DialogBoxViewImp;
import com.codenvy.gwtginapp.client.table.TableView;
import com.codenvy.gwtginapp.client.table.TableViewImp;
import com.google.gwt.inject.client.AbstractGinModule;

public class AppGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(TableView.class).to(TableViewImp.class);
		bind(DialogBoxView.class).to(DialogBoxViewImp.class);
	}

}
