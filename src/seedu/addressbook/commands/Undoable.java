package seedu.addressbook.commands;

public interface Undoable {

    public CommandResult undo();
}
