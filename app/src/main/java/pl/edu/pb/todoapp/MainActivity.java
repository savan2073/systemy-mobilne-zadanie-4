package pl.edu.pb.todoapp;

import androidx.fragment.app.Fragment;

import pl.edu.pb.todoapp.TaskFragment;
import pl.edu.pb.todoapp.TaskListFragment;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID taskId = (UUID) getIntent().getSerializableExtra(TaskListFragment.KEY_EXTRA_TASK_ID);
        return TaskFragment.newInstance(taskId);
    }
}