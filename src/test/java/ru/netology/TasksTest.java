package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testingTask() {

    }


    @Test
    public void simpleTaskTestTrue() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void simpleTaskTestFalse() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean actual = simpleTask.matches("Зайти");

        Assertions.assertFalse(actual);
    }

    @Test
    public void epicTestTrue() {
        String[] subtasks = {"Тунец", "Лосось", "Треска"};
        Epic epic = new Epic(5, subtasks);

        boolean actual = epic.matches("Треска");

        Assertions.assertTrue(actual);
    }

    @Test
    public void epicTestFalse() {
        String[] subtasks = {"Тунец", "Лосось", "Треска"};
        Epic epic = new Epic(5, subtasks);

        boolean actual = epic.matches("Осетр");

        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingTestFalse() {
        Meeting meeting = new Meeting(
                555,
                "Меню ресторана",
                "Блюда от шефа",
                "по понедельникам с утра"
        );

        boolean actual = meeting.matches("Список");

        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingTestProjectTrue() {
        Meeting meeting = new Meeting(
                555,
                "Меню ресторана",
                "Блюда от шефа",
                "по понедельникам с утра"
        );

        boolean actual = meeting.matches("Блюда");

        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingTestTopicTrue() {
        Meeting meeting = new Meeting(
                555,
                "Меню ресторана",
                "Блюда от шефа",
                "по понедельникам с утра"
        );

        boolean actual = meeting.matches("Меню");

        Assertions.assertTrue(actual);
    }




}
