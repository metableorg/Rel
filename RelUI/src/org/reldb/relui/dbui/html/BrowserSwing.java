package org.reldb.relui.dbui.html;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class BrowserSwing implements HtmlBrowser {
	
	private Composite browserPanel;
	private JTextPane browser;
	private Style style;
		
	private void setEnhancedOutputStyle(JTextPane pane) {
		pane.setContentType("text/html");
		pane.setEditable(false);
		HTMLEditorKit editorKit = new HTMLEditorKit();
		HTMLDocument defaultDocument = (HTMLDocument)editorKit.createDefaultDocument();
		pane.setEditorKit(editorKit);
		pane.setDocument(defaultDocument);
		StyleSheet css = editorKit.getStyleSheet();
		for (String entry: style.getFormattedStyle())
			css.addRule(entry);
	}

	@Override
	public boolean createWidget(Composite parent, Font font) {
	    browserPanel = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
	    Frame frame = SWT_AWT.new_Frame(browserPanel);
	    
	    style = new Style(font);
	    
		browser = new JTextPane();		
		setEnhancedOutputStyle(browser);
		browser.setDoubleBuffered(true);
		DefaultCaret caret = (DefaultCaret)browser.getCaret();
	    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	 		
		JScrollPane jScrollPaneOutput = new JScrollPane();
		jScrollPaneOutput.setAutoscrolls(true);
		jScrollPaneOutput.setViewportView(browser);
		
		frame.add(jScrollPaneOutput);
		
		clear();
		
		return true;
	}

	@Override
	public void clear() {
		browser.setText(style.getEmptyHTMLDocument());
	}

	@Override
	public void appendHtml(String s) {
		HTMLDocument doc = (HTMLDocument)browser.getDocument();
		HTMLEditorKit kit = (HTMLEditorKit)browser.getEditorKit();
	    try {
	    	kit.insertHTML((HTMLDocument) doc, doc.getLength(), s, 0, 0, null);
		} catch (BadLocationException | IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void scrollToBottom() {}

	@Override
	public Control getWidget() {
		return browserPanel;
	}

}
