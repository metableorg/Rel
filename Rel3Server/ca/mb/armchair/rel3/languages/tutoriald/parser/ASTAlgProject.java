/* Generated By:JJTree: Do not edit this line. ASTAlgProject.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=ca.mb.armchair.rel3.languages.tutoriald.BaseASTNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package ca.mb.armchair.rel3.languages.tutoriald.parser;

public
class ASTAlgProject extends SimpleNode {
  public ASTAlgProject(int id) {
    super(id);
  }

  public ASTAlgProject(TutorialD p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(TutorialDVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=19570c7fda4b53a0e3cad34c4fe4fc94 (do not edit this line) */
