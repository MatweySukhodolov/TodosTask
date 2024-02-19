package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    @Test
    public void shouldAddOneSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyArrayTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        Task[] expected = {};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TheTaskSearchMethodIsATest() {
        Task task = new Task(6);
        SimpleTask simpleTask = new SimpleTask(555, "купить молоко и принести домой");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(555, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выпить молоко",
                "Помыть посуду",
                "Открыть холодильник"
        );

        Todos todos = new Todos();

        todos.add(task);
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, false, true};
        boolean[] actual = new boolean[4];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("молоко");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);

        Assertions.assertTrue(task1.equals(task1));

        Assertions.assertTrue(task1.equals(task2));

        Assertions.assertFalse(task1.equals(null));

        Assertions.assertFalse(task1.equals("task"));

        Task task3 = new Task(2);

        Assertions.assertFalse(task1.equals(task3));
    }


    @Test
    public void shouldFindTwoTasks() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
}

    @Test
    public void shouldFindNullTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Дверь");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneSimpleTaskMeetingTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Работать без обеда");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения после обеда",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("обеда");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneEpicMeetingSimpleTaskTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Работать без обеда");

        String[] subtasks = {"Молоко", "Яйца", "обеда"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения после обеда",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] expected = {simpleTask, meeting, epic};
        Task[] actual = todos.search("обеда");
        Assertions.assertArrayEquals(expected, actual);
    }


}


