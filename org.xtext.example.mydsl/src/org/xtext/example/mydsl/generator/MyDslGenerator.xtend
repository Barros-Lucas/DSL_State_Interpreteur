package org.xtext.example.mydsl.generator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import fsm.FSM
import org.eclipse.emf.common.util.EList
import fsm.Transition
import fsm.Final
import fsm.Initial
import fsm.State

/**
 * Generates code from your model files on save.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MyDslGenerator extends AbstractGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val myfsm = resource.contents.get(0) as FSM
		
		fsa.generateFile("State.java", generateState())
		fsa.generateFile("Initial.java", generateInitial())
		fsa.generateFile("Final.java", generateFinal())
		fsa.generateFile("FSM.java", generateFSM())
		
		myfsm.state.forEach[s | if(!(s instanceof Final) && !(s instanceof Initial)){
			fsa.generateFile(s.name+".java",generateStateInstance(s.name))}]
		
		fsa.generateFile("Main.java", createMain(myfsm))
		
	}
	
	def generateState() '''public abstract class State {
	
		
		private String name;
		public State(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		
		
	
	}
	'''
	
	def generateInitial() '''public class Initial extends State{
	
		
		public Initial(String name) {
			super(name);
			
		}
	
		
		
	}
	'''

	def generateFinal() '''public class Final extends State{
	
		
		public Final(String name) {
			super(name);
			
		}
	
		
		
	}
	'''

	def generateFSM() '''public class FSM {
			
			private String name;
			private Initial initial;
			private Final finale;
			
			
			private State current;
			
			public FSM (String name, Initial initial, Final finale) {
				this.name = name;
				this.initial = initial;
				this.finale = finale;
				this.current = this.initial;
			}
			
			public void setState(State state) {
				if(!this.current.getName().equals(state.getName())) {
					this.current = state;
				}else {
					//nothing because can't change state
				}
		
			}
		
			public String getName() {
				return name;
			}
		
			public State getInitial() {
				return initial;
			}
		
			public State getFinale() {
				return finale;
			}
		
			public State getCurrent() {
				return current;
			}
			
			 
			
		}
	'''

	def generateStateInstance(String name) '''public class «name» extends State {
	
		public «name»(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}
	
	}'''

	def createMain(FSM myfsm) '''public class Main {
	
		public static void main(String[] args) {
			
			«FOR s:myfsm.state»«IF s instanceof Initial»Initial «s.name» = new Initial("«s.name»");«ENDIF»«ENDFOR»
			«FOR s:myfsm.state»«IF s instanceof Final»Final «s.name» = new Final("«s.name»");«ENDIF»«ENDFOR»
			
			//creation array des state pour facilité le parcour et la vérification qu'un nom n'est deja pas pris pour pas creer 2 fois le meme state ( à changer par singleton)
			
			FSM fsm = new FSM("«myfsm.name»", «FOR s:myfsm.state»«IF s instanceof Initial»«s.name»«ENDIF»«ENDFOR», «FOR s:myfsm.state»«IF s instanceof Final»«s.name»«ENDIF»«ENDFOR»);
			//Ajout des states
			«FOR s:myfsm.state»«IF !(s instanceof Initial) && !(s instanceof Final)»State «s.name» = new «s.name»("«s.name»");«ENDIF»«ENDFOR»
			System.out.println("Début d'éxécution");
			while(!(fsm.getCurrent() instanceof Final)) {
				//Ajout à chaque Transition fabriquée
				«FOR t:myfsm.transition»
					«generateTransition(t.state.get(1).name)»
				«ENDFOR»
			}
			System.out.println("Fin d'éxécution");
			
		}
	
	}'''

	def generateTransition(String name) '''fsm.setState(«name»);'''

}