package rosie.com.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        TextView txtId = findViewById(R.id.txtID);
        TextView txtName = findViewById(R.id.txtName);
        TextView txtMark = findViewById(R.id.txtMark);
        Intent intent = this.getIntent();
        StudentDTO studentDTO = (StudentDTO) intent.getSerializableExtra("DTO");
        txtId.setText("ID: " + studentDTO.getId());
        txtName.setText("Name: " + studentDTO.getName());
        txtMark.setText("Mark: " + studentDTO.getMark());
    }
}
