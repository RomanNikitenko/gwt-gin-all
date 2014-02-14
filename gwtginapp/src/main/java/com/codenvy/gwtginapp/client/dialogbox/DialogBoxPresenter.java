package com.codenvy.gwtginapp.client.dialogbox;

import com.codenvy.gwtginapp.client.table.UserSubmitHandler;
import com.codenvy.gwtginapp.client.user.User;
import com.codenvy.gwtginapp.client.user.UserCreator;
import com.google.inject.Inject;

public class DialogBoxPresenter implements DialogBoxView.ActionDelegate {

	private DialogBoxView dialogBoxView;
	private UserSubmitHandler userSubmitHandler;

	@Inject
	public DialogBoxPresenter(DialogBoxView dialogBoxView) {		
		this.dialogBoxView = dialogBoxView;
		dialogBoxView.setDelegate(this);
	}

	public void showDialog(UserSubmitHandler userSubmitHandler) {
		this.userSubmitHandler = userSubmitHandler;
		dialogBoxView.showDialog();
	}

	@Override
	public void onButCloseClicked(String inputText) {
		User newUser = UserCreator.createUser(inputText);
		userSubmitHandler.onUserSubmit(newUser);
		
		dialogBoxView.setText("");
		dialogBoxView.closeDialog();
	}
	
}
