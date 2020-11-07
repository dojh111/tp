package seedu.lifeasier.commands;

import org.junit.jupiter.api.Test;
import seedu.lifeasier.model.notes.NoteHistory;
import seedu.lifeasier.model.notes.NoteList;
import seedu.lifeasier.model.tasks.Deadline;
import seedu.lifeasier.model.tasks.Task;
import seedu.lifeasier.model.tasks.TaskHistory;
import seedu.lifeasier.model.tasks.TaskList;
import seedu.lifeasier.parser.Parser;
import seedu.lifeasier.storage.FileStorage;
import seedu.lifeasier.ui.Ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddDeadlineCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    public static final String TEST_FILEPATH = "testSave.txt";

    private final LocalDateTime sampleTime1 = LocalDateTime.parse("2020-11-11T11:11");
    private final LocalDateTime pastSampleTime1 = LocalDateTime.parse("2019-11-11T11:11");

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void execute_validDeadline_deadlineAddedToTaskList() {
        setUpStreams();

        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        AddDeadlineCommand command = new AddDeadlineCommand("testDeadline", sampleTime1, 1);
        Task testDeadline = new Deadline("testDeadline", sampleTime1, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + ui.colourTextGreen("Done! I've added") + System.lineSeparator()
                + ui.colourTextGreen("\"" + testDeadline + "\" ") + System.lineSeparator()
                + ui.colourTextGreen("to your schedule!") + System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + System.lineSeparator(),
            outContent.toString());

        restoreStreams();
    }

    @Test
    void execute_dateTimeInThePast_deadlineNotAdded() {
        setUpStreams();

        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        AddDeadlineCommand command = new AddDeadlineCommand("testDeadline", pastSampleTime1, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + ui.colourTextRed("The timing of this deadline is already in the past!") + System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + System.lineSeparator(),
            outContent.toString());

        restoreStreams();
    }

    @Test
    void execute_duplicateDeadline_deadlineNotAdded() {
        setUpStreams();

        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        AddDeadlineCommand command = new AddDeadlineCommand("testDeadline", sampleTime1, 1);
        Task testDeadline = new Deadline("testDeadline", sampleTime1, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + ui.colourTextGreen("Done! I've added") + System.lineSeparator()
                + ui.colourTextGreen("\"" + testDeadline + "\" ") + System.lineSeparator()
                + ui.colourTextGreen("to your schedule!") + System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + System.lineSeparator()
                + System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + ui.colourTextRed("This deadline or something very similar already exists in your schedule!")
                + System.lineSeparator()
                + Ui.THICK_SEPARATOR + System.lineSeparator()
                + System.lineSeparator(),
            outContent.toString());

        restoreStreams();
    }
}
