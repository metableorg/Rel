package org.reldb.dbrowser.ui.content.filtersorter;

import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class FilterSorter extends Composite {

	@FunctionalInterface
	public interface FilterSorterUpdate {
		public void update(FilterSorter originator);
	}
		
	private String baseExpression;
	
	private Vector<FilterSorterUpdate> updateListeners = new Vector<>();
	
	private Searcher searcher;
	private Sorter sorter;
	
	void fireUpdate() {
		for (FilterSorterUpdate listener: updateListeners)
			listener.update(this);
	}
	
	public FilterSorter(Composite parent, int style, String baseExpression, FilterSorterState initialState) {
		super(parent, style);
		this.baseExpression = baseExpression;

		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		setLayout(layout);
		
		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		toolBar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		ToolItem tltmQuickSearch = new ToolItem(toolBar, SWT.CHECK);
		ToolItem tltmAdvancedSearch = new ToolItem(toolBar, SWT.CHECK);
		ToolItem tltmSort = new ToolItem(toolBar, SWT.CHECK);
		
		Composite contentPanel = new Composite(this, SWT.NONE);
		contentPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		StackLayout stack = new StackLayout();
		contentPanel.setLayout(stack);

		SearchQuick quickSearchPanel = new SearchQuick(this, contentPanel);
		SearchAdvanced advancedSearchPanel = new SearchAdvanced(this, contentPanel);
		sorter = new Sorter(this, contentPanel);
		
		tltmQuickSearch.setToolTipText("Quick search.");
		tltmQuickSearch.setText("Q");
		tltmQuickSearch.addListener(SWT.Selection, e -> {
			tltmQuickSearch.setSelection(true);
			tltmAdvancedSearch.setSelection(false);
			tltmSort.setSelection(false);
			searcher = quickSearchPanel;
			stack.topControl = quickSearchPanel;
			contentPanel.layout();
		});
		
		tltmAdvancedSearch.setToolTipText("Advanced search...");
		tltmAdvancedSearch.setText("A");
		tltmAdvancedSearch.addListener(SWT.Selection, e -> {
			tltmQuickSearch.setSelection(false);
			tltmAdvancedSearch.setSelection(true);
			tltmSort.setSelection(false);
			searcher = advancedSearchPanel;
			stack.topControl = advancedSearchPanel;
			contentPanel.layout();
		});
		
		tltmSort.setToolTipText("Sort...");
		tltmSort.setText("S");
		tltmSort.addListener(SWT.Selection, e -> {
			tltmQuickSearch.setSelection(false);
			tltmAdvancedSearch.setSelection(false);
			tltmSort.setSelection(true);
			stack.topControl = sorter;
			contentPanel.layout();
		});
		
		tltmQuickSearch.setSelection(true);
		searcher = quickSearchPanel;
		stack.topControl = quickSearchPanel;
		
		if (initialState != null)
			quickSearchPanel.setState(initialState.getRepresentation());
	}

	public FilterSorter(Composite parent, int style, String baseExpression) {
		this(parent, style, baseExpression, null);
	}

	public String getBaseExpression() {
		return baseExpression;
	}
	
	public String getQuery() {
		return "(" + baseExpression + ")" + searcher.getQuery() + sorter.getQuery();
	}
	
	public void addUpdateListener(FilterSorterUpdate updateListener) {
		updateListeners.add(updateListener);
	}
	
	public void removeUpdateListener(FilterSorterUpdate updateListener) {
		updateListeners.remove(updateListener);
	}

	public FilterSorterState getState() {
		return new FilterSorterState(searcher.getState());
	}

}
