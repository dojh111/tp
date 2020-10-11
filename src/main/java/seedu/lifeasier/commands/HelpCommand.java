package seedu.lifeasier.commands;

import seedu.lifeasier.storage.FileStorage;
import seedu.lifeasier.tasks.TaskList;
import seedu.lifeasier.ui.Ui;
import seedu.lifeasier.notes.NoteList;

public class HelpCommand extends Command {

    @Override
    public void execute(Ui ui, NoteList notes, TaskList tasks, FileStorage storage) {
        ui.showHelp();
    }
}