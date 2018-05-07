/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Acquaintance.ICase;
import java.io.File;
import java.util.ArrayList;
import Acquaintance.ICaseOpening;
import Acquaintance.IEnquiry;
import Business.Enquiry;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Antonio
 */
public class EnquiryData {
    private List<IEnquiry> EN;
    private File file = new File("EN.obj");
    public ArrayList<Enquiry> EnquiryList = new ArrayList<>();

EnquiryData() throws IOException  {
    if(!file.exists()) {
        EN = new ArrayList<>(); 
        saveList();
    } else {
        readList();
    }
}
private void saveList() throws IOException {
    ObjectOutputStream ggg  = null; 
    try {
        ggg = new ObjectOutputStream(new FileOutputStream(file));
        ggg.writeObject(EN);
     } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ggg.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
private void readList() {
        ObjectInputStream gg = null;
        try {
            gg = new ObjectInputStream(new FileInputStream(file));
            Object obj = gg.readObject();
            EN =  (List<IEnquiry>) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public List<IEnquiry> getEnquiryList() {
        return EN;
    }
}  

