# java_meeting_rooms

Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`
, determine if a person could attend all meetings

## Examples

**Example1**

```
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation:
(0,30), (5,10) and (0,30),(15,20) will conflict

```

**Example2**

```
Input: intervals = [(5,8),(9,15)]
Output: true
Explanation:
Two times will not conflict

```

## 解析

給定一個 2D 陣列 intervals 

每個 intervals[i] = [$start_i, end_i$] 代表一個時間區間 $start_i$ < values ≤ $end_i$

遇到重疊時間區間則會無法開會

要求寫一個演算法來判斷給定的時間區間是能否開會

如同 [**435. Non-overlapping Intervals**](https://www.notion.so/435-Non-overlapping-Intervals-b07abf8f4f00494c9656b1964e6f0a4b) 

可以發現要判斷重疊條件如下圖

![](https://i.imgur.com/atDxwr6.png)

當 $start_i$ ≤ $start_j$ 時,

$end_j$ > $start_i$ 代表 intervals[i] 與 intervals[j] 有重疊

所以只要先把 intervals 根據 start 做排序

初始化 overlapEnd = intervals[0].end

從 pos 開始 每次比較 overlapEnd > intervals[pos].start

如果是 代表有重疊無法開會 , 回傳 false

如果否 更新 overlapEnd = intervals[pos].end

如果跑到最後都沒有遇到重疊 代表沒重疊，回傳 true 

另外要考慮一個 edge case 就是 傳入 空的開會時間，代表不需要開會 直接回傳 true

時間複雜度是 O(nlogn)

空間複雜度是 O(1)

## 程式碼
```java
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

```
## 困難點

1. 要看出重疊的條件

## Solve Point

- [x]  先把 intervals 根據 start 做排序
- [x]  初始化 overlapEnd = intervals[0].end
- [x]  從 pos 開始 每次比較 overlapEnd > intervals[pos].start
- [x]  如果是 代表有重疊無法開會 , 回傳 false
- [x]  如果否 更新 overlapEnd = intervals[pos].end
- [x]  如果跑到最後都沒有遇到重疊 代表沒重疊，回傳 true