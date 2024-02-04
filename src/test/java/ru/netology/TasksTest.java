package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testingTask() {

    }


    @Test
    public void simpleTaskTest() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");
        Assertions.assertTrue(simpleTask.matches("Позвонить родителям"));
        Assertions.assertTrue(simpleTask.matches(""));
        Assertions.assertFalse(simpleTask.matches("Уйти в бар"));
    }

    @Test
    public void epicTest() {
        String[] subtasks = {"Отдать ", "Взять", "Выбросить"};
        Epic epic = new Epic(1, subtasks);
        Assertions.assertTrue(epic.matches("Отдать"));
        Assertions.assertFalse(epic.matches("продать"));
        Assertions.assertFalse(epic.matches("Обменять"));
        Assertions.assertTrue(epic.matches(""));
    }
    @Test
    public void meetingTest() {
        Meeting meeting = new Meeting(2, "Название", "Проект", "Время");
        Assertions.assertTrue(meeting.matches("Проект"));
        Assertions.assertTrue(meeting.matches(""));
        Assertions.assertFalse(meeting.matches("Уйти в бар"));

    }

}
