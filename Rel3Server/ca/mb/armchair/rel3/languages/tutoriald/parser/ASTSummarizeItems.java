/* Generated By:JJTree: Do not edit this line. ASTSummarizeItems.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=ca.mb.armchair.rel3.languages.tutoriald.BaseASTNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package ca.mb.armchair.rel3.languages.tutoriald.parser;

public
class ASTSummarizeItems extends SimpleNode {
  public ASTSummarizeItems(int id) {
    super(id);
  }

  public ASTSummarizeItems(TutorialD p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(TutorialDVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e8bc2174d35cc3a0707c894121f60e25 (do not edit this line) */
