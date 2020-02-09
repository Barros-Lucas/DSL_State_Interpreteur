package org.xtext.example.mydsl.generator;

import fsm.FSM;
import fsm.Final;
import fsm.Initial;
import fsm.State;
import fsm.Transition;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MyDslGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _get = resource.getContents().get(0);
    final FSM myfsm = ((FSM) _get);
    fsa.generateFile("State.java", this.generateState());
    fsa.generateFile("Initial.java", this.generateInitial());
    fsa.generateFile("Final.java", this.generateFinal());
    fsa.generateFile("FSM.java", this.generateFSM());
    final Consumer<State> _function = new Consumer<State>() {
      @Override
      public void accept(final State s) {
        if (((!(s instanceof Final)) && (!(s instanceof Initial)))) {
          String _name = s.getName();
          String _plus = (_name + ".java");
          fsa.generateFile(_plus, MyDslGenerator.this.generateStateInstance(s.getName()));
        }
      }
    };
    myfsm.getState().forEach(_function);
    fsa.generateFile("Main.java", this.createMain(myfsm));
  }
  
  public CharSequence generateState() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public abstract class State {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public State(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return name;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitial() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Initial extends State{");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public Initial(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super(name);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateFinal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Final extends State{");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public Final(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super(name);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateFSM() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class FSM {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private Initial initial;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private Final finale;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("private State current;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public FSM (String name, Initial initial, Final finale) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.initial = initial;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.finale = finale;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.current = this.initial;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void setState(State state) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if(!this.current.getName().equals(state.getName())) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("this.current = state;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("//nothing because can\'t change state");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return name;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public State getInitial() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return initial;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public State getFinale() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return finale;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public State getCurrent() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return current;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateStateInstance(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    _builder.append(name);
    _builder.append(" extends State {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public ");
    _builder.append(name, "\t\t");
    _builder.append("(String name) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("super(name);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// TODO Auto-generated constructor stub");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence createMain(final FSM myfsm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Main {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    {
      EList<State> _state = myfsm.getState();
      for(final State s : _state) {
        {
          if ((s instanceof Initial)) {
            _builder.append("Initial ");
            String _name = ((Initial)s).getName();
            _builder.append(_name, "\t\t\t");
            _builder.append(" = new Initial(\"");
            String _name_1 = ((Initial)s).getName();
            _builder.append(_name_1, "\t\t\t");
            _builder.append("\");");
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      EList<State> _state_1 = myfsm.getState();
      for(final State s_1 : _state_1) {
        {
          if ((s_1 instanceof Final)) {
            _builder.append("Final ");
            String _name_2 = ((Final)s_1).getName();
            _builder.append(_name_2, "\t\t\t");
            _builder.append(" = new Final(\"");
            String _name_3 = ((Final)s_1).getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append("\");");
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//creation array des state pour facilité le parcour et la vérification qu\'un nom n\'est deja pas pris pour pas creer 2 fois le meme state ( à changer par singleton)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("FSM fsm = new FSM(\"");
    String _name_4 = myfsm.getName();
    _builder.append(_name_4, "\t\t\t");
    _builder.append("\", ");
    {
      EList<State> _state_2 = myfsm.getState();
      for(final State s_2 : _state_2) {
        {
          if ((s_2 instanceof Initial)) {
            String _name_5 = ((Initial)s_2).getName();
            _builder.append(_name_5, "\t\t\t");
          }
        }
      }
    }
    _builder.append(", ");
    {
      EList<State> _state_3 = myfsm.getState();
      for(final State s_3 : _state_3) {
        {
          if ((s_3 instanceof Final)) {
            String _name_6 = ((Final)s_3).getName();
            _builder.append(_name_6, "\t\t\t");
          }
        }
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("//Ajout des states");
    _builder.newLine();
    _builder.append("\t\t\t");
    {
      EList<State> _state_4 = myfsm.getState();
      for(final State s_4 : _state_4) {
        {
          if (((!(s_4 instanceof Initial)) && (!(s_4 instanceof Final)))) {
            _builder.append("State ");
            String _name_7 = s_4.getName();
            _builder.append(_name_7, "\t\t\t");
            _builder.append(" = new ");
            String _name_8 = s_4.getName();
            _builder.append(_name_8, "\t\t\t");
            _builder.append("(\"");
            String _name_9 = s_4.getName();
            _builder.append(_name_9, "\t\t\t");
            _builder.append("\");");
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"Début d\'éxécution\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("while(!(fsm.getCurrent() instanceof Final)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("//Ajout à chaque Transition fabriquée");
    _builder.newLine();
    {
      EList<Transition> _transition = myfsm.getTransition();
      for(final Transition t : _transition) {
        _builder.append("\t\t\t\t");
        CharSequence _generateTransition = this.generateTransition(t.getState().get(1).getName());
        _builder.append(_generateTransition, "\t\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"Fin d\'éxécution\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    return _builder;
  }
  
  public CharSequence generateTransition(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("fsm.setState(");
    _builder.append(name);
    _builder.append(");");
    return _builder;
  }
}
