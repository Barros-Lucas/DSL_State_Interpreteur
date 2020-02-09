package fsm.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fsm.FSM
import fsm.State
import fsm.Transition
import fsm.Initial
import fsm.Final

import static extension fsm.aspects.FSMAspect.*
import static extension fsm.aspects.TransitionAspect.*
import static extension fsm.aspects.StateAspect.*
import static extension fsm.aspects.InitialAspect.*
import static extension fsm.aspects.FinalAspect.*
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import fsm.FsmPackage
import java.util.Scanner

class Interpreter {
	def static void main(String[] args) {
		FsmPackage.eINSTANCE.class
		Resource$Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl());
		var Resource resource = new ResourceSetImpl().getResource(URI.createURI('\\Users\\Etu\\Documents\\MasterICE\\meta-diagrame\\dsl_parti2_interpreteur\\fsm\\model\\FSM.xmi'), true);
		var myfsm = resource.contents.get(0) as FSM
		myfsm.interprete
	}
}


@Aspect(className=FSM)
class FSMAspect {
	
		//FSM get a current state
		static State current
		
		//Use scanner to input trigger in run time		
		Scanner sc = new Scanner(System.in)
		static String str	
		
		static boolean nothingDone = false
	
	def void interprete()
	{
		//Initiate the current state with the Initail state found in the ecore model
		for (state : _self.state)
			{
				if (state instanceof Initial)
				{
					current = state
				}
			}
			
		//Run while the current state is not the final state
		while (!(current instanceof Final))
		{
				
			//Scan the input to get the trigger 
			
			System.out.println("Please enter a trigger :");
			str = _self.sc.nextLine();
			System.out.println("You choose : "+str+" transition");
			
			nothingDone = true;
			
			//Parse all transition
			for (transition : _self.transition)
			{
				//Check if transition exist
				if(transition.trigger == str){
					if(transition.state.get(0).name == current.name)
					{
						//Change state
						System.out.println("Change state from "+current.name+" to "+transition.state.get(1).name);
						current = transition.state.get(1);
						
						//somethingDone
						nothingDone = false;
					}
				}

			}
			if(nothingDone){
				System.out.println("This transition does not exist")
			}
			
				
		}
		
		System.out.println("Finial state ")
		
		
	}

}

@Aspect(className=State)
class StateAspect {

}

@Aspect(className=Transition)
class TransitionAspect {

}

@Aspect(className=Initial)
class InitialAspect extends StateAspect {

}

@Aspect(className=Final)
class FinalAspect extends StateAspect {

}



