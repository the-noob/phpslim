package slim;

import fitnesse.slim.Jsr232Bridge;
import fitnesse.slim.Jsr232StatementExecutor;

public class PhpStatementExecutor extends Jsr232StatementExecutor {

  public PhpStatementExecutor(Jsr232Bridge bridge) throws Exception
  {
    super(bridge);
  }
  
  @Override
  public void setVariable(String name, Object value) {
    // Packing the value into a single element array, because a null value
    // caused the proxy call to hang.
    callMethod("setSymbol", new Object[] {name, new Object[] {value}});
  }
}
