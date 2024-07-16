import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException, JSONException, SAXException, ParserConfigurationException {

        /*---------------  Sélection du fichier XML via une interface graphique ------------------ */

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Sélectionnez le fichier XML");
            int result = chooser.showOpenDialog(null);
            if (result != JFileChooser.APPROVE_OPTION) {
                System.out.println("Aucun fichier sélectionné, arrêt du programme.");
                return;
            }
            File xmlFile = chooser.getSelectedFile();


        /*--------------- Récupérer le fichier XML  ------------------ */

        javax.xml.parsers.DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document domDocument = dBuilder.parse(xmlFile);
        DOMBuilder domBuilder = new DOMBuilder();
        Document xml = domBuilder.build(domDocument);

        /*------------------- Récupérer l'element Root  ------------------ */

        Element root =xml.getRootElement();

        /*----------------  Convertir en Json ------------------ */

        JSONObject jsondata = convertXml.XmlToJson(root);

        /*----------------  Enrgistrer le fichier Json ----------------*/

        String str1= jsondata.toString(2) ;
        Random rand = new Random();
        int i= rand.nextInt(100);
        BufferedWriter output =new BufferedWriter(new FileWriter("C:\\Users\\zekoh\\Desktop\\json test\\Xml_to_json"+i+".json"));
        output.write(str1);
        output.flush();

        /*-------------------------------------------------------------*/

        output.close();
        System.out.println("<----------------------------------> ");
        System.out.println(str1);


    }
}



