/* Generated By:JJTree: Do not edit this line. ASTAggAnd.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=ca.mb.armchair.rel3.languages.tutoriald.BaseASTNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package ca.mb.armchair.rel3.languages.tutoriald.parser;

public
class ASTAggAnd extends SimpleNode {
  public ASTAggAnd(int id) {
    super(id);
  }

  public ASTAggAnd(TutorialD p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(TutorialDVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=00c55f61e85c2c95171b5457a74a29b6 (do not edit this line) */
