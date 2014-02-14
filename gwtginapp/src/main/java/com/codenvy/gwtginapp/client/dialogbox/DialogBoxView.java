package com.codenvy.gwtginapp.client.dialogbox;

import com.codenvy.gwtginapp.client.table.UserSubmitHandler;
import com.google.gwt.user.client.ui.IsWidget;

public interface DialogBoxView extends IsWidget {

	public interface ActionDelegate {
		void onButCloseClicked(String inputText);

	}

	void setDelegate(ActionDelegate delegate);

	void showDialog();

	void closeDialog();

	void setFocusTextBoxAddUser();
	
	void setText(String text);
}
