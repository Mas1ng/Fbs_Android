package com.example.fbs_android.xml;

import com.example.fbs_android.dto.ErrorDto;
import com.example.fbs_android.dto.FbsDto;
import com.example.fbs_android.dto.ViagemListDto;
import com.example.fbs_android.model.Viagem;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

public class XmlHandler {
    public static FbsDto deSerializeXML2FbsDto(String xmlData) {
        FbsDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(FbsDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    public static ErrorDto deSerializeXML2ErrorDto(String xmlData) {
        ErrorDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(ErrorDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    public static String serializeErrorDto2XML(ErrorDto data) {
        StringWriter writer = new StringWriter();
        if (data != null) {
            Serializer serializer = new Persister();
            try {
                serializer.write(data, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return writer.toString();
    }
    public static ViagemListDto deSerializeXML2ViagemListDto(String xmlData) {
        ViagemListDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(ViagemListDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
