/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.entity;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tony
 */
@Entity /*Informa ao JAVAX que este Objeto é uam ENTIDADE*, foi criando PersisteUNIT com a DB******/
public class Todo {
    
    @Id    /*Informa ao JAVAX que isto é um ID*/
    @GeneratedValue(strategy = GenerationType.AUTO)/*Gera automaticamente o Id na DB */
    private Long id;
    
    /* ***************************Anotações de Validações da Entidade************************/
    @NotEmpty(message = "Task must be set")
    @Size(min = 10, message = "Task should not be less than 10 characters")
    private String task;
    
    @NotNull(message = "DueDate must be set")
    @FutureOrPresent(message = "DueDate must be in the present or future") /*Valida que somente datas presente ou futuras sejam setadas*/
    @JsonbDateFormat(value = "yyyy-MM-dd")/*Esta a Anotação set o formato da dado, por estarmos usando Json, formataremos no padrão JSON*/
    private LocalDate dueDate;
    
    private boolean  isCompleted;
    private LocalDate dateCompleted;
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
