package fsm.aspects;

import fsm.Initial;
import fsm.aspects.InitialAspectInitialAspectProperties;
import java.util.Map;

@SuppressWarnings("all")
public class InitialAspectInitialAspectContext {
  public final static InitialAspectInitialAspectContext INSTANCE = new InitialAspectInitialAspectContext();
  
  public static InitialAspectInitialAspectProperties getSelf(final Initial _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fsm.aspects.InitialAspectInitialAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Initial, InitialAspectInitialAspectProperties> map = new java.util.WeakHashMap<fsm.Initial, fsm.aspects.InitialAspectInitialAspectProperties>();
  
  public Map<Initial, InitialAspectInitialAspectProperties> getMap() {
    return map;
  }
}
