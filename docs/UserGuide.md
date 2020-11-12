# LifEasier User Guide

## Table of Contents

* [1.0 Introduction](#10-introduction)
* [2.0 Quick Start](#20-quick-start)
* [3.0 User Features](#30-user-features)
    * [3.1 Viewing Help: `help`](#31-viewing-help-help)
    * [3.2 Adding a Lesson: `addLesson`](#32-adding-a-lesson-addlesson)
    * [3.3 Adding an Event: `addEvent`](#33-adding-an-event-addevent)
    * [3.4 Adding a Deadline: `addDeadline`](#34-adding-a-deadline-adddeadline)
    * [3.5 Editing a Lesson: `editLesson`](#35-editing-a-lesson-editlesson)
    * [3.6 Editing an Event: `editEvent`](#36-editing-an-event-editevent)
    * [3.7 Editing a Deadline: `editDeadline`](#37-editing-a-deadline-editdeadline)
    * [3.8 Deleting a Task: `deleteTask`](#38-deleting-a-task-deletetask)
    * [3.9 Undoing an Edit or Deletion: `undo`](#39-undoing-an-edit-or-deletion--undo)
    * [3.10 Displaying Schedule: `display`](#310-displaying-schedule-display)
    * [3.11 Viewing Available Free Time: `freeTime`](#311-viewing-available-free-time-freetime)
    * [3.12 Viewing Available Sleep Time: `sleepTime`](#312-viewing-available-sleep-time-sleeptime)
    * [3.13 Adding a New Note: `addNotes`](#313-adding-a-new-note-addnotes)
    * [3.14 Showing Notes: `showNotes`](#314-showing-notes-shownotes)
    * [3.15 Deleting a Note: `deleteNotes`](#315-deleting-a-note-deletenotes)
    * [3.16 Editing a Note: `editNotes`](#316-editing-a-note-editnotes)
    * [3.17 Archiving Notes: `archive`](#317-archiving-notes-archive)
    * [3.18 Exiting: `exit`](#318-exiting-exit)
* [4.0 Other Features](#40-other-features)
    * [4.1 Storing Data](#41-storing-data)
    * [4.2 Recurring Tasks and Auto Deletion](#42-recurring-tasks-and-auto-deletion)
* [5.0 FAQ](#50-faq)
* [6.0 Command Summary](#60-command-summary)

<div style="page-break-after: always;"></div>

## 1.0 Introduction

**LifEasier** helps Computer Engineering (CEG) students to manage their classes, social events, deadlines and school notes through the Command Line Interface (CLI). The CLI allows **LifEasier** to deliver this functionality through a lightweight and easy to use interface. If you can type fast, **LifEasier** can get your timetabling needs done faster than a traditional GUI app.

This User Guide serves as an all-in-one document for users to set up and use **LifEasier**. To use this User Guide, simply refer to the Table of Contents to find what you are looking for. The [Quick Start](#20-quick-start) section gives instructions on how to set up and start using **LifEasier**. The [User Features](#30-user-features) and [Other Features](#40-other-features) sections gives in-depth instructions on how to best use every feature **LifEasier** has to offer. The [FAQ](#50-faq) section answers some common queries that you might have. Lastly, the [Command Summary](#60-command-summary) provides a convenient summary of the commands you have available to use.

In order to get the best experience when using this User Guide, please refer to the legend below in Table 1-1.

_Table 1-1: A summary of the special symbols and fonts used in this User Guide_

Item | Meaning
-----|--------
![Notes](images/UserGuide/post-it.png) | Sections with this icon contain pointers you should take note of. You'll see these mostly in the [User Features](#30-user-features) section.
`code snippets` | If you see words like this within blocks of normal text, they are probably related to more technical terms. If you see entire sections that appear in this font, they are usually examples of how to use LifEasier. You'll also see the latter mostly in the [User Features](#30-user-features) section.

<div style="page-break-after: always;"></div>

## 2.0 Quick Start

This section describes the process of setting up **LifEasier** for use.

1. Ensure you have the latest version of `Java 11` installed on your computer.
1. Download the latest version of  `LifEasier.jar` from [here](https://github.com/AY2021S1-CS2113T-W13-4/tp/releases).
1. Copy the downloaded Jar file  to a suitable location in your computer. *(Note: **LifEasier** will create a folder for save files in the same folder you ran the jar file.)*
1. Open a new **terminal window**  and navigate to where your `LifEasier.jar` is located on your computer.
1. Enter the following command into the terminal window to launch the application:
 `java -jar LifEasier.jar`
On successful launch, you will be greeted with a welcome screen as shown below in Figure 2-1.

```
Reading your save data. New saves will be created if no saves are found.
===============================================================================================================
===============================================================================================================

  _      _  __ ______          _
 | |    (_)/ _|  ____|        (_)
 | |     _| |_| |__   __ _ ___ _  ___ _ __
 | |    | |  _|  __| / _` / __| |/ _ \ '__|
 | |____| | | | |___| (_| \__ \ |  __/ |
 |______|_|_| |______\__,_|___/_|\___|_|


===============================================================================================================
===============================================================================================================
Hello! What can I do for you today?
 -Type 'help' for a list the list of available commands
```

_Figure 2-1: LifEasier’s welcome screen_

<div style="page-break-after: always;"></div>

1. You are now ready to use **LifEasier.** Type commands into the terminal window and press enter to execute the command. E.g Type  help and press enter to bring up the list of  available commands.
1. Generally, green coloured text is displayed when commands have been completed successfully, or contains helpful information for you. Red coloured text is displayed when unexpected errors have occurred, or when you have entered invalid information. Cyan coloured text is usually displayed when the system needs your input.
1. If the colours of the text seem jarring, try changing your CLI to a black background.
1. Refer to the [User Features](#30-user-features) section below to find more details on available commands.

## 3.0 User Features
The following section expands on the features available for you to use in **LifEasier**. The explanation for each feature includes the format to be followed, at least one example, and some further explanation and notes if necessary.

#### ![Notes](images/UserGuide/post-it.png) Notes on General Command Format:

* Words in `UPPER_CASE` are parameters to be supplied by the user.
* Items in square brackets are optional e.g `[TITLE]`
* **Some** commands can be filled in **partially** and still work. These commands will be stated in the detailed command information below.
* Command parameters **must** follow the **order stated**, including partial commands. E.g if the command states `addEvent NAME /from START /to END`,  `addEvent NAME /to END /from START` will **NOT** be accepted.
* `DATE` parameters have the format of **DD-MM-YY**.
* `TIME` parameters follow a 24-hour clock, and have the format of **HH:mm**.
* **LifEasier** does not support `00:00` as a valid time for midnight. Instead, use `24:00`, which will automatically be converted to `23:59` by the program.
* Currently, **LifEasier** does not allow tasks to be added that span multiple days. However, this feature will be added in a future version of **LifEasier**.

### 3.1 Viewing Help: `help`
This command shows you the available commands and their formats.

**Format:** `help`

#### Example:
An example of how to use the help command is shown below in Figure 3.1-1.

````
help

==========================================================================================
These are the commands that are available:
IMPORTANT INFORMATION:
 * Words in UPPER_CASE are the parameters to be supplied by the user
 * Commands are CASE SENSITIVE
 * Command parameters have to be input in the order as stated
 * Items in square brackets are optional, e.g [DATE]
 * Commands with the [P] can take partial commands
   e.g addLesson and addLesson /code CS2113 /to 18:00 are valid commands
 * All dates are in the DD-MM-YY and times in the HH:MM format
 * For tasks that end at midnight, enter the time as 24:00

COMMANDS
****************************************************************************************
help ------------------------------------------------------- Displays available commands
addLesson /code MODULE /date DATE /from START /to END /repeats TIMES -- [P]Adds a lesson
addEvent EVENT_NAME /date DATE /from START /to END /repeats TIMES ----- [P]Adds an event
addDeadline DEADLINE_NAME /by DATETIME /repeats TIMES --------------- [P]Adds a deadline
editLesson MODULE ---------------------------------------------------- [P]Edits a lesson
editEvent EVENT_NAME ------------------------------------------------- [P]Edits an event
editDeadline DEADLINE_NAME ----------------------------------------- [P]Edits a deadline
deleteTask /type TYPE /name NAME ---------------------------------------- Deletes a task
addNotes TITLE ------------------------------------------------------ [P]Adds a new note
showNotes TITLE ------------------------------------------------- [P]Shows selected note
archive ---------------------------------------------------- Archives all existing notes
editNotes TITLE ----------------------------------------------- [P]Edits a selected note
deleteNotes TITLE ------------------------------------------- [P]Deletes a selected note
undo TYPE -------------------------------- [P]Undoes the last edit/deleted task or notes
display KEYWORD ---------------------------- [P]Displays either weekly or daily schedule
freeTime ------------------------------- Tells you your longest block of free time today
sleepTime ------------------------------------ Tells you how much time you have to sleep
exit ------------------------------------------------------ Closes the LifEasier program
****************************************************************************************

For more detailed information, please visit the online user guide at:
https://ay2021s1-cs2113t-w13-4.github.io/tp/UserGuide
========================================================================================
````

_Figure 3.1-1: An example of using the help command_

<div style="page-break-after: always;"></div>

### 3.2 Adding a Lesson: `addLesson`

Adds a `Lesson` to your schedule. Use this command to add your `Lesson` to your schedule.

#### ![Notes](images/UserGuide/post-it.png) Notes on addLesson Command:

* The program will not warn you if there are any clashes in timing with other Tasks. 
* If you indicate that a Lesson ends at midnight (24:00), the end time will be automatically converted to 23:59.

**Format:** `addLesson /code MODULE /date DATE /from START /to END /repeats TIMES`

#### ![Notes](images/UserGuide/post-it.png) Notes on addLesson Command Format:

* Adds a `Lesson` coded `MODULE`, that runs from `START` to `END`, and repeats weekly for `TIMES`.
* Parameters `START`, `END` must be logical. The `END` time must not be before the `START` time. 
* This command accepts **partial commands**. E.g `addLesson /code CS2113 /to 18:00` is a valid command.
* The program will prompt you for the remaining missing parameters if you input a partial command.
* For lessons that end at **midnight**, please use `24:00` as the command does not accept `00:00`. 

#### Example:

An example of how to use the addLesson command is shown in Figure 3.2-1.
```
addLesson /code CS2101 /date 22-11-20 /from 14:00 /to 16:00 /repeats 30

===============================================================================================================
Done! I've added
"Lesson: CS2101 (22 Nov 2020, 14:00 to 22 Nov 2020, 16:00), repeats weekly 30 times" 
to your schedule!
===============================================================================================================
```
_Figure 3.2-1: An example of using the addLesson command_

<div style="page-break-after: always;"></div>

### 3.3 Adding an Event: `addEvent`

Adds an `Event` to your schedule. Use this command to add your `Event` to your schedule.

#### ![Notes](images/UserGuide/post-it.png) Notes on addEvent Command:

* The program will not warn you if there are any clashes in timing with other Tasks.
* If you indicate that an Event ends at midnight (24:00), the end time will be automatically converted to 23:59.

**Format:** `addEvent NAME /date DATE /from START /to END /repeats TIMES`

#### ![Notes](images/UserGuide/post-it.png) Notes on addEvent Command Format:

* Adds an `Event` called `NAME`, that runs from `START` to `END`, and repeats weekly for `TIMES`.
* Parameters `START`, `END` must be logical. The `END` time must not be before the `START` time. 
* This command accepts **partial commands**. E.g `addEvent Concert /date 05-11-20` is a valid command.
* The program will prompt you for the remaining missing parameters if you input a partial command.
* For events that end at **midnight**, please use `24:00` as the command does not accept `00:00`. 

#### Example:

An example of how to use the addEvent command is shown in Figure 3.3-1.
```
addEvent Concert /date 13-07-21 /from 17:00 /to 21:00 /repeats 0

===============================================================================================================
Done! I've added
"Event: Concert (13 Jul 2021, 17:00 to 13 Jul 2021, 21:00), repeats weekly 0 times" 
to your schedule!
===============================================================================================================
```
_Figure 3.3-1: An example of using the addEvent command_

<div style="page-break-after: always;"></div>

### 3.4 Adding a Deadline: `addDeadline`

Adds a `Deadline` to your schedule. Use this command to add your `Deadline` to your schedule.

#### ![Notes](images/UserGuide/post-it.png) Notes on addDeadline Command:

* The program will not warn you if there are any clashes in timing with other Tasks.

**Format:** `addDeadline NAME /by DATETIME /repeats TIMES`

#### ![Notes](images/UserGuide/post-it.png) Notes on addEvent Command Format:

* Adds a `Deadline` called `NAME`, that has to be completed by `DATETIME`, and repeats weekly for `TIMES`.
* `DATETIME` has the format of **DD-MM-YY HH:MM**, where the time is in 24-hour clock format. _E.g 7:30pm should be input as 19:30._ 
* This command accepts **partial commands**. E.g `addDeadline Return books` is a valid command.
* The program will prompt you for the remaining missing parameters if you input a partial command.

#### Example:

An example of how to use the addDeadline command is shown in Figure 3.4-1.
```
addDeadline Return books /by 31-12-20 23:59 /repeats 0

===============================================================================================================
Done! I've added
"Deadline: Return books by (31 Dec 2020, 23:59), repeats weekly 0 times" 
to your schedule!
===============================================================================================================
```
_Figure 3.4-1: An example of using the addDeadline command_

<div style="page-break-after: always;"></div>

### 3.5 Editing a Lesson: `editLesson`

Edits a `Lesson` in your schedule. Use this command to fix mistakes like typos in the lessons you have already added.

#### ![Notes](images/UserGuide/post-it.png) Notes on editLesson Command:

* The program will not warn you if there are any clashes in timing with other Tasks. 
* If you indicate that a Lesson ends at midnight (24:00), the end time will be automatically converted to 23:59.

**Format:** `editLesson [MODULE]`

#### ![Notes](images/UserGuide/post-it.png) Notes on editLesson Command Format:

* If `MODULE` is provided, all lessons that contain the `MODULE` will be printed.
* The program will prompt you to choose a lesson to be edited.
* The program will prompt you to choose to edit the `MODULE` or the `START/END` time. 
* If you choose to edit time, System will prompt to input new `TIME` in the format of 
“`/date DATE /from START /to END`”
* For lessons that end at **midnight**, please use `24:00` as the command does not accept `00:00`. 

<div style="page-break-after: always;"></div>

#### Example:

An example of how to use the editLesson command is shown in Figure 3.5-1.
```
editLesson CS2101

---------------------------------------------------------------------------------------------------------------
Here are all your matching lessons:
1. Lesson: CS2101 (22 Nov 2020, 14:00 to 22 Nov 2020, 16:00), repeats weekly 30 times

---------------------------------------------------------------------------------------------------------------
Please select the lesson you want to edit:
1

---------------------------------------------------------------------------------------------------------------
Please select the parameter you want to edit:
1. Module Code
2. Time
2

---------------------------------------------------------------------------------------------------------------
Please input your new time in this format: /date DATE /from START /to END
/date 23-11-20 /from 14:00 /to 15:45

===============================================================================================================
Your edit has been saved.
===============================================================================================================
```
_Figure 3.5-1: An example of using the editLesson command_

<div style="page-break-after: always;"></div>

### 3.6 Editing an Event: `editEvent`

Edits an event in your schedule. Use this command to fix mistakes like typos in the events you have already added.

#### ![Notes](images/UserGuide/post-it.png) Notes on editEvent Command:

* The program will not warn you if there are any clashes in timing with other Tasks. 
* If you indicate that an Event ends at midnight (24:00), the end time will be automatically converted to 23:59.

**Format:** `editEvent [NAME]`

#### ![Notes](images/UserGuide/post-it.png) Notes on editEvent Command Format:

* If `NAME` is provided, all events that contain the `NAME` will be printed. Else, all events
will be printed.
* The program will prompt you to choose an `Event` to be edited.
* The program will prompt you to choose to edit the `NAME` or the `START/END` time. 
* If you choose to edit time, the program will prompt to input new `TIME` in the format of 
“`/date DATE /from START /to END`”
* For events that end at **midnight**, please use `24:00` as the command does not accept `00:00`. 

<div style="page-break-after: always;"></div>

#### Example:

An example of how to use the editEvent command is shown in Figure 3.6-1.
```
editEvent

---------------------------------------------------------------------------------------------------------------
Here are all your matching events:
1. Event: Housewarming (11 Nov 2020, 11:11 to 12 Dec 2020, 12:12), repeats weekly 1 times
2. Event: Concert (13 Jul 2021, 17:00 to 13 Jul 2021, 21:00), repeats weekly 0 times

---------------------------------------------------------------------------------------------------------------
Please select the event you want to edit:
2

---------------------------------------------------------------------------------------------------------------
Please select the parameter you want to edit:
1. Event Name
2. Time
1

---------------------------------------------------------------------------------------------------------------
Please input your new Event name:
My favourite band's concert

===============================================================================================================
Your edit has been saved.
===============================================================================================================
```
_Figure 3.6-1: An example of using the editEvent command_

<div style="page-break-after: always;"></div>

### 3.7 Editing a Deadline: `editDeadline`

Edits a `Deadline` in your schedule. Use this command to fix mistakes like typos in the deadlines you have already added.

#### ![Notes](images/UserGuide/post-it.png) Notes on editDeadline Command:

* The program will not warn you if there are any clashes in timing with other Tasks. 

**Format:** `editDeadline [NAME]`

#### ![Notes](images/UserGuide/post-it.png) Notes on editDeadline Command Format:

* If `NAME` is provided, all deadlines that contain the `NAME` will be printed. Else, all deadlines
will be printed.
* The program will prompt you to choose an `Deadline` to be edited.
* The program will prompt you to choose to edit the `NAME` or the `BY` time. 
* If you choose to edit time, the program will prompt to input new `BY` time in the format of 
“`/by DATETIME`”.

<div style="page-break-after: always;"></div>

#### Example:

An example of how to use the editDeadline command is shown in Figure 3.7-1.
```
editDeadline

---------------------------------------------------------------------------------------------------------------
Here are all your matching deadlines:
1. Deadline: Submit report by (19 Nov 2020, 14:00), repeats weekly 0 times
2. Deadline: Return books by (31 Dec 2020, 23:59), repeats weekly 0 times

---------------------------------------------------------------------------------------------------------------
Please select the deadline you want to edit:
2

---------------------------------------------------------------------------------------------------------------
Please select the parameter you want to edit:
1. Deadline Name
2. Time
2

---------------------------------------------------------------------------------------------------------------
Please input your new time in this format: /by DATETIME
/by 24-12-20 23:59

===============================================================================================================
Your edit has been saved.
===============================================================================================================
```
_Figure 3.7-1: An example of using the editDeadline command_

<div style="page-break-after: always;"></div>

### 3.8 Deleting a Task: `deleteTask`

Deletes a `Task` from your schedule. Use this command to delete any lessons you no 
longer need to take note of.

#### ![Notes](images/UserGuide/post-it.png) Notes on deleteTask command:

* Tasks refer to lessons, deadlines and events.

**Format:** `deleteTask /type TYPE [/name NAME]`

#### ![Notes](images/UserGuide/post-it.png) Notes on deleteTask Command Format:

* If `NAME` is provided, all tasks that match the type and contain the `NAME` will be printed. 
Else, all `Task` that match the type will be printed.
* The program will prompt you to choose a `Task` to be deleted.

#### Example:

An example of how to use the deleteTask command is shown in Figure 3.8-1.
```
deleteTask /type deadline /name Submit report

---------------------------------------------------------------------------------------------------------------
Here are all your matching deadlines:
1. Deadline: Submit report by (19 Nov 2020, 14:00), repeats weekly 0 times
2. Deadline: Return books by (31 Dec 2020, 23:59), repeats weekly 0 times

---------------------------------------------------------------------------------------------------------------
Please select the deadline you want to delete:
1

===============================================================================================================
The task you selected has been deleted.
===============================================================================================================
```
_Figure 3.8-1: An example of using the deleteTask command_

<div style="page-break-after: always;"></div>

### 3.9 Undoing an Edit or Deletion:  `undo`

Undoes the most recent edits or deletions made on tasks or notes.

#### ![Notes](images/UserGuide/post-it.png) Notes on undo Command:

* Tasks refer to lessons, deadlines and events.
* Once a task/note is deleted, edits made prior to the deletion cannot be undone. For example, if a particular object goes through 
_edit1 -> edit2 -> delete1 -> edit3_, you will only be able to undo _edit3_ and then _delete1_.
* The history of any edits and deletions are only available for the current session. Once the program is closed, all 
history is discarded and you will not be able to undo those changes the next time you run the application.

**Format:** `undo TYPE`

#### ![Notes](images/UserGuide/post-it.png) Notes on undo Command Format:

* The `TYPE` can either be `task` or `note`.
* If not specified, the program will prompt you to enter `task` or `note`.

<div style="page-break-after: always;"></div>

#### Example:

An example of how to use the undo command is shown in Figure 3.9-1.

```
undo

---------------------------------------------------------------------------------------------------------------
To undo a change in tasks, please enter: task
To undo a change in notes, please enter: note
task

===============================================================================================================
This deleted task has been successfully restored!
Deadline: Submit report by (19 Nov 2020, 14:00), repeats weekly 0 times
===============================================================================================================

undo note

===============================================================================================================
This note has been reverted back to its previous version!
Title: We love cats!

Yay for cats!

===============================================================================================================
```

_Figure 3.9-1: An example of using the undo command_

<div style="page-break-after: always;"></div>

### 3.10 Displaying Schedule: `display`

Displays your current schedule. Use this command to view what your schedule is like for today, tomorrow or for the 
whole week.

**Format:** `display KEYWORD`

#### ![Notes](images/UserGuide/post-it.png) Notes on display Command Format:

* The `KEYWORD` can either be `today`, `tomorrow` or `week`.
* If not specified, the program will prompt you to enter `today`, `tomorrow` or `week`.
* The `display week` command displays the schedule of the upcoming week, in 1 hour intervals. 
* The entire row with all tasks that fall in the current hour will be coloured in cyan for your ease of reference. 

#### Examples:

`display today` displays the schedule for today. An example of how to use the display command is shown below in Figure 3.10-1.

```
display

---------------------------------------------------------------------------------------------------------------
To see your schedule, please enter: week/today/tomorrow:
today

===============================================================================================================
Here is your schedule for today:
13:00-14:00  CS2113T
14:00-17:00  CG2028
```

_Figure 3.10-1: An example of using the display command to view your daily schedule_

<div style="page-break-after: always;"></div>

`display week` displays the schedule of the upcoming 7 days, including the current day. Another  example of how to use the edit lesson command is shown below in Figure 3.10-2.

```
display week

==================================================================================
NOTE: The row corresponding to the current hour is coloured for easy reference!
+-----------+---------+---------+---------+---------+---------+---------+---------+
|TIME       |WEDNESDAY|THURSDAY |FRIDAY   |SATURDAY |SUNDAY   |MONDAY   |TUESDAY  |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|08:00-09:00|         |         |         |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|09:00-10:00|         |         |         |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|10:00-11:00|         | CG1111  |         |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|11:00-12:00|         | CG1111  |         |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|12:00-13:00|         |         | ST2334  |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|13:00-14:00| CS2113T |         | ST2334  |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|14:00-15:00|         | CS2101  |         |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|15:00-16:00|         | CS2101  | CS2113T |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|16:00-17:00|         |         | CS2113T |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
|17:00-18:00|         |         |         |         |         |         |         |
+-----------+---------+---------+---------+---------+---------+---------+---------+
Here are your upcoming deadlines this week:
1. Deadline: ABC Project by (3 Nov 2020, 14:00), repeats weekly 0 times
2. Deadline: weekly XYZ quiz by (5 Nov 2020, 13:00), repeats weekly 3 times
==================================================================================
```

_Figure 3.10-2: An example of using the display week command to view your weekly schedule_

<div style="page-break-after: always;"></div>

### 3.11 Viewing Available Free Time: `freeTime`

Displays your longest block of free time for that day based on the schedule.
Use this command to find out when is a good time to schedule something.

#### ![Notes](images/UserGuide/post-it.png) Notes on freeTime Command:

- The program only searches for free time between 7:00 and 24:00. This is to promote a healthy sleep cycle.

**Format:** `freeTime`

#### Example:

An example of how to use the freeTime command is shown in Figure 3.11-1.

```
freeTime

===============================================================================================================
You have 10 hours of free time between 14:00 and 24:00!
You can try scheduling something in this time!
===============================================================================================================
```

_Figure 3.11-1: An example of using the freeTime command._

<div style="page-break-after: always;"></div>

### 3.12 Viewing Available Sleep Time: `sleepTime`

Displays how much time you have available to sleep based on your schedule for that day and the day after.
Use this command to find out if you can have a good rest after a long day.

#### ![Notes](images/UserGuide/post-it.png) Notes on sleepTime Command:

* The program recommends 8 hours of sleep a day. Anything more, and the extra duration will not be displayed.
* The program will also count the hour before your first activity in the day as busy,
to give you time to wake up and get ready. E.g. if your first activity is at 9:00, 
the program will tell you that you have nothing on only until 8:00.

**Format:** `sleepTime`

#### Example:

An example of how to use the sleepTime command is shown in Figure 3.12-1.

```
sleepTime

===============================================================================================================
You have nothing on from 14:00 today to 8:00 tomorrow!
You can sleep for the recommended 8 hours or longer!
===============================================================================================================
```

_Figure 3.12-1: An example of using sleepTime command_

<div style="page-break-after: always;"></div>

### 3.13 Adding a New Note: `addNotes`

Adds and stores a note with a title and description. Use this command to take notes from your classes or events.

**Format:** `addNotes [TITLE]`

#### ![Notes](images/UserGuide/post-it.png) Notes on addNotes Command Format:

* Adds and stores a note tagged with `TITLE`.
* If `TITLE` is not provided, the program will prompt you for title.
* The word limit of title or description follows the maximum length of input allowed in Command Prompt.

#### Example:

An example of how to use the addNotes command is shown in Figure 3.13-1.

```
addNotes Cats are the best!

---------------------------------------------------------------------------------------------------------------
Alright! Please fill in your notes:
Cats are the cutest in the world :D

===============================================================================================================
Ok! I've taken note of this note!
===============================================================================================================
```

_Figure 3.13-1: An example of using the addNotes command_

<div style="page-break-after: always;"></div>

### 3.14 Showing Notes: `showNotes`

Displays a note/list of notes. Use this command to view the notes you have taken before.

**Format:** `showNotes [TITLE]`

#### ![Notes](images/UserGuide/post-it.png) Notes on showNotes Command Format:

* If `TITLE` is specified, the specific note is displayed. If not, a numbered list of all notes 
will be displayed.
* `TITLE` can be an incomplete title. If there is one match, that note will be shown.
* If multiple notes with the same `TITLE` are found, all note titles containing the input will be 
displayed in a list. You would then have to select the note you want to view. 

#### Example:

An example of how to use the showNotes command is shown in Figure 3.14-1.

```
showNotes Cats

===============================================================================================================
Here is your note:
Title: Cats are the best!

Cats are the cutest in the world :D

===============================================================================================================
```

_Figure 3.14-1: An example of using the showNotes command_

<div style="page-break-after: always;"></div>

### 3.15 Deleting a Note: `deleteNotes`

Deletes a note from the list. Use this command to remove the notes you no longer need.

**Format:** `deleteNotes [TITLE]` 

#### ![Notes](images/UserGuide/post-it.png) Notes on deleteNotes Command Format:

* If `TITLE` is specified, the specific note is displayed and confirmation of delete will be prompted. 
If no `TITLE` is inputted, a numbered list of all notes will be displayed.
* `TITLE` can be a incomplete title. If there is one match, that note will be shown.
* If multiple notes with the same `TITLE` are found, all note titles containing the input will be 
displayed in a list for selection.
* Entering `Y` would delete the note from the list. Entering `N` would exit the command without deletion. 

#### Example:
An example of how to use the deleteNotes command is shown in Figure 3.15-1.

```
deleteNotes

---------------------------------------------------------------------------------------------------------------
Please select the notes you want to delete:
1. cats!
2. alphabet
3. Cats are the best!
1

---------------------------------------------------------------------------------------------------------------
Title: cats!

yay for cats!


---------------------------------------------------------------------------------------------------------------
Is this the note you want to delete? (Y/N)
Y

===============================================================================================================
OK! Note deleted!
===============================================================================================================
```

_Figure 3.15-1: An example of using the deleteNotes command_

<div style="page-break-after: always;"></div>

### 3.16 Editing a Note: `editNotes`

Edits a note from the list. Use this command to make changes to notes you have taken before.

**Format:** `editNotes [TITLE]` 

#### ![Notes](images/UserGuide/post-it.png) Notes on editNotes Command Format:

* If `TITLE` is specified, the specific note is displayed and confirmation of edit will be prompted. 
If no `TITLE` is inputted, a numbered list of all notes will be displayed.
* `TITLE` can be a incomplete title. If there is one match, only that note will be shown.
* If multiple notes with the same `TITLE` are found, all note titles containing the input will be 
displayed in a list for selection.
* Entering `T` would show the current title and prompt for a new title. Entering `D` would 
show the current description and prompt for a new description.
* The word limit of title or description follows the maximum length of input allowed in your Command Prompt.

#### Example:

An example of how to use the editNotes command is shown in Figure 3.16-1.

```
editNotes Cats
Title: Cats are the best!

Cats are the cutest in the world :D

===============================================================================================================
Do you want to change the title or description? (Enter T/D)
D

---------------------------------------------------------------------------------------------------------------
Current Description: 
Cats are the cutest in the world :D

---------------------------------------------------------------------------------------------------------------
Please input the description you want to change to:
I really love cats!

===============================================================================================================
OK! Your description is now: "I really love cats!"
===============================================================================================================
```

_Figure 3.16-1: An example of using the editNotes command_

<div style="page-break-after: always;"></div>

### 3.17 Archiving Notes: `archive`

Archives all existing notes. Use this command to store all your notes in a separate save file. These notes will no 
longer be displayed anywhere.

**Format:** `archive`

#### ![Notes](images/UserGuide/post-it.png) Notes on archive Command Format:

* **All** current notes existing in **LifEasier** will be archived into the `Archives` folder found inside the 
`LifEasierSaves` save folder.
* Archive files are automatically named in the format of **DD-MM-YY HH:MM.txt**, based on the time you run the command.
* Upon archiving, all saved notes will be **removed** and placed in the archive instead - Using the `showNotes` command 
immediately after `archive` will result in **no notes** being shown.
* There is no way to undo this action, so use the `archive` command with care.

#### Example:

An example of how to use the archive command is shown in Figure 3.17-1.

````
archive

===============================================================================================================
Starting archiving...
Archiving successful!
Note: All current notes have been archived and will no longer be read by the program
===============================================================================================================
````

_Figure 3.17-1: An example of using the archive command_

##### Future implementation of `archive`: Archiving individual notes _(Coming in v2.2)_

The current implementation of `archive` only allows for archiving of **all** notes currently present in the program. In a 
future implementation, the ability for you to specifically choose which notes to be archived will be added.

<div style="page-break-after: always;"></div>

### 3.18 Exiting: `exit`

Exits the programme. Use this command when you are done using LifEasier.

**Format:** `exit`

#### Example:

An example of how to use the exit command is shown in Figure 3.18-1.

````
exit

===============================================================================================================
Goodbye, hope to see you again soon!
===============================================================================================================
````

_Figure 3.18-1: An example of using the exit command_

<div style="page-break-after: always;"></div>

## 4.0 Other Features

This section covers some of the features which do not rely on your input to be executed. Rather, they happen in the 
background to ensure the program runs smoothly.

### 4.1 Storing Data

By default, **LifEasier** creates a save folder named `LifEasierSaves` in the same folder `LifEasier.jar` is run. 
**LifEasier** data is saved automatically to the hard disk when a new `Event`, `Deadline`, `Lesson` or `Note` is **added**, 
**deleted** or **edited**. Data is stored in text files, in plaintext. This allows you to edit your data directly through 
the save files if necessary.

In the event of **corrupted data** arising from either system errors or incorrect formats from you while editing the save file,
**LifEasier** will give you a general warning during startup, but will continue to load remaining uncorrupted data. The corrupted data will be removed immediately from the save file as well.
**LifEasier** currently checks the format of dates and times, if start times are after end times, module codes, and other formatting errors in the save file.
For invalid module codes, **LifEasier** will continue to load in the lesson instead of discarding it. This is to allow you to enter more information manually into the module code 
field through the save file directly if needed.

If a successful `archive` command was executed, a folder called `Archives` will be created in the `LifEasierSaves` folder 
where you can access your archived files. Archived notes will not show up in **LifEasier** anymore.

### 4.2 Recurring Tasks and Auto Deletion

**LifEasier** automatically updates the dates of recurring tasks and deletes old tasks.
It will load your save files and update your tasks automatically every time it starts up, and every time you add a `Task` to your schedule.
Here are some examples of what might happen if you start up **LifEasier** on 24th October:

1. If you had a lesson that last occurred on 22nd October, and it is set to repeat 3 more times, it will be **updated** to occur again on 29th October, and **updated** to repeat 2 more times.
2. If you had an event that last occurred on 21st October, and it is set to repeat 0 more times, it will be **deleted** from your schedule.

<div style="page-break-after: always;"></div>

## 5.0 FAQ

**The following FAQ section answers some common questions that you may have about the LifEasier application.**

**Q1: Can I use my LifEasier saves on another computer?**

**A:** Yes you can. You can transfer your files from one computer to another, and place them in a folder called `LifEasierSaves`. Then, run `LifEasier.jar` from the same folder as `LifEasierSaves`. Your saves should be loaded into **LifEasier**. As long as the `LifEasierSaves` folder is in the same folder as where the `LifEasier.jar` is being run, the program will read your saved information as per normal.

**Q2: Can I edit the information in the save files directly?**

**A:** Yes, it is possible but it is not recommended to do so. Directly modifying the save files may result in incorrectly formatted data to be passed into the **LifEasier** program on the next launch, resulting in missing data as the program automatically deletes improperly formatted/corrupted data.

**Q3: Why is my event/lesson not showing up/getting deleted after I edited the save file?**

**A:** You may have set the end time for your event/lesson as `00:00` or `24:00` in the save file, which **LifEasier** does not support currently. As such, please enter `23:59` as the time if you want to modify the task to end at midnight directly from the save file.

## 6.0 Command Summary

The below table summarises the commands available to the user, and how they can be used. Examples are also provided 
for reference.

Action | Format | Example
--------|-----------------|----------------------------------------------------------------------------------
addLesson| `addLesson /code MODULE /date DATE /from START /to END /repeats TIMES` | `addLesson /code cg1111 /date 04-10-20 /from 09:00 /to 12:00 /repeats 10`
addEvent| `addEvent EVENT_NAME /date DATE /from START /to END /repeats TIMES` | `addEvent Party /date 04-10-20 /from 09:00 /to 12:00 /repeats 0`
addDeadline| `addDeadline DEADLINE_NAME /by DATETIME /repeats TIMES` | `addDeadline User Guide /by 04-10-20 09:00 /repeats 0`
editLesson| `editLesson [MODULE]` | `editLesson CS2101`
editEvent| `editEvent [NAME]` | `editEvent BlackPink Concert`
editDeadline| `editDeadline [NAME]` | `editDeadline Finish Work`
deleteTask| `deleteTask /type TYPE [/name NAME]` | `deleteTask /type event`
addNotes| `addNotes [TITLE]` | `addNotes CS2101`
showNotes| `showNotes [TITLE]` | `showNotes CS2113T`
deleteNotes| `deleteNotes [TITLE]` | `deleteNotes CS1231`
editNotes| `editNotes [TITLE]` | `editNotes CG2271`
undo| `undo TYPE` | `undo note` or `undo task`
archive| `archive` | `archive`
display| `display KEYWORD` | `display today`
freeTime| `freeTime` | `freeTime`
sleepTime| `sleepTime` | `sleepTime`
help| `help` | `help`
exit| `exit` | `exit`
