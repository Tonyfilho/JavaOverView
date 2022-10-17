/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.service;

import academy.learnprogramming.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Tony
 */

@Transactional /*Esta anotação transforma a class java em um Server do JavaEE*/
public class TodoService {
    
    @PersistenceContext /*1ª temos que INJETAR a Gerenciado de DB o ENTITYMANAGER*/
    EntityManager entityManager; /*2º Cria a Instacia do tipo EntityManager */
    
    /* *************************** Metodos ************************ */
    public Todo createTodo(Todo todo) {        
        entityManager.persist(todo);
        return todo;        
    }
    
    public Todo update(Todo todo) {        
        entityManager.merge(todo);
        return todo;        
    }
       
    public Todo findTodoById(Long id) {        
      return entityManager.find(Todo.class,id);
                
    }
    
    public List<Todo> getAllTodo() {
        return  entityManager.createQuery("SELECT  t from Todo t", Todo.class).getResultList();        
    }
     
    
    
    
    
}
