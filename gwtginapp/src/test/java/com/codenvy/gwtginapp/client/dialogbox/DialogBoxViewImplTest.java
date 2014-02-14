package com.codenvy.gwtginapp.client.dialogbox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static com.googlecode.gwt.test.assertions.GwtAssertions.assertThat;

import com.codenvy.gwtginapp.client.dialogbox.DialogBoxViewImp.DialogBoxBinder;
import com.codenvy.gwtginapp.client.entrypoint.MyGwtRunner;
import com.google.gwt.core.shared.GWT;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTest;
import com.googlecode.gwt.test.utils.events.Browser;

@GwtModule("com.codenvy.gwtginapp.gwtgin")
//@RunWith(MyGwtRunner.class)
public class DialogBoxViewImplTest extends GwtTest{
	
	private DialogBoxBinder dialogBoxBinder = GWT.create(DialogBoxBinder.class);
	private DialogBoxViewImp dialogBoxView;
	private DialogBoxPresenter dialogBoxPresenter; 
	
	@Before
	public void setup(){
		
		
		dialogBoxView = new DialogBoxViewImp(dialogBoxBinder);
		dialogBoxPresenter = mock(DialogBoxPresenter.class);
		dialogBoxView.setDelegate(dialogBoxPresenter);
	}
	
	@Test
	public void clickOnButClose(){
		Browser.click(dialogBoxView.butClose);
		
		verify(dialogBoxPresenter).onButCloseClicked((String) anyObject());
	}
	
	@Test
	public void showDialogShouldBeDisplayDialogBox(){
		assertThat(dialogBoxView).isNotVisible();
		
		dialogBoxView.showDialog();
		
		assertThat(dialogBoxView).isVisible();
	}
	
	@Test
	public void closeDialogShouldBeHideDialogBox(){
		dialogBoxView.showDialog();
		assertThat(dialogBoxView).isVisible();
		
		dialogBoxView.closeDialog();
		
		assertThat(dialogBoxView).isNotVisible();
	}
	
	@Test
	public void setTextShouldBeSetTextInTxtBox(){
		dialogBoxView.setText("xxx");
		
		assertThat(dialogBoxView.textBoxAddUser).textEquals("xxx");
	}
	
	
	

}
