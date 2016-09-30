/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import com.google.gson.Gson;
import entity.Person;


/**
 *
 * @author kann
 */
public class conversion {
    
    public static void main(String[] args) {
        
        String json = "{\"firstName\":\"Ole\",\"lastName\":\"Olsen\",\"phoneNumber\":12345678}";
        
        
        
        
        
        Person p1 = new Gson().fromJson(json, Person.class);
    }
    
}
