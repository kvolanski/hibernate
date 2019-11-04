package br.com.papayaSugar.main;

import br.com.papayaSugar.controller.LembreteController;
import br.com.papayaSugar.entity.Lembrete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Lembrete lembrete = new Lembrete();
        lembrete.setTitulo("Comprar feijão");
        lembrete.setDescricao("Não esquecer");

      //    LembreteController.salvar(entityManager, lembrete);
//        LembreteController.listar(entityManager);
//        LembreteController.findById(entityManager);

          LembreteController.findLike(entityManager);

    }




    }

