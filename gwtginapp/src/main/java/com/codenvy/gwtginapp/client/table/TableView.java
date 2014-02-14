package com.codenvy.gwtginapp.client.table;

import java.util.List;

import com.codenvy.gwtginapp.client.user.User;
import com.google.gwt.user.client.ui.IsWidget;

public interface TableView extends IsWidget {
	
	interface ActionDelegate{
		
		void onClickButRemoveUser(User selectedUser);
		void onClickButAddUser();
	}
	
	void setData(List<User> userData);
	void setDelegate(ActionDelegate delegate);
}
