/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import sistem.informasi.data.lowongan.pekerjaan.Aplikasi;
import sistem.informasi.data.lowongan.pekerjaan.Perusahaan;
import view.MainMenu;
import view.TambahPerusahaan;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendex
 */
public class ControllerTambahPerusahaan implements ActionListener {

    TambahPerusahaan tambahperusahaan;
   // ArrayList<Perusahaan> listPerusahaan = new ArrayList<>();
Aplikasi app;
    public ControllerTambahPerusahaan(Aplikasi app) {
        this.app= app;
                
        this.tambahperusahaan = new TambahPerusahaan();
        this.tambahperusahaan.setVisible(true);

        this.tambahperusahaan.getTambahButton().addActionListener(this);
        this.tambahperusahaan.getBackButton().addActionListener(this);

    }
//    void setListPerusahaan(ArrayList<Perusahaan> listPerusahaan) {
//        this.listPerusahaan = listPerusahaan;
//    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();

        if (x.equals(tambahperusahaan.getTambahButton())) {
            String namaPemilik = tambahperusahaan.getNamaPemilik().getText();
            String namaPerusahaan = tambahperusahaan.getNamaPerusahaan().getText();
            //listPerusahaan.add(new Perusahaan(namaPemilik, namaPerusahaan));
            app.getListPerusahaan().add(new Perusahaan(namaPemilik, namaPerusahaan));
            JOptionPane.showMessageDialog(null, app.getListPerusahaan().size());
        } else if(x.equals(tambahperusahaan.getBackButton())){
                this.tambahperusahaan.setVisible(false);
                
                ControllerPerusahaan cmm = new ControllerPerusahaan(app);
               
//                cmm.showData();
            }
            
        }
    }

    

    
    
    


