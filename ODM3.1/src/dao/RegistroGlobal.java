/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fn.FnInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author sdx
 */
public class RegistroGlobal {
    public static String USERNAME = "";
    public static boolean LICENCIA = true;
    public static String EXP_DATE = "";
    public static String API_URI;
    public static String LOCAL_ID;
    public static String PASS;
    
    public static void initDataId() throws ParserConfigurationException, SAXException, IOException{
        try{
            File archivo = new File(System.getProperty("user.dir")+"\\files\\xml\\local.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(archivo);

            documento.getDocumentElement().normalize();
            NodeList filas = documento.getElementsByTagName("detalle");
            for (int temp = 0; temp < filas.getLength(); temp++) {
                Node nodo = filas.item(temp);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    LOCAL_ID = element.getElementsByTagName("id").item(0).getTextContent();
                    API_URI = dscrypt(element.getElementsByTagName("uri").item(0).getTextContent());
                    PASS = dscrypt(element.getElementsByTagName("port").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esta es una copia fraudulenta del software original.","Error de licencia",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void cargarRegistroGlobal(){
        try {
            
            File archivo = new File(System.getProperty("user.dir")+"\\files\\xml\\reg.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(archivo);
            
            documento.getDocumentElement().normalize();
            NodeList filas = documento.getElementsByTagName("usr");
            for (int temp = 0; temp < filas.getLength(); temp++) {
                Node nodo = filas.item(temp);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    USERNAME = element.getElementsByTagName("name").item(0).getTextContent();
                }
            }
            
            filas = documento.getElementsByTagName("lic");
            for (int temp = 0; temp < filas.getLength(); temp++) {
                Node nodo = filas.item(temp);
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nodo;
                    int st = Integer.parseInt(element.getElementsByTagName("st").item(0).getTextContent());
                    if(st == 1)
                        LICENCIA=true;
                    else
                        LICENCIA=false;
                    EXP_DATE = element.getElementsByTagName("date").item(0).getTextContent();
                }
            }
            if(isConnected()){
                if(readXMLOnline())
                    crearRegistroGlobal();
            }
            System.out.println("Class RegistroGlobal: Regisros cargados exitosamente.\nUSERNAME="+USERNAME+", LICENCIA="+LICENCIA+", EXP_DATE="+EXP_DATE);
        } catch (Exception e) {
            System.out.println("Class RegistroGlobal: Error al cargar Registros");
            JOptionPane.showMessageDialog(null, "Esta es una copia fraudulenta del software original.","Error de licencia",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void crearRegistroGlobal(){
         
         Document document = null;
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "reg", null);

            //Creación de elementos
            //creamos el elemento principal usr
            Element user = document.createElement("usr"); 
            //creamos un nuevo elemento. usr contiene name
            Element name= document.createElement("name");
            Text valorName = document.createTextNode(USERNAME); 
            
            Element lic = document.createElement("lic"); 
            //creamos un nuevo elemento. lic contiene st y date
            Element st= document.createElement("st");
            Element date= document.createElement("date");
            //Ingresamos la info. 
            Text valorSt;
            if(LICENCIA)
                valorSt = document.createTextNode("1");
            else
                valorSt = document.createTextNode("0");
            Text valorDate = document.createTextNode(EXP_DATE); 

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0"); 
            //Añadimos al usr al documento
            document.getDocumentElement().appendChild(user); 
            user.appendChild(name); 
            //Añadimos valor
            name.appendChild(valorName); 
            
            document.getDocumentElement().appendChild(lic);
            //Añadimos el elemento hijo a la raíz
            lic.appendChild(st);
            st.appendChild(valorSt);
            //Añadimos valor
            lic.appendChild(date); 
            date.appendChild(valorDate);
            
            guardaConFormato(document,System.getProperty("user.dir")+"\\files\\xml\\reg.xml");
         }catch(Exception e){
             System.err.println("Class RegistroGlobal: Error");
         }
    }
    
    // Volcamos XML al fichero
public static void guardaConFormato(Document document, String URI){
    try {
        TransformerFactory transFact = TransformerFactory.newInstance();

        //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
        transFact.setAttribute("indent-number", new Integer(3));
        Transformer trans = transFact.newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        //Hacemos la transformación
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        DOMSource domSource = new DOMSource(document);
        trans.transform(domSource, sr);

        //Mostrar información a guardar por consola (opcional)
        //Result console= new StreamResult(System.out);
        //trans.transform(domSource, console);
        try {
            //Creamos fichero para escribir en modo texto
            PrintWriter writer = new PrintWriter(new FileWriter(URI));

            //Escribimos todo el árbol en el fichero
            writer.println(sw.toString());

            //Cerramos el fichero
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
    }

    private static boolean isConnected(){
        String dirWeb = "www.softdirex.cl";
        int puerto = 80;
        try{
            Socket s = new Socket(dirWeb, puerto);
            if(s.isConnected()){
              System.out.println("Conexión establecida con la dirección: " +  dirWeb + " a travéz del puerto: " + puerto);
            }
        }catch(Exception e){
            System.err.println("No se pudo establecer conexión con: " + dirWeb + " a travez del puerto: " + puerto);
            return false;
        }
        return true;
    }
    
    
    private static boolean readXMLOnline() throws IOException, ParserConfigurationException, SAXException, TransformerConfigurationException, TransformerException {
        try{
            URL url = new URL(API_URI);
            //URLConnection conn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String entrada;
            String cadena="";

            while ((entrada = br.readLine()) != null){
                    cadena = cadena + entrada;
            }

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Document documento = db.parse(conn.getInputStream());
            InputSource archivo = new InputSource();
            archivo.setCharacterStream(new StringReader(cadena)); 

            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();
            documento.getDocumentElement().normalize();

            NodeList nodeLista = documento.getElementsByTagName("lic");

            for (int s = 0; s < nodeLista.getLength(); s++) {

                Node primerNodo = nodeLista.item(s);
                String id;
                int st;

                if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element primerElemento = (Element) primerNodo;

                    NodeList primerNombreElementoLista =
                                    primerElemento.getElementsByTagName("id");
                    Element primerNombreElemento =
                                    (Element) primerNombreElementoLista.item(0);
                    NodeList primerNombre = primerNombreElemento.getChildNodes();
                    id = ((Node) primerNombre.item(0)).getNodeValue().toString();
                    if(id.equals(LOCAL_ID)){
                        NodeList segundoNombreElementoLista =
                                    primerElemento.getElementsByTagName("st");
                        Element segundoNombreElemento =
                                    (Element) segundoNombreElementoLista.item(0);
                        NodeList segundoNombre = segundoNombreElemento.getChildNodes();

                        st = Integer.parseInt(((Node) segundoNombre.item(0)).getNodeValue().toString());
                        if(st == 1)
                            LICENCIA = true;
                        else
                            LICENCIA = false;
                        NodeList tercerNombreElementoLista =
                                    primerElemento.getElementsByTagName("date");
                        Element tercerNombreElemento =
                                        (Element) tercerNombreElementoLista.item(0);
                        NodeList tercerNombre = tercerNombreElemento.getChildNodes();
                        EXP_DATE = ((Node) tercerNombre.item(0)).getNodeValue().toString();

                    }
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static void setUser(String user) {
        USERNAME = user;
        crearRegistroGlobal();
    }

    private static String dscrypt(String textContent) {
        FnInfo load = new FnInfo();
        return load.desencriptar(textContent);
    }
}
