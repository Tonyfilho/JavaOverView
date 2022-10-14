/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

/**
 *
 * @author Tony
 */
@Entity /*Informa ao JAVAX que este Objeto é uam ENTIDADE*/
public class Todo {
    
    @Id    /*Informa ao JAVAX que isto é um ID*/
    @GeneratedValue(strategy = GenerationType.AUTO)/*Gera automaticamente o Id na DB */
    private Long id;
    
    private String task;
    private boolean  isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dueDate;
    private LocalDate dateCreated;
    
    
    /* Iniciando a data */
    @PrePersist  /* este Life-Cycle transforma este Metodo em Entity Lifecycle Callback e ja vai para dentro da DB a informação setada*/
    private void init() {
        setDateCreated(LocalDate.now());
    }
    

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    
    
}
