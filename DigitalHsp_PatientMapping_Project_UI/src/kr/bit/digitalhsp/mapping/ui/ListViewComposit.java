package kr.bit.digitalhsp.mapping.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;

public class ListViewComposit extends ListViewer {

	private List<Object> lists;

	public ListViewComposit(Composite parent, int style) {

		super(parent, style);
		lists = new ArrayList<Object>();
		// TODO Auto-generated constructor stub

	}

	public void addList(String name, Object object) {

		getList().add(name);
		lists.add(object);
	}

	public void deleteListAll() {

		getList().removeAll();
		int listSize = lists.size();
		for (int i = 0; i < listSize; i++)
			lists.remove(0);
	}

	public void deleteList(int index) {
		if (index < 0)
			return;

		if (lists.size() - 1 < index)
			return;

		getList().remove(index);
		lists.remove(index);
	}

	public Object getList(int index) {
		if (index < 0)
			return null;

		if (lists.size() - 1 < index)
			return null;

		return lists.get(index);
	}
}
