package org.reldb.dbrowser.ui.content.rev.core2.operators;

import org.reldb.dbrowser.ui.content.rev.core2.Operator;
import org.reldb.dbrowser.ui.content.rev.core2.Rev;

public class Summarize extends Operator {

	public Summarize(Rev rev, String name, int xpos, int ypos) {
		super(rev.getModel(), name, "SUMMARIZE", xpos, ypos);
		addParameter("Operand", "Relation passed to " + getKind()); 
	}

}
