/* Generated By:JJTree: Do not edit this line. ASTSummarizeOr.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=ca.mb.armchair.rel3.languages.tutoriald.BaseASTNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package ca.mb.armchair.rel3.languages.tutoriald.parser;

public
class ASTSummarizeOr extends SimpleNode {
  public ASTSummarizeOr(int id) {
    super(id);
  }

  public ASTSummarizeOr(TutorialD p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(TutorialDVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=2c53cd03b4eced957cc3faddb083f1a7 (do not edit this line) */
