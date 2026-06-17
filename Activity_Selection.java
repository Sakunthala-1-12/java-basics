import java.util.*;

public class Activity_Selection{
    static class Activity{
        int start;
        int end;
        Activity(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static int maxActivities(int[] start,int[] end){
        int n = start.length;
        Activity[] activities = new Activity[n];
        for(int i=0; i<n; i++){
            activities[i] = new Activity(start[i],end[i]);
        }

        Arrays.sort(activities,(a,b) -> a.end - b.end);
        int count = 1   ;
        int lastEndTime= activities[0].end;
        for(int i=1;i<n;i++){
            if(activities[i].start>= lastEndTime){
                count++;
                lastEndTime = activities[i].end;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9 };
        int result = maxActivities(start, end);
        System.out.println("Maximum number of Activities:"+result);

    }
}
