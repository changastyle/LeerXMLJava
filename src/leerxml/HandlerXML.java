
package leerxml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class HandlerXML 
{
        private File archivo;
        
        public HandlerXML(String rutaAlArchivo)
        {
                 archivo = new File(rutaAlArchivo);
        }
        public String leer(String tag)
        {
                String respuesta = "";
                if(     archivo.exists()     )
                {
                         try 
                        {
                                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                                Document doc = dBuilder.parse(archivo);
                                //System.out.println("Elemento Raiz -> " + doc.getDocumentElement().getNodeName());
                                
                               NodeList nList = doc.getElementsByTagName(        doc.getDocumentElement().getNodeName()       );
                                //System.out.println("LENGTH DE LA RAIZ = " + nList.getLength() );
                               
                                Element element = (Element) nList.item(0);
                                
                                respuesta = "" +  element.getElementsByTagName(tag).item(0).getTextContent() ;
                        }
                        catch(Exception e)
                        {
                                e.printStackTrace();
                                System.out.println("ERROR: LEYENDO ARCHIVO XML." );
                        }
                }
                else
                {
                        System.out.println("ERROR: NO EXISTE EL ARCHIVO.");
                }
                return respuesta;
        }
}