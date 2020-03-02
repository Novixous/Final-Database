package rosie.com.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListStudentActivity extends AppCompatActivity {
    private StudentAdapter adapter;
    private ListView listStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        Intent intent = this.getIntent();
        List<StudentDTO> result = (List<StudentDTO>) intent.getSerializableExtra("INFO");
        listStudent = findViewById(R.id.listStudent);
        adapter = new StudentAdapter();
        adapter.setStudentDTOList(result);
        listStudent.setAdapter(adapter);
        listStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudentDTO dto = (StudentDTO) listStudent.getItemAtPosition(position);
                Intent intenDetail = new Intent(ListStudentActivity.this, StudentDetailActivity.class);
                intenDetail.putExtra("DTO", dto);
                startActivity(intenDetail);
            }
        });
    }
}
