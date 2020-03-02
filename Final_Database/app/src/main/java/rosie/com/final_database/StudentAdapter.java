package rosie.com.final_database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private List<StudentDTO> studentDTOList;

    public void setStudentDTOList(List<StudentDTO> studentDTOList) {
        this.studentDTOList = studentDTOList;
    }

    @Override
    public int getCount() {
        return studentDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return studentDTOList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);
        }
        StudentDTO dto = studentDTOList.get(position);
        TextView txtID = convertView.findViewById(R.id.txtID);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtMark = convertView.findViewById(R.id.txtMark);
        txtID.setText(dto.getId());
        txtName.setText(dto.getName());
        txtMark.setText(dto.getMark() + "");
        return convertView;
    }

}
