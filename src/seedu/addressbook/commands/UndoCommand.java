package seedu.addressbook.commands;

import java.util.EmptyStackException;

public class UndoCommand extends Command{
    
    public static final String COMMAND_WORD = "undo";
    
    public static final String MESSAGE_SUCCESS = "Undo successfully.";
    public static final String MESSAGE_EMPTY_COMMAND_HISTORY = "There's no more action available to undo.";

    @Override
    public CommandResult execute() {

        try{
            Undoable command = (Undoable) addressBook.getCommandHistory().pop();
            CommandResult undoResult = command.undo();
            
            return new CommandResult(
                    MESSAGE_SUCCESS + "\n" +
                    "=====Undo Details=====\n" +
                    undoResult.feedbackToUser + "\n"+
                    "==================");
        }catch(EmptyStackException ex){
            return new CommandResult(MESSAGE_EMPTY_COMMAND_HISTORY);
        }catch(ClassCastException cce){
            return new CommandResult("This command is not undoable");
        }
    }
    
    

}
