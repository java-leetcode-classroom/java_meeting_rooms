import java.util.Collections;
import java.util.List;

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class Solution {
  /**
   * @param intervals: an array of meeting time intervals
   * @return: if a person could attend all meetings
   */
  public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals.isEmpty()) {
      return true;
    }
    Collections.sort(intervals, (a, b) -> (a.start - b.start));
    int overlapEnd = intervals.get(0).end;
    int nIntervals = intervals.size();
    for (int pos = 1; pos < nIntervals; pos++ ) {
      Interval cur = intervals.get(pos);
      if (overlapEnd > cur.start) {
        return false;
      } else  {
        overlapEnd = cur.end;
      }
    }
    return true;
  }
}
