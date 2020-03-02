package rosie.com.final_database;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements Serializable {
    public StudentDAO() {

    }

    public List<StudentDTO> loadFromRaw(InputStream is) {
        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        String s = null;
        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((s = br.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public void saveToInternal(FileOutputStream fos, List<StudentDTO> list) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(fos);
            String result = "";
            for (StudentDTO dto : list) {
                result += dto.toString() + "\n";
            }
            osw.write(result);
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<StudentDTO> loadFromInternal(FileInputStream fis) {
        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        String s = null;
        try {
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((s = br.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean saveToExternal(List<StudentDTO> list) {
        boolean check = false;
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        File sdCard = Environment.getExternalStorageDirectory();
        String realPath = sdCard.getAbsolutePath();
        File directory = new File(realPath + "/MyFiles");
        directory.mkdir();
        File file = new File(directory, "mydata.txt");
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            String result = "";
            for (StudentDTO dto : list) {
                result += dto.toString() + "\n";
            }
            osw.write(result);
            osw.flush();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return check;
    }

    public List<StudentDTO> loadFromExternal() {
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        File sdCard = Environment.getExternalStorageDirectory();
        String realPath = sdCard.getAbsolutePath();
        File directory = new File(realPath + "/MyFiles");
        directory.mkdir();
        File file = new File(directory, "mydata.txt");

        FileInputStream fis = null;
        List<StudentDTO> result = new ArrayList<>();
        StudentDTO dto = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        String s = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while ((s = br.readLine()) != null) {
                String[] tmp = s.split("-");
                dto = new StudentDTO(tmp[0], tmp[1], Float.parseFloat(tmp[2]));
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
