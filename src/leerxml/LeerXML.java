package leerxml;
public class LeerXML 
{
        public static void main(String[] args) 
        {
                HandlerXML  handlerXML = new HandlerXML("config.xml");
                System.out.println( handlerXML.leer("importeMinimoPorApuesta")  );
        }
        
}
