package pl.edu.pb.todoapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class TaskFragment extends Fragment {

    private static final String ARG_TASK_ID = "ARG_TASK_ID";
    private static final String TODO_TAG = "TaskFragment";

    private EditText nameField;
    private Button dateButton;
    private CheckBox doneCheckBox;

    private Task task;

    public static TaskFragment newInstance(UUID taskId) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TASK_ID, taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TODO_TAG,"Wywolano onCreate");
        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        Log.d(TODO_TAG,"taskId to: " + taskId);
        task = TaskStorage.getInstance().getTask(taskId);
        Log.d(TODO_TAG,"task to" + task);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TODO_TAG,"Wywolano onCreateView");

        View view = inflater.inflate(R.layout.fragment_task, container, false);

        nameField = view.findViewById(R.id.task_name);
        dateButton = view.findViewById(R.id.task_date);
        doneCheckBox = view.findViewById(R.id.task_done);
        Log.d(TODO_TAG,"Znaleziono obiekty");

        nameField.setText(task.getName());
        Log.d(TODO_TAG,"Co jest");
        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                task.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dateButton.setText(task.getDate().toString());
        dateButton.setEnabled(false);
        dateButton.setText(task.getDate().toString());

        doneCheckBox.setChecked(task.isDone());
        doneCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> task.setDone(isChecked));

        return view;


    }
}
