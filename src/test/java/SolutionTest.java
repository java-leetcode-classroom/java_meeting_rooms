import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();

  @Test
  void canAttendMeetingsExample1() {
    // intervals = [(0,30),(5,10),(15,20)]
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(0, 30));
    list.add(new Interval(5, 10));
    list.add(new Interval(15, 20));
    assertFalse(sol.canAttendMeetings(list));
  }
  @Test
  void canAttendMeetingsExample2() {
    // intervals = [(5,8),(9,15)]
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(5, 8));
    list.add(new Interval(9, 15));
    assertTrue(sol.canAttendMeetings(list));
  }
  @Test
  void canAttendMeetingsExample3() {
    // intervals = []
    assertTrue(sol.canAttendMeetings(List.of()));
  }
}