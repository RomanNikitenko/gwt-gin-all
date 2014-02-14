package com.codenvy.gwtginapp.client.table;

import java.util.ArrayList;
import java.util.List;

import com.codenvy.gwtginapp.client.dialogbox.DialogBoxPresenter;
import com.codenvy.gwtginapp.client.user.User;
import com.codenvy.gwtginapp.client.user.UserCreator;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class TablePresenter implements Presenter, UserSubmitHandler,
		TableView.ActionDelegate {

	private TableView tableView;
	private List<User> listUser;
	private DialogBoxPresenter dialogBoxPresenter;

	@Inject
	public TablePresenter(TableView tableView,
			DialogBoxPresenter dialogBoxPresenter) {

		this.dialogBoxPresenter = dialogBoxPresenter;
		this.tableView = tableView;
	}

	@Override
	public void go(HasWidgets container) {
		
		listUser = new ArrayList<User>();
		listUser.addAll(UserCreator.createListUser());

		tableView.setData(listUser);
		tableView.setDelegate(this);

		container.add(tableView.asWidget());
	}

	@Override
	public void onUserSubmit(User user) {
		listUser.add(user);
		tableView.setData(listUser);
	}

	@Override
	public void onClickButRemoveUser(User selectedUser) {
		listUser.remove(selectedUser);
		tableView.setData(listUser);
	}

	@Override
	public void onClickButAddUser() {
		dialogBoxPresenter.showDialog(TablePresenter.this);
	}
}
