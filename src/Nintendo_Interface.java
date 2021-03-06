import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Nintendo_Interface {


    public void createUI() {

        try {
            JButton buttonBack=new JButton("Back");
            JButton button=new JButton("Search");
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            JTable table = new JTable();

            String readLine = null;

            gTableModel tableModel = new gTableModel();
            File file = new File("Nintendos.txt");

            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);

            List<Nintendo> gList = new ArrayList<Nintendo>();
            while((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(",");

                Nintendo g = new Nintendo();
                g.setGameID(Integer.parseInt(splitData[0]));
                g.setTitle(splitData[1]);
                g.setPrice(Double.parseDouble(splitData[2]));
                g.setDescription(splitData[3]);
                g.setVideo(splitData[4]);
                g.setCover(splitData[5]);
                g.setImage1(splitData[6]);
                g.setCondition(splitData[7]);
                g.setDiscountG(Double.parseDouble(splitData[8]));
                g.setStock(Integer.parseInt(splitData[9]));

                gList.add(g);
            }

            tableModel.setList(gList);
            table.setModel(tableModel);

            frame.setLayout(new BorderLayout());
            tableModel.setList(gList);
            table.setModel(tableModel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(button,BorderLayout.SOUTH);
            frame.add(buttonBack,BorderLayout.BEFORE_FIRST_LINE);
            frame.add(new JScrollPane(table),BorderLayout.CENTER);
            frame.setTitle("File to JTable");
            frame.pack();
            frame.setVisible(true);

        } catch(IOException ex) {}
    }



    class gTableModel extends AbstractTableModel {

        private List<Nintendo> list = new ArrayList<Nintendo>();
        private String[] columnNames = {"ID", "Title","Price","De","Vi","Co","Im","Con","Dis","Stock"};

        public void setList(List<Nintendo> list) {
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