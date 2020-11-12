# Project PortFolio Page: dojh111

## Overview
**LifEasier** helps Computer Engineering (CEG) students to manage their classes, social events, deadlines and school notes 
through the Command Line Interface (CLI).
The following describes my personal contributions to the project, and what specific features and enhancements I 
implemented. It also contains a record of the documentation I helped to contribute.

### Summary of Contributions
The following sections summarise my contributions for **LifEasier**.

#### Code Contributed
In total, I have contributed over 2200 total lines of code, with around 1500 lines of **functional code**, and the rest 
being split between **test code** and **documentation**. To view my code contributions, please visit the link [here](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=dojh111&tabRepo=AY2021S1-CS2113T-W13-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other).

#### Enhancements Implemented
For enhancements, I implemented the following features:
* Handling of **LifEasier** saves and storage
* Note Archiving
* Worked on undo command with another team member, where we discussed implementation and algorithms to use
* Initial skeleton code for team to start working off (Overhauled in later versions)

While a basic saving and storage handling system is rather easy to implement, due to the functionality of **LifEasier** 
different types of data had to be stored and read in separate ways, leading to a more complicated file reading and writing system.
On top of that, as users are able to edit the save files directly, a robust system to detect and handle corrupted/wrongly formatted 
save files had to be implemented.

#### Contributions to Documentation (UG)
For the user guide, I contributed mainly to the features I implemented, which are sections [3.17 Archiving Notes](https://ay2021s1-cs2113t-w13-4.github.io/tp/UserGuide#317-archiving-notes-archive),
and [4.1 Storing Data](https://ay2021s1-cs2113t-w13-4.github.io/tp/UserGuide#41-storing-data). Apart from that, I also contributed to the 
Section **2.0 Quick Start**, **5.0 FAQ** and the **6.0 Command Summary**, which can be found from the user guide [here](https://ay2021s1-cs2113t-w13-4.github.io/tp/UserGuide).

#### Contributions to the DG
For the developer guide, I contributed the following content and UML diagrams:
* Architecture diagram in [3.1 Architecture](https://ay2021s1-cs2113t-w13-4.github.io/tp/DeveloperGuide#31-architecture).
* Content related to storage and archiving in section [4.8 Storing and Archiving Notes](https://ay2021s1-cs2113t-w13-4.github.io/tp/DeveloperGuide#48-storing-and-archiving-notes).
* [Appendix A: Guidelines on Manual Testing](https://ay2021s1-cs2113t-w13-4.github.io/tp/DeveloperGuide#appendix-a-guidelines-on-manual-testing). 

The developer guide can be found [here](https://ay2021s1-cs2113t-w13-4.github.io/tp/DeveloperGuide).

#### Contributions to Team-Based Tasks
Overall, I generally helped with maintaining some of the issues on the issue tracker through `v2.0` and `v2.1`, along with managing
the release of `v2.0`. I also helped introduce the `Jansi` third-party library into the project, allowing coloured windows terminal outputs.

#### Review/Mentoring Contributions
Throughout the development process, I helped review the pull requests of the other members, as well as helping them solve 
some issues that they had faced during development of features.

#### Contributions beyond the Project Team
Outside the project team, I kept myself constantly updated on the forum posts, to keep updated on any potential issues posted that 
may affect our project team, as well as potential third party libraries that we could adopt. Apart from that, I had a discussion with 
another developer from another team on the enabling of color in the windows command terminal.
