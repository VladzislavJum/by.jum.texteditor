package by.jum.texteditor.listener;

import by.jum.texteditor.file.XMLFile;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Vlad on 13.04.2015.
 */
public class FileSaveListener implements ActionListener {
    private JFileChooser jFileChooser;
    private JTabbedPane tabbedPane;
    private JFrame frame;

    public FileSaveListener(JTabbedPane tabbedPane, JFrame frame) {
        this.tabbedPane = tabbedPane;
        this.frame = frame;
        jFileChooser = new JFileChooser();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
                try {
                    new XMLFile(jFileChooser.getSelectedFile().getPath(), tabbedPane, frame).writeFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (TransformerException e1) {
                    e1.printStackTrace();
                } catch (ParserConfigurationException e1) {
                    e1.printStackTrace();
                }
         }
    }
}
