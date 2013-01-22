package kr.bit.digitalhsp.mapping.ui;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class TabDigitalFolder extends ApplicationWindow {

	public TabDigitalFolder() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		final TabFolder tf = new TabFolder(parent, SWT.NONE);
		final ImageMappingUI imageMappingUI = new ImageMappingUI(tf);
		final ImageMappingTranseServerUI imageMappingTranseServerUI = new ImageMappingTranseServerUI(
				tf);

		TabItem chap3 = new TabItem(tf, SWT.NONE);
		chap3.setText("Patient");
		chap3.setControl(imageMappingUI);

		TabItem chap4 = new TabItem(tf, SWT.NONE);
		chap4.setText("Patient2");
		chap4.setControl(imageMappingTranseServerUI);

		tf.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				int selection = tf.getSelectionIndex();
				if (selection == 0) {
					imageMappingUI.resetImageMappingUI();
				} else if (selection == 1) {
					imageMappingTranseServerUI
							.resetImageMappingTranseServerUI();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		return super.createContents(parent);
	}

	public static void main(String[] args) {
		TabDigitalFolder wwin = new TabDigitalFolder();
		wwin.setBlockOnOpen(true);
		wwin.open();
		Display.getCurrent().dispose();
	}
}
