/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Tony
 */
/* 1� Extender a class Application de JAVAX.WS:CORE*/
/* 2� Por a anota��o do PATH e passar o caminho ROOT da aplica��o */
@ApplicationPath("api/v1")
public class TodoConfig extends Application {
    
}
