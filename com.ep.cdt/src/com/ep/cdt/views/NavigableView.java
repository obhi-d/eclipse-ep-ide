package com.ep.cdt.views;


import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;


/**
 * Extends CNF and creates a filter box at the top
 * <p>
 * Only works on the resources supported by the current 
 * ui. No extra customization. Can be extended via
 * customizations.
 * <p>
 */

public class NavigableView extends CommonNavigator {
		
	class FilteredCommonTree extends FilteredTree {
		
		public FilteredCommonTree(Composite parent,
				PatternFilter filter, boolean useNewLook) {
			super(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL, filter, useNewLook);
		}
		
		protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
			return NavigableView.super.createCommonViewer(parent);
		}
	}

	
	protected CommonViewer createCommonViewer(Composite aParent) {	
		PatternFilter filter = new PatternFilter();
		FilteredCommonTree commonTree = new FilteredCommonTree(aParent, filter, true);
		return (CommonViewer) commonTree.getViewer();
	}
}