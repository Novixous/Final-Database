package rosie.com.final_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentDAO dao = new StudentDAO();
        try {
            FileOutputStream fos = openFileOutput("mydata.txt", MODE_PRIVATE);
            InputStream is = this.getResources().openRawResource(R.raw.data);
            List<StudentDTO> list = dao.loadFromRaw(is);
            dao.saveToInternal(fos, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickToLoadFromRaw(View view) {
        Intent intent = new Intent(this, ListStudentActivity.class);
        StudentDAO studentDAO = new StudentDAO();
        InputStream is = this.getResources().openRawResource(R.raw.data);
        List<StudentDTO> studentDTOS = studentDAO.loadFromRaw(is);
        intent.putExtra("INFO", (Serializable) studentDTOS);
        startActivity(intent);
    }

    public void clickToLoadFromInternal(View view) {
        Intent intent = new Intent(this, ListStudentActivity.class);
        StudentDAO studentDAO = new StudentDAO();
        try {
            FileInputStream fis = openFileInput("mydata.txt");
            List<StudentDTO> studentDTOS = studentDAO.loadFromRaw(fis);
            intent.putExtra("INFO", (Serializable) studentDTOS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }

    public void clickToSaveSDCard(View view) {
        try {
            FileInputStream fis = openFileInput("mydata.txt");
            StudentDAO dao = new StudentDAO();
            List<StudentDTO> result = dao.loadFromInternal(fis);
            if (dao.saveToExternal(result)) {
                Toast.makeText(this, "Saved SD Card successfully", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickToLoadFromSDCard(View view) {
    }
}
