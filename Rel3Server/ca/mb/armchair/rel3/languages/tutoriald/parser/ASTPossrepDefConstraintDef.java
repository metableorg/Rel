/* Generated By:JJTree: Do not edit this line. ASTPossrepDefConstraintDef.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=ca.mb.armchair.rel3.languages.tutoriald.BaseASTNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package ca.mb.armchair.rel3.languages.tutoriald.parser;

public
class ASTPossrepDefConstraintDef extends SimpleNode {
  public ASTPossrepDefConstraintDef(int id) {
    super(id);
  }

  public ASTPossrepDefConstraintDef(TutorialD p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(TutorialDVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e503c316a4675369c2216bd3088e84a0 (do not edit this line) */
