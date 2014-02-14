package com.codenvy.gwtginapp.client.table;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.codenvy.gwtginapp.client.table.TableViewImp.TableBinder;
import com.codenvy.gwtginapp.client.user.User;
import com.google.gwt.core.shared.GWT;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTest;
import com.googlecode.gwt.test.utils.events.Browser;
import com.codenvy.gwtginapp.client.entrypoint.MyGwtRunner;
@GwtModule("com.codenvy.gwtginapp.gwtgin")
//@RunWith(MyGwtRunner.class)
public class TableViewImpTest extends GwtTest {

	private TableViewImp tableView;
	private TablePresenter tablePresenter;
	TableBinder tableBinder = GWT.create(TableBinder.class);
//	@Before
//	public void setupGIN() {
//		addGwtCreateHandler(new GInjectorCreateHandler());
//		AppGinjector injector = GWT.create(AppGinjector.class);
//		tablePresenter = injector.getTablePresenter();
//		HasWidgets container = mock(HasWidgets.class);
//		tablePresenter.go(container);
//		tableView = tablePresenter.tableView;
//	}
	
	@Before
	
	public void setup(){
		
		tableView = new TableViewImp(tableBinder);
		tablePresenter = mock(TablePresenter.class);
		tableView.setDelegate(tablePresenter);
	}
	
	@Test
	public void clickOnAddButton() {
		
		Browser.click(tableView.addUser);
		
		verify(tablePresenter).onClickButAddUser();
	}

	@Test
	public void clickOnRemoveUserButton() {

		Browser.click(tableView.removeUser);
		
		verify(tablePresenter).onClickButRemoveUser((User) anyObject());
	}

}
