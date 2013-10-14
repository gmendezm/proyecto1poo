/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Aulas;

import java.util.Calendar;

public interface I_Aula {
    public String GetPerfil();
    public String getNombre();
    public String getNumero();
    public Calendar getHoraFecha();
    public void setHoraFecha_MHD(int M,int H,int D);
    public void setHoraFecha(Calendar _HoraFecha);
}
