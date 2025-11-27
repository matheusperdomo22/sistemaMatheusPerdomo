/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;  




/**
 *
 * @author u1845853
 */
public class mcp_util {
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
            
        }
    }
    
    public static void limpar(JComponent ... componentes){
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
        }
        
    }
    
  

public static void mensagem(String cad){
    JOptionPane.showMessageDialog(null, cad);
}
public static boolean pergunta(String cad){
    int resposta = JOptionPane.showConfirmDialog(null, cad, "Confirmação", JOptionPane.YES_NO_OPTION);
    return resposta == JOptionPane.YES_OPTION;
}
public static int strToInt(String num) {
        return Integer.valueOf(num);
    }
    public static String intToStr(int num) {
        return String.valueOf(num);
    }    
    
    public static double strToDouble(String num) {
       return Double.parseDouble(num);
    }
    public static String doubleToStr(double num) {
         return String.valueOf(num);
    }
        
    public static Date strToDate(String data) {
         if (data == null || data.trim().isEmpty() || data.equals("__/__/____")) {
        return new Date(); // ← RETORNA DATA ATUAL SE ESTIVER VAZIO
    }
    try {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(data);
    } catch (ParseException ex) {
        System.out.println("Erro ao converter data: " + data);
        return new Date(); 
    }
    }
    public static String dateToStr(Date data) {
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/YYYY");
        return fm.format(data);
    }
    
    }