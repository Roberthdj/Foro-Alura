
package com.alura.foro.util;

import java.util.HashMap;
import java.util.Map;

public class Util {

    //  Mensaje para codigo de respuesta 404
    public Map<String, String> message404() {
        Map<String, String> data = new HashMap<>();
        data.put("message", "The requested resource does not exist");
        return data;
    }

}
