/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PreviewPanel.java
 *
 * Created on 03-feb-2014, 1:26:06
 */

package ac3texteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Jonatan
 */
public class PreviewPanel extends javax.swing.JPanel {
    BufferedImage image = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_BINARY);
    BufferedImage message;
    int requiredWidth = 256;
    int requiredHeight = 256;
    JPanel textLayer = new JPanel();

    /** Creates new form PreviewPanel */
    public PreviewPanel() {
        initComponents();
        this.setPreferredSize(new Dimension(256, 256));

        Graphics g2d = image.createGraphics();
        //g2d.setColor(new Color (55, 55, 140));
        g2d.setColor(new Color (0, 0, 0));
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        g2d.dispose();
        /*try {
            image = ImageIO.read(getClass().getClassLoader().getResource("resources/imgs/background.png"));
        } catch (IOException ex) {
            Logger.getLogger(PreviewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, requiredWidth, requiredHeight, this);
    }

    public void cleanText(){
        BufferedImage blank = new BufferedImage(requiredWidth, requiredHeight, BufferedImage.TYPE_BYTE_BINARY);
        writeText(blank);
    }

    private void displayText(){
        this.remove(textLayer);
        textLayer = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g; // Casting

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g);
                g2.drawImage(message, 0, 0, message.getWidth(), message.getHeight(), null);
                g2.dispose();
            }
        };
        textLayer.setBounds(0, 0, requiredWidth, requiredHeight);
        textLayer.setOpaque(false);
        this.add(textLayer);
        textLayer.repaint();
    }

    public void writeText(BufferedImage img){
        requiredHeight = img.getHeight();
        this.repaint();
        message = img;
        displayText();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}