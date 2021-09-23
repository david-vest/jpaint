package controller.interfaces;

public interface ICommand extends Undoable{

  void execute();
}
