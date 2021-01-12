package vo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ExcelExporter {
	public ExcelExporter() { }
    public void exportTable(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        BufferedWriter out =new BufferedWriter( new FileWriter(file));
        for(int i=0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i));
            out.write("\t");
        }
        out.newLine();
        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i,j).toString());
                out.write("\t");
            }
            out.newLine(); 
        }
        out.close();
        //System.out.println("write out to: " + file);
    }
}
