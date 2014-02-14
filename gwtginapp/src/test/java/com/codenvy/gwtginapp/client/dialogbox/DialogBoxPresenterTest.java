package com.codenvy.gwtginapp.client.dialogbox;

import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.anyObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.codenvy.gwtginapp.client.table.UserSubmitHandler;
import com.codenvy.gwtginapp.client.user.User;

@RunWith(MockitoJUnitRunner.class)
public class DialogBoxPresenterTest {

	@Mock(answer = Answers.RETURNS_DEFAULTS)
	private DialogBoxView dialogBoxView;
	
	@Mock
	private UserSubmitHandler userSubmitHandler;

	@InjectMocks
	private DialogBoxPresenter dialogBoxPresenter;

	@Test
	public void showDialogShouldBeExecuted() {

		dialogBoxPresenter.showDialog(userSubmitHandler);
		
		verify(dialogBoxView).showDialog();
	}

	@Test
	public void closeButtonShouldBeExecuted() {
		dialogBoxPresenter.showDialog(userSubmitHandler);
		String newUser = "Ivanov Ivan";
		
		dialogBoxPresenter.onButCloseClicked(newUser);
		
		verify(userSubmitHandler).onUserSubmit((User) anyObject());
		verify(dialogBoxView).setText("");
		verify(dialogBoxView).closeDialog();
	}
}
