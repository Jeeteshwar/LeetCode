import java.util.*;

class TaskManager {
    static class Task {
        int userId, taskId, priority;
        Task(int u, int t, int p) { userId = u; taskId = t; priority = p; }
    }

    private Map<Integer, Task> taskMap;
    private PriorityQueue<Task> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return b.priority - a.priority;
            return b.taskId - a.taskId;
        });
        for (List<Integer> t : tasks) {
            Task task = new Task(t.get(0), t.get(1), t.get(2));
            taskMap.put(task.taskId, task);
            pq.offer(task);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        pq.offer(updated);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task valid = taskMap.get(top.taskId);
            if (valid == null) continue;
            if (valid.priority != top.priority) continue;
            taskMap.remove(top.taskId);
            return valid.userId;
        }
        return -1;
    }
}
