package com.codenvy.gwtginapp.client.dialogbox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class DialogBoxViewImp extends DialogBox implements DialogBoxView {

	public interface DialogBoxBinder extends UiBinder<Widget, DialogBoxViewImp> {
	}

	private ActionDelegate delegate;

	@UiField
	Button butClose;
	@UiField
	TextBox textBoxAddUser;
	@UiField
	VerticalPanel panelDialogBox;

	@Inject
	public DialogBoxViewImp(DialogBoxBinder dialogBoxBinder) {

		setWidget(dialogBoxBinder.createAndBindUi(this));
		setFocusTextBoxAddUser();
	}

	public void setDelegate(ActionDelegate delegate) {
		this.delegate = delegate;
	}

	@UiHandler("butClose")
	void onClickButClose(ClickEvent event) {
		String inputText = textBoxAddUser.getText();
		delegate.onButCloseClicked(inputText);
	}

	@Override
	public void showDialog() {
		center();
		show();
		setFocusTextBoxAddUser();
	}

	@Override
	public void closeDialog() {
		hide();
	}

	@Override
	public void setFocusTextBoxAddUser() {
		textBoxAddUser.setFocus(true);
	}
	
	@Override
	public void setText(String text){
		textBoxAddUser.setText(text);
	}

}
