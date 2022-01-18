import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PS_Interface {


    public void createUI() {

        try {
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            JTable table = new JTable();

            String readLine = null;

            StudentTableModel tableModel = new StudentTableModel();
            File file = new File("PSs.txt");

            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);

            List<PS> studentList = new ArrayList<PS>();
            while((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(" ");

                PS student = new PS();
                student.setGameID(Integer.parseInt(splitData[0]));
                student.setTitle(splitData[1]);
                student.setPrice(Double.parseDouble(splitData[2]));
                student.setDescription(splitData[3]);
                student.setVideo(splitData[4]);
                student.setCover(splitData[5]);
                student.setImage1(splitData[6]);
                student.setCondition(splitData[7]);
                student.setDiscountG(Double.parseDouble(splitData[8]));
                student.setStock(Integer.parseInt(splitData[9]));

                studentList.add(student);
            }

            tableModel.setList(studentList);
            table.setModel(tableModel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.setTitle("File to JTable");
            frame.pack();
            frame.setVisible(true);

        } catch(IOException ex) {}
    }



    class StudentTableModel extends AbstractTableModel {

        private List<PS> list = new ArrayList<PS>();
        private String[] columnNames = {"ID", "Title","Price","De","Vi","Co","Im","Con","Dis","Stock"};

        public void setList(List<PS> list) {
            this.list = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return list.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getGameID();
                case 1:
                    return list.get(rowIndex).getTitle();
                case 2:
                    return list.get(rowIndex).getPrice();
                case 3:
                    return list.get(rowIndex).getDescription();
                case 4:
                    return list.get(rowIndex).getVideo();
                case 5:
                    return list.get(rowIndex).getCover();
                case 6:
                    return list.get(rowIndex).getImage1();
                case 7:
                    return list.get(rowIndex).getCondition();
                case 8:
                    return list.get(rowIndex).getDiscountG();
                case 9:
                    return list.get(rowIndex).getStock();
                default:
                    return null;
            }
        }
    }
}