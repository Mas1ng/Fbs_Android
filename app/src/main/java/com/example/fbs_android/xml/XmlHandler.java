package com.example.fbs_android.xml;

import com.example.fbs_android.dto.*;
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
    public static BilheteNumLugarDto deSerializeXML2BilheteNumLugarDto(String xmlData) {
        BilheteNumLugarDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(BilheteNumLugarDto.class, xmlData);
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
    public static String serializeNumLugarNomeViagemDto2XML(NumLugarNomeViagemDto data) {
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
    public static BilheteListNumLugarDto deSerializeXML2BilheteListNumLugarDto(String xmlData) {
        BilheteListNumLugarDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(BilheteListNumLugarDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    public static BilheteItemListDto deSerializeXML2BilheteItemListDto(String xmlData) {
        BilheteItemListDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(BilheteItemListDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static String serializeClienteDto2XML(ClienteDto data) {
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
    public static ClienteListDto deSerializeXML2ClienteListDto(String xmlData) {
        ClienteListDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(ClienteListDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    public static ClienteDto deSerializeXML2ClienteDto(String xmlData) {
        ClienteDto data = null;
        if(xmlData != null){
            Serializer serializer = new Persister();
            try {
                data = serializer.read(ClienteDto.class, xmlData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
