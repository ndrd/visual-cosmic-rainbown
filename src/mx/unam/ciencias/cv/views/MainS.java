package mx.unam.ciencias.cv.views;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mx.unam.ciencias.cv.filters.*;
import mx.unam.ciencias.cv.utils.*;

/**
 *
 * @author socrates
 */
public class MainS extends javax.swing.JFrame {

    /**
     * Creates new form MainS
     */
    public MainS() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        imageOcontainer = new javax.swing.JScrollPane();
        imageScontainer = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuOpen = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        workedImg = new javax.swing.JLabel();
        srcImg = new javax.swing.JLabel();

        engine = Filters.getInstance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        getContentPane().setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(imageScontainer, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageOcontainer, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageOcontainer)
            .addComponent(imageScontainer, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Images", jPanel1);

        jPanel3.setBackground(java.awt.Color.black);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Canvas", jPanel2);

        getContentPane().add(jTabbedPane2);

        jMenu1.setText("File");

        menuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpen.setText("Open...");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openImage(evt);
            }
        });
        jMenu1.add(menuOpen);

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setText("Save..");
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImg(evt);
            }
        });
        jMenu1.add(menuSave);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Image");

        jMenuItem1.setText("Filters");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Training");

        jMenu4.setText("ImageColorTraining");

        jMenuItem3.setText("New Training Set");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Save Current Set");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);
        jMenu4.add(jSeparator2);

        jMenuItem5.setText("Load Training File");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);
        jMenu4.add(jSeparator3);

        jMenuItem6.setText("Search");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenu3.add(jMenu4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        imageOcontainer.setViewportView(workedImg);
        imageScontainer.setViewportView(srcImg);

        pack();
    }// </editor-fold>                        

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        openDir(evt);
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        /* Serialize the trainer */
        serialize(ImageTrainer.getInstance());
    }

    ImageTrainer zombie = null;                                          

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        zombie = deserialize();

    }                                          

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) { 
        ImageTrainer t = ImageTrainer.getInstance();
        BufferedImage response = Filters.colorSelector(engine.getLastImage(),t.getLowerBound(), t.getUpperBound());
        engine.setLastWork(response);
        putImageOnScreen(response, workedImg);
    }

    private boolean openFail = false;

    private void putImageOnScreen(BufferedImage inputImage, javax.swing.JLabel srcImg) {
        srcImg.setIcon(new javax.swing.ImageIcon(inputImage));
        srcImg.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        srcImg.setVerticalAlignment(javax.swing.JLabel.CENTER);
    }

    private void openImage(AWTEvent evt) {
        openImage();
        if(!openFail) {
            putImageOnScreen(engine.getLastImage(), srcImg);
            putImageOnScreen(engine.getLastImage(), workedImg);
        }
    }

    private void saveImg(AWTEvent evt) {
        save();
        
    }

    private ImageTrainer deserialize() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        openFail = false;
        
        FileNameExtensionFilter fExt = new FileNameExtensionFilter(" SER  (*.ser)", 
                                                                    "ser");
        String[] ext = fExt.getExtensions();
        chooser.setFileFilter(fExt);

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            openFail = true;
            return null;
        }
        else if (result == JFileChooser.APPROVE_OPTION) {
            String dir = chooser.getSelectedFile().getPath();
            if (dir == null || dir.equals("")) {
                openFail = true;
                System.out.print("Archivo invalido, saliendo");
                System.exit((0));
            }
            try {
                return (ImageTrainer) Keeper.read(dir);               
            } 
            catch(Exception e) {
                openFail = true;
            }
        }
        return null;
    }


    private void serialize(Object o) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save"); 

        FileNameExtensionFilter fExt = new FileNameExtensionFilter(" SER (*.ser),", 
                                                                         "ser");
        String[] ext = fExt.getExtensions();
        fileChooser.setFileFilter(fExt);
  
         
        int userSelection = fileChooser.showSaveDialog(this);
        try {
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String path = fileToSave.getName();
                Keeper.saving(o,path);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot be saved :(");
        }
    }


    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save"); 

        FileNameExtensionFilter fExt = new FileNameExtensionFilter(" JPEG (*.jpg), PNG  (*.png)", 
                                                                         "jpg", "png");
        String[] ext = fExt.getExtensions();
        fileChooser.setFileFilter(fExt);
  
         
        int userSelection = fileChooser.showSaveDialog(this);
        try {
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                ImageIO.write(engine.getLastWork(), "png", fileToSave);
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot be saved :(");
        }
    }

    private void openDir(AWTEvent evt) {
        String path = openDirectory();
        if(path != null) {
            ImageTrainer trainer =  ImageTrainer.getInstance();

            JDialog dlg = new JDialog(this, "Progress Dialog", true);
            dlg.setSize(300, 100);   
            dlg.setLocationRelativeTo(this);

            JOptionPane pane = new JOptionPane("Your message", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog(this, "Title");

            Thread t = new Thread()
            {
                public void run() {
                    trainer.trainingFromDir(path);
                }
            };
            t.start();

            new Thread()
            {
                public void run() {
                    dialog.setVisible(true);

                }
            }.start();

            while (t.isAlive()) {
            }
            dialog.dispose();

        }
    }

 

    private void openImage() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        openFail = false;
        
        FileNameExtensionFilter fExt = new FileNameExtensionFilter("BMP  (*.bmp), GIF  (*.gif), JPEG (*.jpg), PNG  (*.png)", 
                                                                    "bmp", "gif", "jpg", "png");
        String[] ext = fExt.getExtensions();
        chooser.setFileFilter(fExt);

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            openFail = true;
            return;
        }
        else if (result == JFileChooser.APPROVE_OPTION) {
            String dir = chooser.getSelectedFile().getPath();
            if (dir == null || dir.equals("")) {
                openFail = true;
                System.out.print("Archivo invalido, saliendo");
                System.exit((0));
            }
            try {
                engine.addImage(ImageIO.read(new File(dir)));               
            } 
            catch(OutOfMemoryError t) {
                openFail = true;
            }
            catch(IOException e) {
                openFail = true;
            }
            catch(Exception e) {
                openFail = true;
            }
        }
        return;
    }

    private String openDirectory() {
        File dir = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        openFail = false;

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            openFail = true;
        }
        else if (result == JFileChooser.APPROVE_OPTION) {
             dir = chooser.getSelectedFile();
            if (dir == null || dir.equals("")) {
                openFail = true;
                System.out.print("Archivo invalido, saliendo");
                System.exit((0));
            } else {
                System.out.print("Abriendo..." + dir.getAbsolutePath());

            }
        }
        return dir.getAbsolutePath();
     }

    private javax.swing.JProgressBar pBar =  new javax.swing.JProgressBar();

    private void parsingImages() {
        pBar.setIndeterminate(true);
    }
                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane imageOcontainer;
    private javax.swing.JScrollPane imageScontainer;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JLabel workedImg;
    private javax.swing.JLabel srcImg;

    private Filters engine;
    // End of variables declaration                   
}
