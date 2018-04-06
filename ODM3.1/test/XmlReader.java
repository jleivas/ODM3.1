/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author jorge
 */
public class XmlReader {

public static void main(String argv[]) {

try {
    URL url=
    new URL("https://sites.google.com/site/falfiles/Home/archivos/ejemplo.xml");
    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
    String entrada;
    String cadena="";

    while ((entrada = br.readLine()) != null){
            cadena = cadena + entrada;
    }

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();

    InputSource archivo = new InputSource();
    archivo.setCharacterStream(new StringReader(cadena)); 

    Document documento = db.parse(archivo);
    documento.getDocumentElement().normalize();

    NodeList nodeLista = documento.getElementsByTagName("descarga");
    System.out.println("Informacionos libros");

    for (int s = 0; s < nodeLista.getLength(); s++) {

            Node primerNodo = nodeLista.item(s);
            String titulo;
            String autor;
            String hits;

            if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

            Element primerElemento = (Element) primerNodo;

            NodeList primerNombreElementoLista =
                            primerElemento.getElementsByTagName("titulo");
            Element primerNombreElemento =
                            (Element) primerNombreElementoLista.item(0);
            NodeList primerNombre = primerNombreElemento.getChildNodes();
            titulo = ((Node) primerNombre.item(0)).getNodeValue().toString();
            System.out.println("Titulo" + titulo);

            NodeList segundoNombreElementoLista =
                            primerElemento.getElementsByTagName("autor");
            Element segundoNombreElemento =
                            (Element) segundoNombreElementoLista.item(0);
            NodeList segundoNombre = segundoNombreElemento.getChildNodes();

            autor = ((Node) segundoNombre.item(0)).getNodeValue().toString();
            System.out.println("Autor" + autor);

            NodeList tercerNombreElementoLista =
                            primerElemento.getElementsByTagName("hits");
            Element tercerNombreElemento =
                            (Element) tercerNombreElementoLista.item(0);
            NodeList tercerNombre = tercerNombreElemento.getChildNodes();
            hits = ((Node) tercerNombre.item(0)).getNodeValue().toString();
            System.out.println("Hits" + hits);

            }
          }
      }
      catch (Exception e) {
            e.printStackTrace();
      }
     }

}
