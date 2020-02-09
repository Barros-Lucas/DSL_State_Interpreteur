package fsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fsm.FSM;
import fsm.Final;
import fsm.Initial;
import fsm.State;
import fsm.Transition;
import fsm.aspects.FSMAspectFSMAspectProperties;
import java.util.Scanner;
import org.eclipse.emf.common.util.EList;

@Aspect(className = FSM.class)
@SuppressWarnings("all")
public class FSMAspect {
  private static State current;
  
  private static String str;
  
  private static boolean nothingDone = false;
  
  public static void interprete(final FSM _self) {
    final fsm.aspects.FSMAspectFSMAspectProperties _self_ = fsm.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void interprete()
    if (_self instanceof fsm.FSM){
    	fsm.aspects.FSMAspect._privk3_interprete(_self_, (fsm.FSM)_self);
    };
  }
  
  private static Scanner sc(final FSM _self) {
    final fsm.aspects.FSMAspectFSMAspectProperties _self_ = fsm.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Scanner sc()
    if (_self instanceof fsm.FSM){
    	result = fsm.aspects.FSMAspect._privk3_sc(_self_, (fsm.FSM)_self);
    };
    return (java.util.Scanner)result;
  }
  
  private static void sc(final FSM _self, final Scanner sc) {
    final fsm.aspects.FSMAspectFSMAspectProperties _self_ = fsm.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void sc(Scanner)
    if (_self instanceof fsm.FSM){
    	fsm.aspects.FSMAspect._privk3_sc(_self_, (fsm.FSM)_self,sc);
    };
  }
  
  protected static void _privk3_interprete(final FSMAspectFSMAspectProperties _self_, final FSM _self) {
    EList<State> _state = _self.getState();
    for (final State state : _state) {
      if ((state instanceof Initial)) {
        FSMAspect.current = state;
      }
    }
    while ((!(FSMAspect.current instanceof Final))) {
      {
        System.out.println("Please enter a trigger :");
        FSMAspect.str = FSMAspect.sc(_self).nextLine();
        System.out.println((("You choose : " + FSMAspect.str) + " transition"));
        FSMAspect.nothingDone = true;
        EList<Transition> _transition = _self.getTransition();
        for (final Transition transition : _transition) {
          String _trigger = transition.getTrigger();
          boolean _equals = Objects.equal(_trigger, FSMAspect.str);
          if (_equals) {
            String _name = transition.getState().get(0).getName();
            String _name_1 = FSMAspect.current.getName();
            boolean _equals_1 = Objects.equal(_name, _name_1);
            if (_equals_1) {
              String _name_2 = FSMAspect.current.getName();
              String _plus = ("Change state from " + _name_2);
              String _plus_1 = (_plus + " to ");
              String _name_3 = transition.getState().get(1).getName();
              String _plus_2 = (_plus_1 + _name_3);
              System.out.println(_plus_2);
              FSMAspect.current = transition.getState().get(1);
              FSMAspect.nothingDone = false;
            }
          }
        }
        if (FSMAspect.nothingDone) {
          System.out.println("This transition does not exist");
        }
      }
    }
    System.out.println("Finial state ");
  }
  
  protected static Scanner _privk3_sc(final FSMAspectFSMAspectProperties _self_, final FSM _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getSc") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.util.Scanner) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.sc;
  }
  
  protected static void _privk3_sc(final FSMAspectFSMAspectProperties _self_, final FSM _self, final Scanner sc) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setSc")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, sc);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.sc = sc;
    }
  }
}
