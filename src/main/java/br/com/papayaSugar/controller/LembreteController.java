package br.com.papayaSugar.controller;

import br.com.papayaSugar.entity.Lembrete;

import javax.persistence.EntityManager;

public class LembreteController {


    public static void salvar(EntityManager entityManager, Lembrete lembrete) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(lembrete);
            entityManager.getTransaction().commit();
            System.out.println("INSERT " + lembrete.getDescricao().toString() + " " + lembrete.getTitulo().toString());

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("INSERT: " + e.getMessage());
        } finally {
            entityManager.close();
        }

    }


    public static void listar(){



    }


}


