package lemon.tool.validation.util;

import java.io.IOException;

import lemon.tool.validation.exception.CTDataValidationException;

public class ContentConverter {
//    private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();
//    private ContentConverter() {}
//    
//    public static <T> T unmarshal(String jsonStr, Class<T> clazz) throws CTDataValidationException {
//        T returnObj = null;
//        if(null != jsonStr && !jsonStr.isEmpty() && null != clazz) {
//            try {
//                returnObj = OBJ_MAPPER.readValue(jsonStr, clazz);
//            } catch (JsonParseException e) {
//                e.printStackTrace();
//            } catch (JsonMappingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        // do validation check.
//        if(null != returnObj){
//            ValidatorUtil.validate(returnObj);
//        }
//        return returnObj;
//    }
//    
//    public static String marshal(Object obj) throws CTDataValidationException {
//        // do validation check.
////        if(null != obj){
////            ValidatorUtil.validate(obj);
////        }
//        String returnVal = "";
//        if(null != obj) {
//            try {
//                returnVal = OBJ_MAPPER.writeValueAsString(obj);
//            } catch (JsonGenerationException e) {
//                e.printStackTrace();
//            } catch (JsonMappingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        return returnVal;
//    }
}
