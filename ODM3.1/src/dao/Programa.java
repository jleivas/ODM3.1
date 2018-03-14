package dao;


import dao.InfoDao;
import entities.Cliente;
import entities.Ficha;
import entities.HistorialPago;
import entities.Info;
import fn.FnTipoPago;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





public class Programa extends JFrame
{
	
        private Info institucion;
        
	//CONSTRUCTOR DE LA CLASE
	public Programa(Ficha ficha) throws SQLException, ClassNotFoundException
	{
            DecimalFormat formateador = new DecimalFormat("###,###,###"); 
                                InfoDao dao=new InfoDao();
                                Info info=new Info();
                                
                                
                            try {
                               info=dao.getInstitucion();
                                //////espacios
                            } catch (SQLException ex) {
                                info.setId(0);
                                info.setNombre("");
                                info.setDireccion("");
                                info.setCiudad("");
                                info.setTelefono("");
                                info.setCelular(""); 
                                info.setMail("");
                                info.setWeb("");
                            } catch (ClassNotFoundException ex) {
                                info.setId(0);
                                info.setNombre("");
                                info.setDireccion("");
                                info.setCiudad("");
                                info.setTelefono("");
                                info.setCelular(""); 
                                info.setMail("");
                                info.setWeb("");
                            }
                                String formatoAbono = obtenerFormatoAbono(ficha.getId());
                                ///////////////////////////FECHAS
                                DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                                String fecha = date.format(ficha.getFecha());
                                String fecha_entrga=date.format(ficha.getFechaEntrega());
                                //////////////////////////FIN FECHAs
                                String endurecidoLejos="";String capaLejos="";String plusMaxLejos="";
                                if(ficha.getLejos().getEndurecido()==1){endurecidoLejos="X";}
                                if(ficha.getLejos().getCapa()==1){capaLejos="X";}
                                if(ficha.getLejos().getPlusMax()==1){plusMaxLejos="X";}
                                String endurecidoCerca="";String capaCerca="";String plusMaxCerca="";
                                if(ficha.getCerca().getEndurecido()==1){endurecidoCerca="X";}
                                if(ficha.getCerca().getCapa()==1){capaCerca="X";}
                                if(ficha.getCerca().getPlusMax()==1){plusMaxCerca="X";}
                                
                                String impresion[]=
                                {
                                 fecha//0
                                ,ficha.getId()+""//1
                                ,ficha.getLugarEntrega()//2
                                ,fecha_entrga//3
                                ,ficha.getCliente().getNombre()//4
                                ,ficha.getLejos().getCristal()//5
                                ,ficha.getLejos().getOdEsf()//6
                                ,ficha.getLejos().getOiEsf()//7
                                ,ficha.getLejos().getDp()+""//8
                                ,endurecidoLejos//9
                                ,capaLejos//10
                                ,plusMaxLejos//11----fin lejos
                                ,ficha.getCerca().getCristal()//12
                                ,ficha.getCerca().getOdEsf()//13
                                ,ficha.getCerca().getOiEsf()//14
                                ,ficha.getCerca().getDp()+""//15
                                ,endurecidoCerca//16
                                ,capaCerca//17
                                ,plusMaxCerca//18
                                ,ficha.getObservacion()//19
                                ,"$"+formateador.format (ficha.getValorTotal())//20
                                ,formatoAbono//21
                                ,"$"+ formateador.format (ficha.getSaldo())//22
                                ,ficha.getHoraEntrega()//23
                                ,ficha.getLejos().getMarca()//24
                                ,ficha.getCerca().getMarca()//25
                                ,info.getNombre()//26
                                ,info.getWeb()//27
                                ,info.getDireccion()+"-"+info.getCiudad()//28
                                ,info.getMail()+"/"+info.getTelefono()+"-"+info.getCelular()//29
                                ,ficha.getLejos().getOdCil()//30 desde aqui
                                ,ficha.getLejos().getOdA()//31
                                ,ficha.getLejos().getOiCil()//32
                                ,ficha.getLejos().getOiA()//33
                                ,ficha.getCerca().getOdCil()//34
                                ,ficha.getCerca().getOdA()//35
                                ,ficha.getCerca().getOiCil()//36
                                ,ficha.getCerca().getOiA()//37
                                ,ficha.getCerca().getAdd()//38
                                ,obtenerFormatoCliente(ficha.getCliente())//39
                                ,obtenerFormatoDireccionCliente(ficha.getCliente())//40
                                ,"TOTAL: $"+formateador.format (ficha.getValorTotal())+", ABONO: "+formatoAbono+", SALDO: $"+ formateador.format (ficha.getSaldo())//41
                                
                                };
                                
                                imprimir(impresion); 
                                
                     
 
 
 
	}//FIN DEL CONSTRUCTOR
 
	//FIN DEL MAIN
        public void imprimir(String[] impresion){
             try {
                                imprimir_Cita(impresion);
                                
                                

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "La impresion se ha cancelado", "", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
        
        }
        
        
        public void imprimir_Cita(String [] text)
        {
        int calibracion = -18;
        int calibracion1 = -30;
        int calibracion0 = -13;
        int calibracion2 = -3;
        int calibracion3 = -50;
        int calibracionObs = 0;
            
        Frame f = new Frame ("Imprimir");
        f.pack();
        PrintJob pjob = f.getToolkit().getPrintJob(f,"Impresion del Registro",null);
        Graphics pg = pjob.getGraphics();
                            // fuente  ,          , tamaño de la fuente
        pg.setFont(new Font ("Arial", Font.ITALIC, 10)); 
         //dibuja el string guardado en el objeto texto de la clase String, y lo sitúa en la posición cuyas coordenadas vienen dadas por los dos números enteros que le siguen.
                                 //x , y //el aumenta 20 por fila    //81
           pg.drawString(text[0], 105, (80+calibracion1));//fecha
           pg.drawString(text[1], 465, (80+calibracion1));//folio
           pg.drawString(text[2], 150, (100+calibracion1));//lugar_entrega
           pg.drawString(text[3], 465, (100+calibracion1));//fecha_entrega
           pg.drawString(text[39], 123, (119+calibracion1));//datos_cliente
           pg.drawString(text[40], 123, (130+calibracion1));//direccion_cliente
           pg.setFont(new Font ("Arial", Font.BOLD, 10)); 
           pg.drawString(text[41], 123, (141+calibracion1));//valor_total
           pg.setFont(new Font ("Arial", Font.ITALIC, 10)); 
           pg.drawString(text[24], 123, (147+calibracion));//lejos_marca------inicio lejos
           pg.drawString(text[5], 123, (158+calibracion));//lejos_cristal
           pg.drawString(text[6], 123, (169+calibracion));//OD_ESF
           pg.drawString(text[30], 175, (170+calibracion));//OD_CIL
           pg.drawString(text[31], 290, (170+calibracion));//OD_A
           pg.drawString(text[7], 123, (180+calibracion));//OI_ESF
           pg.drawString(text[32], 175, (180+calibracion));//OI_CIL
           pg.drawString(text[33], 290, (180+calibracion));//OI_A
           pg.drawString(text[8], 123, (192+calibracion));//DP_cristal
           pg.setFont(new Font ("Verdana", Font.BOLD, 10));// X
           pg.drawString(text[9], 280, (192+calibracion));//endurecido_cristal
           pg.drawString(text[10],345, (192+calibracion));//capa_cristal
           pg.drawString(text[11],430, (192+calibracion));//plis_max_cristal ----fin lejos
           pg.setFont(new Font ("Arial", Font.ITALIC, 10));
           pg.drawString(text[25], 123, (230+calibracion0));//cerca_marca------inicio cerca
           pg.drawString(text[12], 123, (241+calibracion0));//cerca_cristal
           pg.drawString(text[38], 465, (241+calibracion0));//ADD
           pg.drawString(text[13], 123, (252+calibracion0));//OD_cristal
           pg.drawString(text[34], 175, (252+calibracion0));//OD_CIL
           pg.drawString(text[35], 293, (252+calibracion0));//OD_A
           pg.drawString(text[14], 123, (263+calibracion0));//OI_cristal
           pg.drawString(text[36], 175, (263+calibracion0));//OI_CIL
           pg.drawString(text[37], 293, (263+calibracion0));//OI_A
           pg.drawString(text[15], 123, (274+calibracion0));//DP_cristal
           pg.setFont(new Font ("Verdana", Font.BOLD, 10));// X
           pg.drawString(text[16], 280, (274+calibracion0));//endurecido_cristal
           pg.drawString(text[17],345, (274+calibracion0));//capa_cristal
           pg.drawString(text[18],430, (274+calibracion0));//plusmax_cristal ----fin cerca
           pg.setFont(new Font ("Arial", Font.ITALIC, 10));
           pg.drawString(text[19],70, (327+calibracionObs));//observacion
           pg.drawString(text[0], 105, (502+calibracion2));//fecha
           pg.drawString(text[1], 460, (502+calibracion2));//folio
           pg.setFont(new Font ("Elephant", Font.BOLD, 15));
           pg.drawString(text[26], 250, (532+calibracion2));//Institucion nombre
           pg.setFont(new Font ("Calibri", Font.ITALIC, 10));
           pg.drawString(text[27], 205, (547+calibracion2));//Institucion web
           pg.drawString(text[28], 205, (558+calibracion2));//Institucion direccion
           pg.drawString(text[29], 205, (569+calibracion2));//Institucion contacto
           pg.setFont(new Font ("Arial", Font.ITALIC, 10));
           pg.drawString(text[4], 270, (585+calibracion2));//nombre_cliente
           pg.drawString(text[20], 270, (603+calibracion2));//valor_total
           pg.drawString(text[21], 270, (614+calibracion2));//abono
           pg.setFont(new Font ("Arial", Font.BOLD, 10));
           pg.drawString(text[22], 270, (625+calibracion2));//saldo
           pg.setFont(new Font ("Arial", Font.ITALIC, 10));
           pg.drawString(text[3], 58, (715+calibracion3));//fecha_entrega
           pg.drawString(text[2], 190, (715+calibracion3));//lugar_entrega
           pg.drawString(text[23], 480, (715+calibracion3));//hora
          
           pg.dispose();
           pjob.end();
           f.setVisible(false);
        }

    private String obtenerFormatoAbono(int idFicha) throws SQLException, ClassNotFoundException {
        DecimalFormat formateador = new DecimalFormat("###,###,###"); 
        HistorialPagoDao hpd = new HistorialPagoDao();
        FnTipoPago tp = new FnTipoPago();
        int largo = hpd.listar(idFicha).size();
        int monto = 0;
        int idTipoPago = 0;
        if(largo==0)
            return "No existen abonos registrados.";
        
        for (HistorialPago temp : hpd.listar(idFicha)) {
            monto =  monto + temp.getAbono();
            idTipoPago =  temp.getIdTipoPago();
        }
        if(largo > 1){
            return "$"+formateador.format (monto)+" ("+largo+" Abonos registrados)";
        }
        return "$"+formateador.format (monto)+" ("+tp.cargar(idTipoPago).getNombre()+")";
    }

    private String obtenerFormatoCliente(Cliente cliente) {
        if(cliente != null){
            String datosCliente = cliente.getNombre();
            if(cliente.getTelefono() != null){
                if(cliente.getTelefono().length()>7){
                    datosCliente =  datosCliente + " - Teléfono: "+cliente.getTelefono();
                }
            }
            return datosCliente;
        }else{
            return "Sin datos del cliente";
        }
        
    }

    private String obtenerFormatoDireccionCliente(Cliente cliente) {
        String datos = "";
        if(cliente != null){
            if(cliente.getDireccion()!=null){
                datos = cliente.getDireccion();
            }
            if(cliente.getComuna()!=null){
                if(cliente.getComuna().length()>3){
                    datos = datos + ", Comuna: "+cliente.getComuna();
                }
                return datos;
            }
            return "No existe información";
        }else{
            return "Sin datos de dirección del cliente";
        }
    }
 
 
}//FIN DE LA CLASE PRINCIPAL
