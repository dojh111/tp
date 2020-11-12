package seedu.lifeasier.commands;

import org.junit.jupiter.api.Test;
import seedu.lifeasier.model.notes.NoteHistory;
import seedu.lifeasier.model.notes.NoteList;
import seedu.lifeasier.model.tasks.Lesson;
import seedu.lifeasier.model.tasks.Task;
import seedu.lifeasier.model.tasks.TaskHistory;
import seedu.lifeasier.model.tasks.TaskList;
import seedu.lifeasier.parser.Parser;
import seedu.lifeasier.storage.FileStorage;
import seedu.lifeasier.ui.Ui;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddLessonCommandTest {
    public static final String TEST_FILEPATH = "testSave.txt";

    private final LocalDateTime sampleTime1 = LocalDateTime.parse("2021-11-11T11:11");
    private final LocalDateTime sampleTime2 = LocalDateTime.parse("2021-12-12T12:12");
    private final LocalDateTime pastSampleTime1 = LocalDateTime.parse("2019-11-11T11:11");
    private final LocalDateTime pastSampleTime2 = LocalDateTime.parse("2019-12-12T12:12");

    @Test
    void execute_validLesson_lessonAddedToTaskList() {
        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        AddLessonCommand command = new AddLessonCommand("testLesson", sampleTime1, sampleTime2, 1);
        Task testLesson = new Lesson("testLesson", sampleTime1, sampleTime2, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(testTaskList.getTask(0).toString(), testLesson.toString());
    }

    @Test
    void execute_dateTimeInThePast_lessonNotAdded() {
        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        AddLessonCommand command = new AddLessonCommand("testLesson", pastSampleTime1, pastSampleTime2, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assert (testTaskList.getTaskList().isEmpty());
    }

    @Test
    void execute_duplicateLesson_lessonNotAdded() {
        Ui ui = new Ui();
        NoteList notes = new NoteList();
        NoteHistory noteHistory = new NoteHistory();
        TaskList testTaskList = new TaskList();
        TaskHistory testTaskHistory = new TaskHistory();
        FileStorage storage = new FileStorage(TEST_FILEPATH, TEST_FILEPATH, ui, notes, testTaskList, noteHistory);
        Parser parser = new Parser();

        AddLessonCommand command = new AddLessonCommand("testLesson", sampleTime1, sampleTime2, 1);

        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        command.execute(ui, notes, testTaskList, storage, parser, noteHistory, testTaskHistory);
        assertEquals(testTaskList.getTaskList().size(), 1);
    }
}
