package com.codenvy.gwtginapp.client.table;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.codenvy.gwtginapp.client.dialogbox.DialogBoxPresenter;
import com.codenvy.gwtginapp.client.user.User;
import com.codenvy.gwtginapp.client.user.UserCreator;
import com.google.gwt.user.client.ui.HasWidgets;

@RunWith(MockitoJUnitRunner.class)
public class TablePresenterTest {

	@Mock
	private DialogBoxPresenter dialogBoxPresenter;

	@Mock
	private TableView tableView;

	@InjectMocks
	private TablePresenter tablePresenter;

	@Test
	public void onClickButAddUserShouldBeExecuted() {
		tablePresenter.onClickButAddUser();

		verify(dialogBoxPresenter).showDialog(tablePresenter);
	}

	@Test
	public void onUserSubmitShouldBeExecuted() {
		HasWidgets container = mock(HasWidgets.class);
		tablePresenter.go(container);
		reset(tableView);

		final User user = new User("Ivanov", "Ivan");

		doAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				List<User> list = (List<User>) arguments[0];

				assertEquals(4, list.size());
				assertTrue(list.contains(user));
				assertEquals("Ivanov", list.get(3).getSurname());
				assertEquals("Ivan", list.get(3).getName());

				return null;
			}
		}).when(tableView).setData((List<User>) anyObject());

		tablePresenter.onUserSubmit(user);

		verify(tableView).setData((List<User>) anyObject());

	}

	@Test
	public void onClickButRemoveUserShouldBeExecuted() {
		HasWidgets container = mock(HasWidgets.class);
		tablePresenter.go(container);
		reset(tableView);
		List<User> listUser = UserCreator.createListUser();

		doAnswer(new Answer<Object>() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				List<User> list = (List<User>) arguments[0];
				assertEquals(2, list.size());
				return null;
			}

		}).when(tableView).setData((List<User>) anyObject());

		tablePresenter.onClickButRemoveUser(listUser.get(0));

		verify(tableView).setData((List<User>) anyObject());
	}

}
