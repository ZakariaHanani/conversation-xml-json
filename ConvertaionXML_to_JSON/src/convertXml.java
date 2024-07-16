import org.jdom.Attribute;
import org.jdom.Element;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public abstract class convertXml {
    public static JSONObject XmlToJson(Element element) throws JSONException {

       //Creer un object json pour Stocker les les informations extraites

        JSONObject jsonObject =new JSONObject() ;

        // extraiter les attrebutes

        List<Attribute> attributes = element.getAttributes();
        if(!attributes.isEmpty())
        {
            for (Attribute attribute : attributes)
            {
                jsonObject.put("@" + attribute.getName(), attribute.getValue());
            }
        }



        // extraiter les elementes

        JSONArray jsonArray = new JSONArray();
        if (element.getChildren().isEmpty()) {
            jsonObject.put(element.getName(),element.getTextTrim());
        }
        else {
            convertXmlToJson(element, jsonArray);
            jsonObject.put(element.getName(), jsonArray);
        }
        return jsonObject;
    }

    private static void convertXmlToJson(Element element, JSONArray jsonArray) throws JSONException
    {
        List<Element> children=element.getChildren();
        for ( Element child : children )
        {
            JSONObject childObject = XmlToJson( child);
            jsonArray.put(childObject);
        }
    }
}
