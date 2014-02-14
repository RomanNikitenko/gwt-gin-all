package com.codenvy.gwtginapp.client.table;

import java.util.List;

import com.codenvy.gwtginapp.client.user.User;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;

public class TableViewImp extends Composite implements TableView {

	public interface TableBinder extends UiBinder<Widget, TableViewImp> {
	}

	private ListDataProvider<User> model;
	private SingleSelectionModel<User> selectionModel;
	private ActionDelegate delegate;

	@UiField
	Button addUser;
	@UiField
	Button removeUser;
	@UiField
	CellTable<User> cellTable;

	@Inject
	public TableViewImp(TableBinder tableBinder) {

		initWidget(tableBinder.createAndBindUi(this));
		
		Column<User, Boolean> checkColumn = new Column<User, Boolean>(
		        new CheckboxCell(true, false)) {
		      @Override
		      public Boolean getValue(User object) {
		        return selectionModel.isSelected(object);
		      }
		    };
		cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));

		TextColumn<User> surnameColumn = new TextColumn<User>() {

			@Override
			public String getValue(User user) {
				return user.getSurname();
			}
		};
		TextColumn<User> nameColumn = new TextColumn<User>() {

			@Override
			public String getValue(User user) {
				return user.getName();
			}
		};
		cellTable.addColumn(surnameColumn, "Surname");
		cellTable.addColumn(nameColumn, "Name");
		
		model = new ListDataProvider<User>();
		model.addDataDisplay(cellTable);

		selectionModel = new SingleSelectionModel<User>();
		cellTable.setSelectionModel(selectionModel);

	}

	public void setData(List<User> userData) {
		model.setList(userData);
	}

	@UiHandler("addUser")
	void onClickButAddUser(ClickEvent event) {
		delegate.onClickButAddUser();
	}

	@UiHandler("removeUser")
	void onClickButRemoveUser(ClickEvent event) {
		User selectedUser = selectionModel.getSelectedObject();
		delegate.onClickButRemoveUser(selectedUser);
		Window.alert("User added successfully!!!");
	}

	@Override
	public void setDelegate(ActionDelegate delegate) {
		this.delegate = delegate;
	}

}
