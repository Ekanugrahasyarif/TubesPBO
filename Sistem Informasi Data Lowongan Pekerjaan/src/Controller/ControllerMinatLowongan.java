/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistem.informasi.data.lowongan.pekerjaan.Aplikasi;
import view.TambahLowongan;
import view.minatlowongan;

/**
 *
 * @author A455LN
 */
public class ControllerMinatLowongan implements ActionListener{
    
    Aplikasi app;
    minatlowongan ml;
    
    public ControllerMinatLowongan(Aplikasi ap){
        this.app = ap;
        this.ml = new minatlowongan();
        this.ml.setVisible(true);
        
        this.ml.getKembaliButton().addActionListener(this);
        this.ml.getDaftarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if(x.equals(ml.getDaftarButton())){
            String namaPerusahaan = ml.getNamaperusahaan().getText();
//            String idPelamar = ml.getIdPelamar().getText();
            String namaPelamar = ml.getNamaPelamar().getText();
            String idBerkas = ml.getIdBerkas().getText();
            String jenisPekerjaan = ml.getJenisPekerjaan().getText();
           
           app.getPerusahaan(namaPerusahaan).getLowongan(jenisPekerjaan).addBerkas(app.getPelamar(namaPelamar).getBerkas(idBerkas));
                   //addBerkas(getPelamar(namaPelamar).getBerkas(idBerkas));
            JOptionPane.showMessageDialog(null, "BERHASIL!");
        }
        else if(x.equals(ml.getKembaliButton())){
            ControllerPelamar cp = new ControllerPelamar(app);
        }
    }
    
}