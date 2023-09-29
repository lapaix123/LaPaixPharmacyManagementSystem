/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import javax.swing.JOptionPane;
import dao.BillsLocation;
import java.io.File;

/**
 *
 * @author djlap
 */
public class OpenPdf {

    public static void openById(String id) {
        try {
            if ((new File(BillsLocation.billpath + id + ".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + BillsLocation.billpath + " " + id + ".pdf");
            } else {
                JOptionPane.showMessageDialog(null, "file is not Exist");
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
