import java.util.*;
public class Sequence {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;  // beginWord counted as step 1

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String word = q.poll();

                if (word.equals(endWord)) return steps;

                char[] arr = word.toCharArray();

                // Try all 26 alphabet changes at each position
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);

                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            q.add(newWord);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String begin = sc.next();
        String end = sc.next();

        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.next());

        System.out.println(ladderLength(begin, end, list));
    }
}


