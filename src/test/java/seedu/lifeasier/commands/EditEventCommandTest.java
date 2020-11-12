package seedu.lifeasier.commands;

import org.junit.jupiter.api.Test;
import seedu.lifeasier.model.notes.NoteHistory;
import seedu.lifeasier.model.notes.NoteList;
import seedu.lifeasier.model.tasks.Event;
import seedu.lifeasier.model.tasks.Task;
import seedu.lifeasier.model.tasks.TaskDuplicateException;
import seedu.lifeasier.model.tasks.TaskHistory;
import seedu.lifeasier.model.tasks.TaskList;
import seedu.lifeasier.model.tasks.TaskPastException;
import seedu.lifeasier.parser.Parser;
import seedu.lifeasier.storage.FileStorage;
import seedu.lifeasier.ui.Ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditEventCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;

    public static final String TEST_FILEPATH = "testSave.txt";

    private final LocalDateTime sampleTime1 = LocalDateTime.parse("2021-11-11T11:11");
    private final LocalDateTime sampleTime2 = LocalDateTime.parse("2021-12-12T12:12");
    private final LocalDateTime sampleTime3 = LocalDateTime.parse("2021-12-12T12:13");
    private final LocalDateTime sampleTime4 = LocalDateTime.parse("2021-12-12T12:14");

    public void setUpStreams(String input) {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    void execute_validEventAndEditingName_eventNameEdited() throws TaskPastException, TaskDuplicateException {
        setUpStreams("1\n" + "1\n" + "newEvent");

        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        EditEventCommand command = new EditEventCommand("");
        testTaskList.addEvent("oldEvent", sampleTime1, sampleTime2, 1);
        Task newEvent = new Event("newEvent", sampleTime1, sampleTime2, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(newEvent.toString(), testTaskList.getTask(0).toString());

        restoreStreams();
    }

    @Test
    void execute_validEventAndEditingTime_eventNameEdited() throws TaskPastException, TaskDuplicateException {
        setUpStreams("1\n" + "2\n" + "/date 12-12-21 /from 12:12 /to 12:14");

        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        EditEventCommand command = new EditEventCommand("");
        testTaskList.addEvent("testEvent", sampleTime2, sampleTime3, 1);
        Task newEvent = new Event("testEvent", sampleTime2, sampleTime4, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(newEvent.toString(), testTaskList.getTask(0).toString());

        restoreStreams();
    }

    @Test
    void execute_taskNotFound_noAction() throws TaskPastException, TaskDuplicateException {
        setUpStreams("");

        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        EditEventCommand command = new EditEventCommand("garbage");
        testTaskList.addEvent("oldEvent", sampleTime1, sampleTime2, 1);
        Task testEvent = new Event("oldEvent", sampleTime1, sampleTime2, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(testTaskList.getTask(0).toString(), testEvent.toString());

        restoreStreams();
    }
}