//
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author joseph
 */
public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Decrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String s[] = {
              "c2543fff3bfa6f144c2f06a7de6cd10c0b650cae" //this 18 seconds 18512 milliseconds
//            "b47f363e2b430c0647f14deea3eced9b0ef300ce" //is 0 seconds 10 milliseconds
//            "e74295bfc2ed0b52d40073e8ebad555100df1380" // very 19 seconds 19103 milliseconds
//            "0f7d0d088b6ea936fb25b477722d734706fe8b40" // a while
//            "77cfc481d3e76b543daf39e7f9bf86be2e664959" // fail7 362 seconds 362935 milliseconds
//            "5cc48a1da13ad8cef1f5fad70ead8362aabc68a1"    //5you5 153 seconds 153288 milliseconds
//            "4bcc3a95bdd9a11b28883290b03086e82af90212"   //3crack 3610 seconds3610411milliseconds
//            "7302ba343c5ef19004df7489794a0adaee68d285" //1you1 64 seconds64347milliseconds
//            "21e7133508c40bbdf2be8a7bdc35b7de0b618ae4"   //00if00 863 seconds863863milliseconds
//            "6ef80072f39071d4118a6e7890e209d4dd07e504"
//            "02285af8f969dc5c7b12be72fbce858997afe80a"
//            "57864da96344366865dd7cade69467d811a7961b"
        };
        
        for(int i = 0; i < 1; i++) {
            timeStart();
            jTextArea1.append(bruteForceAlgo(s[i]));
            timeStop("showTime");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    //bruteForceAlgo
    //Params  : String hash
    //Returns : String
    //Desc    : Using a brute force algorithm to generate all possible
    //          hashes and then comparing that with a given hash
    public String bruteForceAlgo(String hash) {
        String[] a ={"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
                    "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};//alphabet ​
        System.out.println("Started");
        
        for (int n5=0; n5<37; n5++) {
            
            for (int n4=0; n4<37; n4++) {
                for (int n3=0; n3<37; n3++) {
                    for (int n2=0; n2<37; n2++) {
                        for (int n1=0; n1<37; n1++) {
                            for (int n0=0; n0<37; n0++) {
                                String possPass = a[n5]+a[n4]+a[n3]+a[n2]+ a[n1]+a[n0];
                                
                                if (genHash(possPass).equals(hash)) {
                                    return possPass;
                                }
                            }
                        }
                    }
                }
            }
            
        }

        return "Failed";
    }

    long timer = 0;

    void timeStart() {
        timer = System.currentTimeMillis();
    }

    void timeStop(String s) {
        timer = System.currentTimeMillis() - timer;
        if(s.equals("showTime")) {
            jTextArea1.append("Time taken is " + timer/1000 + " seconds" + timer +"milliseconds\n");
        }
    } 
    
    //genHash
    //Params  : String possiblePass
    //Returns : String
    //Desc    : generates hash using sha1
    public String genHash(String possiblePass) {
        String hold = "";
        try {
            hold = SHA1(possiblePass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hold;
    }
    
    //convertToHex
    //Params  : byte[] data
    //Returns : String
    //Desc    : Converts byte of data to string
    private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer(); 
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F; 
            int two_halfs = 0; 
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte)); 
                else 
                    buf.append((char) ('a' + (halfbyte - 10))); 
                halfbyte = data[i] & 0x0F; 
            } while(two_halfs++ < 1); 
        } 
        return buf.toString(); 
    } 

    //SHA1
    //Params  : String text
    //Returns : String
    //Desc    : Encrypts plaintext to ciphertext via SHA1
    public static String SHA1(String text)

    throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md;

        md = MessageDigest.getInstance("SHA-1");

        byte[] sha1hash = new byte[40];

        md.update(text.getBytes("iso-8859-1"), 0, text.length());

        sha1hash = md.digest();

        return convertToHex(sha1hash);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

