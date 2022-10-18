/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.rest;

import academy.learnprogramming.entity.Todo;
import academy.learnprogramming.service.TodoService;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tony
 */

/* 1º Por a Anotação do @PATH onde mostra o ENDPOINT a ser acessodo depois do ROOTPATH*/
/* 2º Por a Anotação @CONSUMES, onde convertemos o Binario em JSON*/
/* 3º Por a Anotação @PRODUCE, onde convertemos o Binario em JSON*/
/* 4º Injetar o serviço usando a Anotação @INJECT é a mesma coisa do @Autowired do Spring*/
/* 5º Criar os Metodos com a Anotação @RESPONSE */
/* 6ª Usar as Anotações de acordo com o Verbo HTTP, @POST, @PUT, @GET, @DELETE*/
/* 7º Usar a Anotação @PathParam("id") quando temos um PARAMENTRO no PATH, Iqual ao SPRINGBOOT*/
@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)/*2-B Quando o todoService RECEBER o dado do Metodo CreateTodo, esta anotação vai transformar em Json*/
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {
    
     @Inject
     TodoService todoService;
     
     @Path("new")
     @POST
     public Response createTodo(Todo todo) {
      /* api/v1/todo/new este será o ENDPOINT */  
      todoService.createTodo(todo);
      
      return Response.ok().build();
     }
     
     @Path("update")
     @PUT
     public Response updateTodo(Todo todo ){
         /* api/v1/todo/update este será o ENDPOINT */  
      todoService.update(todo);
      
       return Response.ok().build();     
     }
   
     
     @Path("{id}")
     @GET
     @SuppressWarnings("empty-statement")
     public Todo getTodo(@PathParam("id") Long id) {
         Todo todoById =  todoService.findTodoById(id);
         if(todoById == null) {
          return null;
         };
       
         return todoById;
    }
     
     
    @Path("list")
    @GET
    public List<Todo> getAllTodos() {
    return todoService.getAllTodo();
    
    }
    
    
    @Path("status")
    @POST
    public Response makeAsComplete(@QueryParam("id")Long id) { 
        Todo todo = todoService.findTodoById(id);
        todo.setIsCompleted(true);
        todoService.update(todo);
        return  Response.ok(todo).build();
    }
     
  
    
}
