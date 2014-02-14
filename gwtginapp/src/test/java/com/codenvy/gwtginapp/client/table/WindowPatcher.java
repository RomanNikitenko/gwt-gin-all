package com.codenvy.gwtginapp.client.table;

import com.google.gwt.user.client.Window;
import com.googlecode.gwt.test.patchers.PatchClass;
import com.googlecode.gwt.test.patchers.PatchMethod;

@PatchClass(Window.class)
public class WindowPatcher {
	
	@PatchMethod(override = true)						
	public static void alert(String msg){
		
	}
}
