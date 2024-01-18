import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        // boolean expected = true;

        // Assertions.assertEquals(expected, actual);

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("позвонить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "хлеб"};
        Task epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "хлеб"};
        Task epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMatches() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNotMatches() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNotMatchesTask() {
        Task task = new Task(555);

        boolean expected = false;
        boolean actual = task.matches("хлеб");

        Assertions.assertEquals(expected, actual);
    }

}
