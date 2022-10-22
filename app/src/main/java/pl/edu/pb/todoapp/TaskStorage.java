package pl.edu.pb.todoapp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();

    private final List<Task> tasks;

    public static TaskStorage getInstance(){ return taskStorage;}

    private TaskStorage(){
        tasks = new ArrayList<>();
        for(int i = 1; i < 201; i++){
            Task task = new Task();
            task.setName("Pilne zadanie numer " + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    public Task get(int indeks){
        return tasks.get(indeks);
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public void set(int indeks, Task zadanie){
        Array.set(tasks, indeks, zadanie);
    }

    public int length(){
        return tasks.size();
    }
}
